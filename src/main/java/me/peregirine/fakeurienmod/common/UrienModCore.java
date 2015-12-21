package me.peregirine.fakeurienmod.common;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import me.peregirine.fakeurienmod.client.ClientSideProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;

/*
 * The main class of UrienMod
 * @author Demitto,Dr.Zombie,Hayabusa
 *
 * Last change date 2015/12/21
 * コメント文が多く見づらいかと思いますが，これは初心者の方に少しでも分かりやすくすることを心がけているためですので，ご容赦ください．
 */

//modidの指定．＠Modアノテーションをつけることでmodとして認識される．
@Mod(modid = "me.peregrine.Urienmod", name = "Urienmod")

public class UrienModCore {
	//追加するアイテムのインスタンスを保持する変数を宣言．
	public static Item uriensword;
	public static Item hanyudasoba;
	public static Item hanyumen;
	
	public static final Item.ToolMaterial BLUE = EnumHelper.addToolMaterial("BLUE", 0, 150, -5.0F, -5.0F, 30  );
	
	//クライアント，サーバー間で異なる処理を行わせるためのプロキシーの設定．
	@SidedProxy(clientSide = "me.peregirine.fakeurienmod.client.ClientSideProxy", 
				serverSide = "me.peregirine.fakeurienmod.common.CommonSideProxy")
	public static CommonSideProxy proxy;
	public static ClientSideProxy clientproxy;
	
	//エンティティIDの上限を設定．
	public static int entityIdHead = 170;
	
	//新規クリエイティブタブの処理．変数にTabCreateHandlerのインスタンスの生成，代入
	//本当は定数なので全て大文字が良いのですが．
	public final CreativeTabs tabUrien = new TabCreateHandler("UrienMod");
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
	//宇理炎ソードの設定．ItemUrienSwordのインスタンスの生成．
	uriensword =( new ItemUrienSword(BLUE))
	//クリエイティブタブに追加，英語名の設定，テクスチャの指定，GameRegistryに登録 のそれぞれのメソッドの呼び出し．
		.setCreativeTab(this.tabUrien)
		.setUnlocalizedName("UrienSword")
		.setTextureName("urienmod:uriensword");
		GameRegistry.registerItem(uriensword, "UrienSword");

		//宇理炎ソードの右クリックで発射されるエンティティを登録．
		EntityRegistry.registerModEntity(EntityBullet.class, "Arrow",entityIdHead, this, 128, 5, true);
		proxy.registerRenderers();
		
	//ここから食べ物二種の登録処理．
	
	//はにゅうだそばの登録．
	hanyudasoba = (new ItemFood(0, 0.0F, false))
			//食べた際の即死効果はsetPotionEffectを呼び出して設定しています．引数にダメージポーションを指定．
			.setPotionEffect(Potion.harm.id, 30, 10, 1.0F)
			.setUnlocalizedName("hanyudaSoba")
			.setTextureName("urienmod:hanyudasoba")
			.setCreativeTab(this.tabUrien);
			
	//はにゅうめんの登録．即死＆全ロス効果をつけるためはにゅうだそばとは違い，独自に定義したインスタンスを生成しています．
	hanyumen = (new ItemHanyumen(0, 0.0F, false))
			.setUnlocalizedName("hanyuMen")
			.setTextureName("urienmod:hanyumen")
			.setCreativeTab(this.tabUrien);  

	//GameRegistryへの登録．
	GameRegistry.registerItem(hanyudasoba, "Hanyudasoba");
	GameRegistry.registerItem(hanyumen, "Hanyumen");
	}


	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
	//ここからはそれぞれのレシピの登録をしています．
	GameRegistry.addRecipe(new ItemStack(UrienModCore.uriensword,1),
		"DBD",
		"III",
		"GGG",
		'D',Items.diamond,
		'B',Blocks.diamond_block,
		'I',Items.iron_ingot,
		'G',Items.gold_ingot
			);
	
	GameRegistry.addShapelessRecipe(new ItemStack(hanyudasoba),
		       Items.wheat,
		       Items.sugar,
		       Blocks.brown_mushroom,
		       //ここでItemStackを利用しているのは，”水入り瓶”はポーションのメタデータ指定しないものとして扱われているためです．
		       new ItemStack(Blocks.tallgrass,0,1),
		       new ItemStack(Items.potionitem)
			);
	
	GameRegistry.addShapelessRecipe(new ItemStack(hanyumen),
		       Items.wheat,
		       Items.sugar,
		       Blocks.brown_mushroom,
		       new ItemStack(Blocks.tallgrass,0,1),
		       new ItemStack(Items.potionitem,1,8201)
		       );

	//アイテムの表示名を登録しています．
			LanguageRegistry.addName(uriensword, "Urien Sword");
			LanguageRegistry.instance().addNameForObject(uriensword, "ja_JP", "宇理炎ソード");
			
			LanguageRegistry.addName(hanyumen, "Hanyu Men");
			LanguageRegistry.instance().addNameForObject(hanyumen, "ja_JP", "はにゅうめん");
			
			LanguageRegistry.addName(hanyudasoba, "Hanyuda Soba");
			LanguageRegistry.instance().addNameForObject(hanyudasoba, "ja_JP", "はにゅうだそば");
			
		
	}


	}

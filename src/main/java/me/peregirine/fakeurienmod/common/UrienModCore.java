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
 * @author Hayabusa
 */
/*
 * れぎん氏のWiki（Bow)を元にやや大きい変更を行いました＿ぞんび
 *
 */
//modidにドメイン名に変更．
@Mod(modid = "me.peregrine.Urienmod", name = "Urienmod")

public class UrienModCore {
	//まず不要な@Instanceをコメントアウト
	//@Instance("Urienmod")
	//protected static UrienModCore instance;

	//postInitでの謎のItemUrienSwordの処理を削除。＿ぞんび
	public static Item uriensword;
	public static Item hanyudasoba;
	public static Item hanyumen;
	//れぎん氏のWikiを元に攻撃力を設定している。-5.0Fで0を下回っているためノックバックすらない。-4.0Fで通常攻撃力_ぞんび
	public static final Item.ToolMaterial BLUE = EnumHelper.addToolMaterial("BLUE", 0, 150, -5.0F, -5.0F, 30  );

	@SidedProxy(clientSide = "me.peregirine.fakeurienmod.client.ClientSideProxy", serverSide = "me.peregirine.fakeurienmod.common.CommonSideProxy")
	public static CommonSideProxy proxy;
	public static ClientSideProxy clientproxy;

	public static int entityIdHead = 170;
	
	//TabCreateHandlerにtab名を投げてクリエティブタブを作成
	public static final CreativeTabs tabUrien = new TabCreateHandler("UrienMod");

	@Mod.EventHandler

	public void preInit(FMLPreInitializationEvent event){
	 //これで新規クラスが読み込めるはず
	uriensword =( new ItemUrienSword(BLUE))
		.setCreativeTab(this.tabUrien)
		.setUnlocalizedName("UrienSword")
		//テクスチャへのパスは全て小文字である必要があります＿ぞんび
		.setTextureName("urienmod:uriensword");
		GameRegistry.registerItem(uriensword, "UrienSword");
	//public static UrienModCore instanse;

	EntityRegistry.registerModEntity(EntityBullet.class, "Arrow",
				entityIdHead, this, 128, 5, true);
	proxy.registerRenderers();
	
	//ここからは追加アイテム
	/*
	 * １つのポーション効果を持たせる場合
	 * setPotionEffectは必ず最初にやること
	 * setPotionEffectの引数は(ポーションID, 効果時間(秒), ポーションの効果レベル, この効果が発動する確率)
	 */
	
	//処理に成功＿ぞんび
	hanyudasoba = (new ItemFood(0, 0.0F, false))
			.setPotionEffect(Potion.harm.id, 30, 10, 1.0F)
			.setUnlocalizedName("hanyudaSoba")
			.setTextureName("urienmod:hanyudasoba")
			.setCreativeTab(this.tabUrien);
	//ItemHanyumenに投げる
	hanyumen = (new ItemHanyumen(0, 0.0F, false))
			//.setPotionEffect(Potion.harm.id, 30, 10, 1.0F)
			.setUnlocalizedName("hanyuMen")
			.setTextureName("urienmod:hanyumen")
			.setCreativeTab(this.tabUrien);  


	GameRegistry.registerItem(hanyudasoba, "Hanyudasoba");
	GameRegistry.registerItem(hanyumen, "Hanyumen");
	}

	//RecipeRegister.classでの登録がうまくいっていないようなのでCoreで処理する形に変更＿ぞんび
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
	GameRegistry.addRecipe(new ItemStack(UrienModCore.uriensword,1),
		"DBD",
		"III",
		"GGG",
	'D',Items.diamond,
	'B',Blocks.diamond_block,
	'I',Items.iron_ingot,
	'G',Items.gold_ingot
	);
	
	//はにゅうめんとはにゅうだそばのレシピ処理。水入り瓶はPotionItem
	GameRegistry.addShapelessRecipe(new ItemStack(hanyudasoba),
		       Items.wheat,
		       Items.sugar,
		       Blocks.brown_mushroom,
		       new ItemStack(Blocks.tallgrass,0,1),
		       new ItemStack(Items.potionitem)

		       );
	//ダメージ9にすることで力のポーションを指定している
	/*しかしここで問題があります。
	 * ここで確かに力のポーションを指定できているのですが、そのポーションは外見こそバニラと同じですが
	 * クリエイティブタブにあるものや醸造でできるものとはどこかが違うようです。
	 * 実際、1,9のpotionitemを生成する別のレシピを作成し、それで生成された力のポーションで
	 * このレシピを使うと、はにゅうめんができます
	 * しかし、クリエイティブや醸造のものは、見た目はまったく同じですができませんでした
	 * 原因不明なので解決策募集中です＿ぞんび
	 */
	GameRegistry.addShapelessRecipe(new ItemStack(hanyumen),
		       Items.wheat,
		       Items.sugar,
		       Blocks.brown_mushroom,
		       new ItemStack(Blocks.tallgrass,0,1),
		       new ItemStack(Items.potionitem,1,9)
		       );

	
	
	//表示名の登録
			LanguageRegistry.addName(uriensword, "Urien Sword");
			LanguageRegistry.instance().addNameForObject(uriensword, "ja_JP", "宇理炎");
			
			LanguageRegistry.addName(hanyumen, "Hanyu Men");
			LanguageRegistry.instance().addNameForObject(hanyumen, "ja_JP", "はにゅうめん");
			
			LanguageRegistry.addName(hanyudasoba, "Hanyuda Soba");
			LanguageRegistry.instance().addNameForObject(hanyudasoba, "ja_JP", "羽生蛇蕎麦");
			
		
	}


	}

package me.peregirine.fakeurienmod;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

/*
 * The main class of UrienMod
 * @author Hayabusa
 */
/*
 * れぎん氏のWiki（Bow)を元にやや大きい変更を行いました＿ぞんび
 * 
 */
@Mod(modid = "Urienmod", name = "Urienmod")

public class UrienModCore {
	//まず不要な@Instanceをコメントアウト
	//@Instance("Urienmod")
	//protected static UrienModCore instance;
	
	//postInitでの謎のItemUrienSwordの処理を削除。＿ぞんび
	public static Item uriensword;
	//れぎん氏のWikiを元に攻撃力を設定している。-5.0Fで0を下回っているためノックバックすらない。-4.0Fで通常攻撃力_ぞんび
	public static final Item.ToolMaterial BLUE = EnumHelper.addToolMaterial("BLUE", 0, 150, -5.0F, -5.0F, 30  );

	@Mod.EventHandler

	public void preInit(FMLPreInitializationEvent event){
	 //これで新規クラスが読み込めるはず
	uriensword =( new ItemUrienSword(BLUE))
		.setCreativeTab(CreativeTabs.tabCombat)
		.setUnlocalizedName("UrienSword")
		//テクスチャへのパスは全て小文字である必要があります＿ぞんび
		.setTextureName("urienmod:uriensword");
		GameRegistry.registerItem(uriensword, "UrienSword");
	//public static UrienModCore instanse;
	
	EntityRegistry.registerModEntity(EntityBullet.class, "Arrow",
				entityIdHead, this, 128, 5, true);
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
	//表示名の登録
			LanguageRegistry.addName(uriensword, "Urien Sword");
			LanguageRegistry.instance().addNameForObject(uriensword, "ja_JP", "宇理炎?");

	}
	
	
	}

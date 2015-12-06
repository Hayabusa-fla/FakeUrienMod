package me.peregirine.fakeurienmod;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/*
 * The main class of UrienMod
 * @author Hayabusa
 */
/*
 * れぎん氏のWiki（Bow)を元にやや大きい変更を行いました
 * 
 */
@Mod(modid = "Urienmod", name = "Urienmod")

public class UrienModCore {
	//まず不要な@Instanceをコメントアウト
	//@Instance("Urienmod")
	//protected static UrienModCore instance;
	
	//postInitでの謎のItemUrienSwordの処理を削除。
	public static Item uriensword;

	@Mod.EventHandler

	public void preInit(FMLPreInitializationEvent event){
	 //これで新規クラスが読み込めるはず
	uriensword =( new ItemUrienSword(Item.ToolMaterial.EMERALD))
		.setCreativeTab(CreativeTabs.tabCombat)
		.setUnlocalizedName("UrienSword")
		//テクスチャへのパスは全て小文字である必要があります
		.setTextureName("urienmod:uriensword");
		GameRegistry.registerItem(uriensword, "UrienSword");
	//public static UrienModCore instanse;
	}

	
	}
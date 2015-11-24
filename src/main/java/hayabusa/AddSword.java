package main.java.hayabusa;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*
 *剣の追加処理のクラス。ItemSwordを継承
 */

public class AddSword extends ItemSword
{
	public AddSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		
	}

	public static Item ItemUrienSword;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*剣の追加、ダメージと耐久値の指定*/
		ItemUrienSword = new ItemSword(Item.ToolMaterial.EMERALD);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("UrienSword");
		setTextureName("Urienmod:uriensword");
		
		this.setMaxStackSize(1);
		this.setMaxDamage(1562);
		this.damage = 0;
	}

	
	//つくりかけ
	public static Item itemWeapon;
	private float damage;
	
	}

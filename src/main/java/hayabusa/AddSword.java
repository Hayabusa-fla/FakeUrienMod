package main.java.hayabusa;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*
 *���̒ǉ������̃N���X�BItemSword���p��
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
		/*���̒ǉ��A�_���[�W�Ƒϋv�l�̎w��*/
		ItemUrienSword = new ItemSword(Item.ToolMaterial.EMERALD);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("UrienSword");
		setTextureName("Urienmod:uriensword");
		
		this.setMaxStackSize(1);
		this.setMaxDamage(1562);
		this.damage = 0;
	}

	
	//���肩��
	public static Item itemWeapon;
	private float damage;
	
	}

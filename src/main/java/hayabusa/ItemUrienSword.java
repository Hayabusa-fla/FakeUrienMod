package hayabusa;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*
 *���̒ǉ������̃N���X�BItemSword���p��
 */

public class ItemUrienSword extends ItemSword
{
	public ItemUrienSword(ToolMaterial p_i45356_1_) {
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
	}
		public static Item itemWeapon;{
		this.setMaxStackSize(1);
		this.setMaxDamage(1562);
		this.damage = 0;
		
	}

	private float damage;
	{
		
	}
	
	

	public boolean onLeftClick()
	{
		if 
	}
	
}
	
	//���肩��
	/*
	
	}*/

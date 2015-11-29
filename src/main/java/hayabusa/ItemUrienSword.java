package hayabusa;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*
 *剣の追加処理のクラス。ItemSwordを継承
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
		/*剣の追加、ダメージと耐久値の指定*/
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
	/*ここらへんはもぢんぐwikiコピペ．*/
	
	//右クリックをやめた時の動作．
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
	//「クリエイティブモードか」どうかを判定させる．
		boolean flag1 = ( par3EntityPlayer.capabilities).isCreativeMode ( par1ItemStack) > 0;
	}
	//
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
 
        return par1ItemStack;
    }
	//右クリック時のアニメーション，バニラ弓のものを使用．
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
}
	
	//つくりかけ
	/*
	
	}*/

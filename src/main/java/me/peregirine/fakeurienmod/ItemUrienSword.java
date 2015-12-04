package hayabusa;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

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
	//後半の( par1ItemStack) > 0;でメソッド未指定のエラーがあったため、Wikiのクリエ判定(1.6だけど)を元に修正_ぞんび
	//必要な部分だったらｽﾐﾏｾﾝ
	//もしかして:par5EntityPlayer.capabilities.isCreativeMode && itemstack.stackSize > 0  ??
		boolean flag1 = ( par3EntityPlayer.capabilities).isCreativeMode;
	}
	//
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		//ウィザーの効果をPotionで付与できるのではないかという希望_ぞんび
		//以下Wikiより引用↓
		//PotionのID
				int potionID = Potion.wither.id;
		 
				//Potionの効果時間（【20tick ≒ 1秒】なので*20）
				int duration = 20 * 20;
		 
				//PotionのLv
				int amplifier = 2;
		 
				//PotionEffectの設定
				PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);
		 
				//PotionEffect(Effect)がEntityPlayerに付与されているかの判定
				boolean isMoveSpeed = par3EntityPlayer.isPotionActive(Effect.getPotionID());
		 
				//PotionEffect(Effect)がEntityPlayerに付与されていない場合
				if( !isMoveSpeed )
				{
					//Itemを振る動作
					par3EntityPlayer.swingItem();
		 
					//ダメージ値を【1】増やす
					//ここはお好みで_ぞんび
					par1ItemStack.damageItem(1, par3EntityPlayer);
		 
					//PotionEffect(Effect)をEntityPlayerに付与
					par3EntityPlayer.addPotionEffect(Effect);
				}
//↑ここまでコピペ
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

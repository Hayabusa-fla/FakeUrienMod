package me.peregirine.fakeurienmod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemUrienSword extends ItemSword
{
	/*
	 *剣の追加処理のクラス。ItemSwordを継承*/
	/*
	 * ポーションによるウィザー効果処理がすっかり消えてたので足しました
	 * 編集するときはちゃんとCloneしてもらえるとこちらとしては助かります。
	 * Creativeの判定も同じ。せめてJava構文エラーは回避してくだされば＿ぞんび
	 */
	/*
	public ItemUrienSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		
	}
    */
	
	//明示的コンストラクター
	public ItemUrienSword(ToolMaterial p_i45356_1_) {
	super(p_i45356_1_);
	
}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		
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
    	//以下はWikiの1.6の発射体Entity追加を参考にしました_ぞんび
		//par4は右クリックの押下時間。
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
	//「クリエイティブモードか」どうかを判定させる．
		final boolean   isCreativeMode;
		boolean flag1 =  (par3EntityPlayer.capabilities).isCreativeMode; 
		
		   //右クリック押下時間をもとに計算。20で割り（単位を秒に変換）、なにやら二次関数的な計算式に入れている。
        //ここではバニラ弓のまま使っているが、独自の計算式でも良いと思います。
        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
 
        //タメ時間が一定以下の場合、何も起こさず処理から抜ける。
        if ((double)f < 0.0D)
        {
            return;
        }
 
        //fの上限値。
        if (f > 1.0F)
        {
            f = 1.0F;
        }
 //独自Entityの代わりにバニラのウィザー弾を呼び出している。末尾の数字はとりあえず0にしている＿ぞんび
 //EntityWitherSkull bullet = new EntityWitherSkull(par2World,par3EntityPlayer, 0, 0, 0);
 //explosionArrowとfireArrowは気にしないでください めんどくさいから消してないだけ_でみっと
 ExplosionArrow = false;
 FireArrow = false;
 EntityBullet bullet = new EntityBullet(par2World, par3EntityPlayer, 2F, ExplosionArrow, FireArrow);//発射処理
        //音を呼び出す部分。適切な音が無いのでコメントアウト 
        //par2World.playSoundAtEntity(par3EntityPlayer, "mob.villager.idle", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
 
        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(bullet);
        }
    }
 
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	return par1ItemStack;
    }
	 /*
     * 右クリックでの使用（タメ）時間の上限。
     */
   public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
 

	
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

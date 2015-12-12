package me.peregirine.fakeurienmod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHanyumen extends ItemFood{

	public ItemHanyumen(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);

	}
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {

	//forが終わるまでがアイテム消去処理。お風呂に入ってたら思いつきました。　でみっと
		for (int i = 0; i < 36; i++){
			 ItemStack item = par3EntityPlayer.inventory.mainInventory[i];
			 if(item != null)
				 par3EntityPlayer.inventory.clearInventory(item.getItem(), -1);
			 
	//ダメージが上手く付与されて無いみたいなので、この方法で追加
			 int potionID = Potion.harm.id;

				//Potionの効果時間（【20tick ≒ 1秒】なので*20）
				int duration = 20 * 20;

				//PotionのLv
				int amplifier = 10;

				//PotionEffectの設定
				PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);

             //PotionEffect(Effect)がEntityPlayerに付与されているかの判定
             boolean isMoveSpeed = par3EntityPlayer.isPotionActive(Effect.getPotionID());

             //PotionEffect(Effect)がEntityPlayerに付与されていない場合
             if( !isMoveSpeed )
             {
                  //Itemを振る動作
                 par3EntityPlayer.swingItem();

                  //ダメージ値を1増やす
                 //ここはお好みで_ぞんび
                 //par1ItemStack.damageItem(1, par3EntityPlayer);

                 //PotionEffect(Effect)をEntityPlayerに付与
                 par3EntityPlayer.addPotionEffect(Effect);
                   }
		}

		return par1ItemStack;

	}


}

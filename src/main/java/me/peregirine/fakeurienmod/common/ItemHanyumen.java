package me.peregirine.fakeurienmod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/*
 * はにゅうめんの実際の挙動を設定するクラスです．
 */

public class ItemHanyumen extends ItemFood{

	public ItemHanyumen(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);

	}
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
	//インベントリアイテムの消去処理．
		for (int i = 0; i < 36; i++){
			 ItemStack item = par3EntityPlayer.inventory.mainInventory[i];
			 if(item != null)
				 par3EntityPlayer.inventory.clearInventory(item.getItem(), -1);
			 	
			 	//ダメージを与える．
			 	//Potionの効果時間
			 	int potionID = Potion.harm.id;
			 	//PotionのLv
				int duration = 20 * 20;
				//PotionEffectの設定
				int amplifier = 10;

				//PotionEffectの設定
				PotionEffect Effect = new PotionEffect(potionID, duration, amplifier);

				//PotionEffect(Effect)がEntityPlayerに付与されているかの判定用変数．
				boolean isMoveSpeed = par3EntityPlayer.isPotionActive(Effect.getPotionID());

			//PotionEffect(Effect)がEntityPlayerに付与されていない場合
             if( !isMoveSpeed )
             {
            	 //Itemを振る動作
                 par3EntityPlayer.swingItem();
                 //ダメージ値を1増やす
                 par3EntityPlayer.addPotionEffect(Effect);
                   }
		}

		return par1ItemStack;

	}


}

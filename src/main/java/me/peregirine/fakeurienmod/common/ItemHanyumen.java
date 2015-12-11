package me.peregirine.fakeurienmod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ItemHanyumen extends ItemFood{

	public ItemHanyumen(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		this.setPotionEffect(Potion.harm.id, 30, 10, 1.0F)
		.setUnlocalizedName("hanyuMen")
		.setTextureName("urienmod:hanyumen")
		.setCreativeTab(UrienModCore.tabUrien);
	}
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {

	//forが終わるまでがアイテム消去処理。お風呂に入ってたら思いつきました。　でみっと
		for (int i = 0; i < 36; i++){
			 ItemStack item = par3EntityPlayer.inventory.mainInventory[i];
			 if(item != null)
				 par3EntityPlayer.inventory.clearInventory(item.getItem(), -1);
		}

		return par1ItemStack;

	}


}

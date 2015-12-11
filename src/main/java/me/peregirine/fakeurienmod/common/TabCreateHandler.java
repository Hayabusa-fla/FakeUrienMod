package me.peregirine.fakeurienmod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabCreateHandler extends CreativeTabs{

	public TabCreateHandler(String label) {
		super(label);
	}
	@Override
	public Item getTabIconItem() {
		return new ItemStack(UrienModCore.uriensword, 1, 0).getItem();
	}

}

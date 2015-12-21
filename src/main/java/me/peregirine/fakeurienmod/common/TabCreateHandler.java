package me.peregirine.fakeurienmod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * 新規クリエイティブタブの登録処理クラスです．
 * 
 */
public class TabCreateHandler extends CreativeTabs{
	public TabCreateHandler(String label) {
		super(label);
	}
	
	//タブのアイコンを指定．getTabIconItemをオーバーライドして戻り値に宇理炎ソードのアイコンを指定しています．
	@Override
	public Item getTabIconItem() {
		return new ItemStack(UrienModCore.uriensword, 1, 0).getItem();
	}
	
	//タブの表示名を指定．getTranslatedTabLabelをオーバーライドして戻り値を変更．
	@Override
	public String getTranslatedTabLabel()
	{
		return "UrienMod";
	}
}

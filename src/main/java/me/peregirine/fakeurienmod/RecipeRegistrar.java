package me.peregirine.fakeurienmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/*
 * ���̃��V�s�w��N���X�BCore�N���X���p���B	�c������K�v�Ȃ��H���[�񕪂���Ȃ��B
 */

public class RecipeRegistrar extends UrienModCore {

	public void preInit(FMLInitializationEvent event){
	}
	@Mod.EventHandler
	public void postinit(FMLInitializationEvent event){
	GameRegistry.addRecipe(new ItemStack(UrienModCore.uriensword,1),
		"DBD",
		"III",
		"GGG",
	'D',Items.diamond,
	'B',Blocks.diamond_block,
	'I',Items.iron_ingot,
	'G',Items.gold_ingot
	);
	}

}

/*init�ł̓o�^
	public void init(FMLInitializationEvent event){
	GameRegistry.addRecipe(new ItemStack(ItemUrienSword.ItemUrienSword,1),
	"DBD",
	"III",
	"GGG",
	'D',Items.diamond,
	'B',Blocks.diamond_block,
	'I',Items.iron_ingot,
	'G',Items.gold_ingot
	);
	}
	*/



/*�ȉ��̂����ł̎������@�킩�炸.
 *Character=valueOf('DB'),"blockDiamond",
 *new Object[]{"D","DB","I","G"
 */
package hayabusa;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * ���̃��V�s�w��N���X�BCore�N���X���p���B	�c������K�v�Ȃ��H���[�񕪂���Ȃ��B
 */

public class SwordRecipe extends Core {

	public void preInit(FMLInitializationEvent event){
	}
	@Mod.EventHandler
	public void postinit(FMLInitializationEvent event){
	GameRegistry.addRecipe(new ItemStack(AddSword.ItemUrienSword,1),
		"IBI",
		"III",
		"GGG",
	'I',Items.diamond,
	'B',Blocks.diamond_block,
	'I',Items.iron_ingot,
	'G',Items.gold_ingot
	);
	}

	


	public void init(FMLInitializationEvent event){
	GameRegistry.addRecipe(new ItemStack(AddSword.ItemUrienSword,1),
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


/*�ȉ��̂����ł̎������@�킩�炸.
 *Character=valueOf('DB'),"blockDiamond",
 *new Object[]{"D","DB","I","G"
 */
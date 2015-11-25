package hayabusa;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * 剣のレシピ指定クラス。Coreクラスを継承。	…させる必要ない？うーん分からない。
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


/*以下のやり方での実装方法わからず.
 *Character=valueOf('DB'),"blockDiamond",
 *new Object[]{"D","DB","I","G"
 */
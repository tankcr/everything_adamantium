package tankcmod.evadamant.recipes;


import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tankcmod.evadamant.ModBlocks;
import tankcmod.evadamant.ModItems;

/**
 * Created by KRoy.Local on 9/23/2016.
 */
public class ADMTRecipes {

    public static void init(){
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.adpowderItem), ModBlocks.admtOre);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.admtSack, 1), new Object[] { " D ", " D ", "   ", 'D', ModItems.adpowderItem});
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.admtBlock, 1), new Object[] { "AAA", "AAA", "AAA", 'A', ModItems.admtIngot});
        GameRegistry.addSmelting(ModItems.admtSack, new ItemStack(ModItems.admtIngot), 0.9f);
    }
}

package tankcmod.evadamant.recipes;


import net.minecraft.init.Items;
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
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.admtClaw, 1), new Object[] { " A ", " A ", " A ", 'A', ModItems.admtIngot});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ironBracket, 1), new Object[] { "   ", "III", "DDD", 'I', Items.IRON_INGOT, 'D', Items.DIAMOND});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.admtClaws, 1), new Object[] { "   ", "CCC", " I ", 'C', ModItems.admtClaw, 'I', ModItems.ironBracket});
        GameRegistry.addSmelting(ModItems.admtSack, new ItemStack(ModItems.admtIngot), 0.9f);
    }
}

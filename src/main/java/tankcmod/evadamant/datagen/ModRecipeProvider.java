package tankcmod.evadamant.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import tankcmod.evadamant.ModRegistry;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // 1. Smelting: Adamantium Ore -> Adamantium Ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModRegistry.ADMT_ORE_ITEM.get()), RecipeCategory.MISC,
                        ModRegistry.ADMT_INGOT.get(), 1.0f, 200)
                .unlockedBy("has_admt_ore", has(ModRegistry.ADMT_ORE_ITEM.get()))
                .save(pWriter, "adamantium_ingot_from_smelting");

        // 2. Shaped Recipe: Adamantium Block (9 Ingots)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModRegistry.ADMT_BLOCK_ITEM.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter);

        // 3. Shapeless Recipe: Adamantium Block -> 9 Ingots
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.ADMT_INGOT.get(), 9)
                .requires(ModRegistry.ADMT_BLOCK_ITEM.get())
                .unlockedBy("has_admt_block", has(ModRegistry.ADMT_BLOCK_ITEM.get()))
                .save(pWriter, "adamantium_ingot_from_block");

        // Add shaped recipes for your Claws, Brackets, and Pickaxe following the pattern in Step 2.
    }
}
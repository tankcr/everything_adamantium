package tankcmod.evadamant.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // 1. 9 Adamantium Powder -> 1 Adamantium Sack (3x3 grid)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModRegistry.ADMT_SACK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModRegistry.ADMT_POWDER.get())
                .unlockedBy("has_admt_powder", has(ModRegistry.ADMT_POWDER.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_sack_from_powder");

        // 2. 1 Adamantium Sack -> 9 Adamantium Powder (Shapeless unpack)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.ADMT_POWDER.get(), 9)
                .requires(ModRegistry.ADMT_SACK.get())
                .unlockedBy("has_admt_sack", has(ModRegistry.ADMT_SACK.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_powder_from_sack");

        // 3. Smelting (Furnace): 1 Adamantium Sack -> 1 Adamantium Ingot (200 ticks)
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModRegistry.ADMT_SACK.get()), RecipeCategory.MISC,
                        ModRegistry.ADMT_INGOT.get(), 1.0f, 200)
                .unlockedBy("has_admt_sack", has(ModRegistry.ADMT_SACK.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_ingot_from_smelting_sack");

        // 4. Blasting (Blast Furnace / Smeltry): 1 Adamantium Sack -> 1 Adamantium Ingot (100 ticks)
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModRegistry.ADMT_SACK.get()), RecipeCategory.MISC,
                        ModRegistry.ADMT_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_admt_sack", has(ModRegistry.ADMT_SACK.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_ingot_from_blasting_sack");

        // 5. 9 Adamantium Ingots -> 1 Adamantium Block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModRegistry.ADMT_BLOCK_ITEM.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_block_from_ingots");

        // 6. 1 Adamantium Block -> 9 Adamantium Ingots
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModRegistry.ADMT_INGOT.get(), 9)
                .requires(ModRegistry.ADMT_BLOCK_ITEM.get())
                .unlockedBy("has_admt_block", has(ModRegistry.ADMT_BLOCK_ITEM.get()))
                .save(pWriter, ModEvAdamant.MODID + ":adamantium_ingots_from_block");

        // Adamantium Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModRegistry.ADMT_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter);

        // Adamantium Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModRegistry.ADMT_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter);

        // Adamantium Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModRegistry.ADMT_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter);

        // Adamantium Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModRegistry.ADMT_PICK.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModRegistry.ADMT_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_admt_ingot", has(ModRegistry.ADMT_INGOT.get()))
                .save(pWriter);
    }
}
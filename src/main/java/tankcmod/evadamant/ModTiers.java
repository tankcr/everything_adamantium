package tankcmod.evadamant;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    // Scaled slightly above Diamond (1561 uses, 8.0F speed, 3.0F damage)
    public static final ForgeTier ADAMANTIUM = new ForgeTier(
            4,
            1600,
            8.5F,
            3.0F,
            14, // Slightly better enchantability than Diamond's 10
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModRegistry.ADMT_INGOT.get())
    );

    // Kept your original legacy X3 stats (3000 uses, 12.0F speed, 12.0F damage)
    public static final ForgeTier ADAMANTIUM_X3 = new ForgeTier(
            5,
            3000,
            12.0F,
            12.0F,
            34,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModRegistry.ADMT_INGOT.get())
    );
}
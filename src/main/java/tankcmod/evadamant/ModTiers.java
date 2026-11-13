package tankcmod.evadamant;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    // Base Adamantium Tier (Matches your old 1561 uses, 6.0F speed, 3.0F damage)
    public static final ForgeTier ADAMANTIUM = new ForgeTier(
            4, // Legacy Harvest Level 4 (above Diamond)
            1561,
            6.0F,
            3.0F,
            10,
            BlockTags.NEEDS_DIAMOND_TOOL, // Modern equivalent of harvest level checking
            () -> Ingredient.of(ModRegistry.ADMT_INGOT.get()) // Repair item
    );

    // X3 Adamantium Tier (Matches your old 3000 uses, 12.0F speed, 12.0F damage)
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
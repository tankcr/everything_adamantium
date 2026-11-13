package tankcmod.evadamant.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import tankcmod.evadamant.ModRegistry;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Storage block drops itself
        this.dropSelf(ModRegistry.ADMT_BLOCK.get());

        // Ore drops 1 Adamantium Powder (supports Silk Touch & Fortune automatically)
        this.add(ModRegistry.ADMT_ORE.get(),
                block -> createOreDrop(ModRegistry.ADMT_ORE.get(), ModRegistry.ADMT_POWDER.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
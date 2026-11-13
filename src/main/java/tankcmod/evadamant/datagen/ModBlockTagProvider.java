package tankcmod.evadamant.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModEvAdamant.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Required for pickaxes to harvest these blocks
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModRegistry.ADMT_BLOCK.get(), ModRegistry.ADMT_ORE.get());

        // Requires at least a Diamond Pickaxe (replaces legacy harvest level 3)
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModRegistry.ADMT_BLOCK.get(), ModRegistry.ADMT_ORE.get());

        // Cross-mod compatibility tags (replaces legacy OreDictionary)
        this.tag(Tags.Blocks.ORES)
                .add(ModRegistry.ADMT_ORE.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(ModRegistry.ADMT_BLOCK.get());
    }
}
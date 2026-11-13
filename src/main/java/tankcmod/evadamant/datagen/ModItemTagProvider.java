package tankcmod.evadamant.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ModEvAdamant.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Items.INGOTS)
                .add(ModRegistry.ADMT_INGOT.get());
        this.tag(Tags.Items.ORES)
                .add(ModRegistry.ADMT_ORE_ITEM.get());
        this.tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModRegistry.ADMT_BLOCK_ITEM.get());
    }
}
package tankcmod.evadamant.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModEvAdamant.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // This automatically generates the BlockState JSON, the Block Model JSON,
        // and the Item Model JSON for the block, assuming textures exist at
        // assets/modevadamant/textures/block/adamantium_block.png
        simpleBlockWithItem(ModRegistry.ADMT_BLOCK.get(), cubeAll(ModRegistry.ADMT_BLOCK.get()));
        simpleBlockWithItem(ModRegistry.ADMT_ORE.get(), cubeAll(ModRegistry.ADMT_ORE.get()));
    }
}
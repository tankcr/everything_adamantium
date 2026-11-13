package tankcmod.evadamant.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModEvAdamant.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Standard flat items (uses "item/generated" parent)
        simpleItem(ModRegistry.ADMT_INGOT);
        simpleItem(ModRegistry.ADMT_POWDER);
        simpleItem(ModRegistry.ADMT_SACK);
        simpleItem(ModRegistry.IRON_BRACKET);

        // Tools/Weapons (uses "item/handheld" parent so they render correctly in the player's hand)
        handheldItem(ModRegistry.ADMT_PICK);
        handheldItem(ModRegistry.ADMT_CLAW);
        handheldItem(ModRegistry.ADMT_CLAWS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModEvAdamant.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ModEvAdamant.MODID, "item/" + item.getId().getPath()));
    }
}
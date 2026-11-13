package tankcmod.evadamant.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModRegistry;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, ModEvAdamant.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        addBlock(ModRegistry.ADMT_BLOCK, "Adamantium Block");
        addBlock(ModRegistry.ADMT_ORE, "Adamantium Ore");

        // Items
        addItem(ModRegistry.ADMT_INGOT, "Adamantium Ingot");
        addItem(ModRegistry.ADMT_POWDER, "Adamantium Powder");
        addItem(ModRegistry.ADMT_SACK, "Adamantium Sack");
        addItem(ModRegistry.IRON_BRACKET, "Iron Bracket");

        // Tools & Weapons
        addItem(ModRegistry.ADMT_PICK, "Adamantium Pickaxe");
        addItem(ModRegistry.ADMT_CLAW, "Adamantium Claw");
        addItem(ModRegistry.ADMT_CLAWS, "Adamantium Claws");
        addItem(ModRegistry.ADMT_SHOVEL, "Adamantium Shovel");
        addItem(ModRegistry.ADMT_AXE, "Adamantium Axe");
        addItem(ModRegistry.ADMT_HOE, "Adamantium Hoe");

        // Creative Tab & Tooltips
        add("itemGroup.evadmt", "Everything Adamantium");
        add("tooltip.modevadamant.claws_info", "Forged from pure Adamantium. Triple-bladed lethality.");
    }
}
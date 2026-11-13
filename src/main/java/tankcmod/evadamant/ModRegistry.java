package tankcmod.evadamant;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tankcmod.evadamant.items.AdamantiumClawsItem;

public class ModRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModEvAdamant.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModEvAdamant.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModEvAdamant.MODID);

    // ================= BLOCKS =================
    public static final RegistryObject<Block> ADMT_BLOCK = BLOCKS.register("adamantium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));

    public static final RegistryObject<Block> ADMT_ORE = BLOCKS.register("adamantium_ore",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));

    // ================= BLOCK ITEMS =================
    public static final RegistryObject<Item> ADMT_BLOCK_ITEM = ITEMS.register("adamantium_block", () -> new BlockItem(ADMT_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> ADMT_ORE_ITEM = ITEMS.register("adamantium_ore", () -> new BlockItem(ADMT_ORE.get(), new Item.Properties()));

    // ================= BASIC ITEMS =================
    public static final RegistryObject<Item> ADMT_POWDER = ITEMS.register("adamantium_powder", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADMT_SACK = ITEMS.register("adamantium_sack", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADMT_INGOT = ITEMS.register("adamantium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_BRACKET = ITEMS.register("iron_bracket", () -> new Item(new Item.Properties()));

    // ================= TOOLS & WEAPONS =================
    // Attack damage modifier is added to the base Tier damage. Speed is a negative offset from base 4.0.
    public static final RegistryObject<Item> ADMT_PICK = ITEMS.register("adamantium_pickaxe",
            () -> new PickaxeItem(ModTiers.ADAMANTIUM, 1, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> ADMT_CLAW = ITEMS.register("adamantium_claw",
            () -> new SwordItem(ModTiers.ADAMANTIUM, 3, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> ADMT_CLAWS = ITEMS.register("adamantium_claws",
            () -> new AdamantiumClawsItem(ModTiers.ADAMANTIUM_X3, 8, -2.0F, new Item.Properties()));

    // ================= CREATIVE TAB =================
    public static final RegistryObject<CreativeModeTab> EV_TAB = CREATIVE_MODE_TABS.register("evadmt_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.evadmt"))
                    .icon(() -> ADMT_BLOCK_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ADMT_ORE_ITEM.get());
                        output.accept(ADMT_BLOCK_ITEM.get());
                        output.accept(ADMT_POWDER.get());
                        output.accept(ADMT_SACK.get());
                        output.accept(ADMT_INGOT.get());
                        output.accept(IRON_BRACKET.get());
                        output.accept(ADMT_PICK.get());
                        output.accept(ADMT_CLAW.get());
                        output.accept(ADMT_CLAWS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
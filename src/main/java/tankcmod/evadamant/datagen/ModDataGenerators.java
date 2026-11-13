package tankcmod.evadamant.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tankcmod.evadamant.ModEvAdamant;
import net.minecraftforge.common.data.ExistingFileHelper;

// The Bus.MOD parameter ensures this event is caught during the mod loading phase
@Mod.EventBusSubscriber(modid = ModEvAdamant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Server-side data (Recipes, Tags, Loot Tables)
        generator.addProvider(
                event.includeServer(),
                new ModRecipeProvider(packOutput)
        );

        // Client-side data (BlockStates, Item Models, Language)
        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(packOutput, existingFileHelper)
        );
        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(packOutput, existingFileHelper)
        );
    }
}
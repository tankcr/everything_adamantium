package tankcmod.evadamant.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tankcmod.evadamant.ModEvAdamant;

// The Bus.MOD parameter ensures this event is caught during the mod loading phase
@Mod.EventBusSubscriber(modid = ModEvAdamant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        // event.includeServer() ensures recipes are only generated for the server data pack,
        // rather than client-side resource packs (where things like models go).
        generator.addProvider(
                event.includeServer(),
                new ModRecipeProvider(packOutput)
        );
    }
}
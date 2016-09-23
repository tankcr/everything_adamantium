package tankcmod.evadamant.proxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tankcmod.evadamant.Config;
import tankcmod.evadamant.ModBlocks;
import tankcmod.evadamant.ModItems;

import java.io.File;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "modevadamant.cfg"));
        Config.readConfig();

        // Initialize our packet handler. Make sure the name is
        // 20 characters or less!
        //PacketHandler.registerMessages("ModEvAdamant");

        // Initialization of blocks and items typically goes here:
        ModBlocks.init();
        ModItems.init();
        //ModEntities.init();
        //ModDimensions.init();

        //MainCompatHandler.registerWaila();
        //MainCompatHandler.registerTOP();

    }

    public void init(FMLInitializationEvent e) {
        //NetworkRegistry.INSTANCE.registerGuiHandler(ModEvAdamant.instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }
}

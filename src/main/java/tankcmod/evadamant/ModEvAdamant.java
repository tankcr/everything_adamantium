package tankcmod.evadamant;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import tankcmod.evadamant.proxy.CommonProxy;
import tankcmod.evadamant.recipes.ADMTRecipes;
import tankcmod.evadamant.world.OreGen;

/**
 * Created by KRoy.Local on 9/21/2016.
 */


@Mod(modid = ModEvAdamant.MODID, name = ModEvAdamant.MODNAME, version = ModEvAdamant.MODVERSION, dependencies = "required-after:Forge@[11.16.0.1865,)", useMetadata = true)
public class ModEvAdamant {

    public static final String MODID = "modevadamant";
    public static final String MODNAME = "Everything Adamantium";
    public static final String MODVERSION = "0.0.1";

    @SidedProxy(clientSide = "tankcmod.evadamant.proxy.ClientProxy", serverSide = "tankcmod.evadamant.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ModEvAdamant instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ADMTRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    //@Mod.EventHandler
    //public void serverLoad(FMLServerStartingEvent event) {event.registerServerCommand(new TeleportCommand());}
}

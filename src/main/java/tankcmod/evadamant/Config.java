package tankcmod.evadamant;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import tankcmod.evadamant.proxy.CommonProxy;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class Config {
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    public static boolean isThisAGoodMod = true;
    public static String yourRealName = "Steve";
    public static int dimensionId = 100;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            tankcmod.evadamant.ModEvAdamant.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        isThisAGoodMod = cfg.getBoolean("goodMod", CATEGORY_GENERAL, isThisAGoodMod, "Set to false if you don't like this mod");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
        dimensionId = cfg.getInt("dimensionId", CATEGORY_DIMENSIONS, dimensionId, -1000, 1000, "The Id to use for the dimension");
    }
}

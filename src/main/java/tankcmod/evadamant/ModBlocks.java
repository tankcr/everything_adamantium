package tankcmod.evadamant;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.blocks.ADMTBlock;
import tankcmod.evadamant.blocks.ADMTOre;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ModBlocks {
    public static ADMTBlock admtBlock;
    public static ADMTOre admtOre;



    public static void init() {
        admtOre = new ADMTOre();
        admtBlock = new ADMTBlock();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        admtBlock.initModel();
        admtOre.initModel();
    }
}

package tankcmod.evadamant;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.items.ADMTIngot;
import tankcmod.evadamant.items.ADMTSack;
import tankcmod.evadamant.items.ADPowderItem;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ModItems {
    public static ADPowderItem adpowderItem;
    public static ADMTSack admtSack;
    public static ADMTIngot admtIngot;

    public static void init()
    {

        adpowderItem = new ADPowderItem();
        admtSack = new ADMTSack();
        admtIngot = new ADMTIngot();

    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        admtSack.initModel();
        adpowderItem.initModel();
        admtIngot.initModel();
    }

}

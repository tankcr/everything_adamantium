package tankcmod.evadamant;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.items.ADPowderItem;
import tankcmod.evadamant.items.ADPowderTexturedItem;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ModItems {
    public static ADPowderItem adpowderItem;
    public static ADPowderTexturedItem adpowderTexturedItem;

    public static void init()
    {

        adpowderItem = new ADPowderItem();
        //adpowderTexturedItem = new ADPowderTexturedItem();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        adpowderItem.initModel();
    }


}

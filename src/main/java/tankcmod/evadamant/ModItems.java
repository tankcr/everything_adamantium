package tankcmod.evadamant;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.items.ADMTClaw;
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
    public static ADMTClaw admtClaw;
    public static Item.ToolMaterial ADMTMAT = EnumHelper.addToolMaterial("everything_adamantium:adamantium", 2, 2500, 4.0F, 6.0F, 22);
    public static void init()
    {

        adpowderItem = new ADPowderItem();
        admtSack = new ADMTSack();
        admtIngot = new ADMTIngot();
        GameRegistry.registerItem(admtClaw = new ADMTClaw("everything_adamantium:adamantium",ADMTMAT ), "everything_adamantium:adamantium");

    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {

        admtSack.initModel();
        adpowderItem.initModel();
        admtIngot.initModel();
        admtClaw.initModel();

    }

}

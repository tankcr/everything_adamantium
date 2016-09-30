package tankcmod.evadamant;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.items.*;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ModItems {
    public static ADPowderItem adpowderItem;
    public static ADMTSack admtSack;
    public static ADMTIngot admtIngot;
    public static IRONBracket ironBracket;
    public static ADMTClaw admtClaw;
    public static ADMTClaws admtClaws;
    public static Item.ToolMaterial ADMTMAT = EnumHelper.addToolMaterial("everything_adamantium:adamantium", 2, 1561, 6.0F, 3.0F, 10);
    public static Item.ToolMaterial ADMTMATX3 = EnumHelper.addToolMaterial("everything_adamantium:adamantiumX3", 3, 3000, 12.0F, 12.0F, 34);

    public static final CreativeTabs evtab = new CreativeTabs("EvAdmt") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.admtBlock);
        }
    };

    public static void init()
    {

        adpowderItem = new ADPowderItem();
        admtSack = new ADMTSack();
        admtIngot = new ADMTIngot();
        ironBracket = new IRONBracket();
        admtClaw = new ADMTClaw("everything_adamantium:adamantium",ADMTMAT );
        admtClaws = new ADMTClaws("everything_adamantium:adamantiumX3",ADMTMATX3 );

    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {

        admtSack.initModel();
        adpowderItem.initModel();
        admtIngot.initModel();
        ironBracket.initModel();
        admtClaw.initModel();
        admtClaws.initModel();

    }

}

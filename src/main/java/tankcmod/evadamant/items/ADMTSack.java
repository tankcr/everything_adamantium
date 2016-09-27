package tankcmod.evadamant.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModItems;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ADMTSack extends Item {
    public ADMTSack()
    {
        setRegistryName("admtsack");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(ModEvAdamant.MODID + ".admtsack");     // Used for localization (en_US.lang)
        this.setCreativeTab(ModItems.evtab);
        GameRegistry.register(this);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}

package tankcmod.evadamant.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.ModEvAdamant;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ADPowderTexturedItem extends Item {
    public ADPowderTexturedItem(){
        setRegistryName("adpowdertextureditem");
        setUnlocalizedName(ModEvAdamant.MODID + ".adpowdertextureditem");
        this.setCreativeTab(CreativeTabs.MISC);
        GameRegistry.register(this);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}

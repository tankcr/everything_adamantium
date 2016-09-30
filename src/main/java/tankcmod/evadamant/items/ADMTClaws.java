package tankcmod.evadamant.items;

import com.google.common.collect.Sets;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModItems;

import java.util.Set;

/**
 * Created by KRoy.Local on 9/25/2016.
 */
public class ADMTClaws extends ItemSword{


    public ADMTClaws(String unlocalizedName, Item.ToolMaterial material)
    {
        super(material);
        setRegistryName("admtclaws");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(ModEvAdamant.MODID + ".admtclaws");     // Used for localization (en_US.lang)
        this.setCreativeTab(ModItems.evtab);
        GameRegistry.register(this);
    }

    private static Set effectiveAgainst = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF,
            Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN);

    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
    }
}

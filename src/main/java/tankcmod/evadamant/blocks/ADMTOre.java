package tankcmod.evadamant.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tankcmod.evadamant.ModEvAdamant;
import tankcmod.evadamant.ModItems;

/**
 * Created by KRoy.Local on 9/21/2016.
 */
public class ADMTOre extends Block {

    public static int chance;
    {chance = 8;}

    public ADMTOre() {
        super(Material.ROCK);
        setHardness(15f);
        setResistance(5f);
        setUnlocalizedName(ModEvAdamant.MODID + ".admtore");     // Used for localization (en_US.lang)
        setRegistryName("admtore");        // The unique name (within your mod) that identifies this block
        setHarvestLevel("pickaxe",3);
        this.setCreativeTab(ModItems.evtab);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }
}

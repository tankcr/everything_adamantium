package tankcmod.evadamant.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by KRoy.Local on 9/22/2016.
 */

public class BlockBase extends Block{

    //protected String name;

    public BlockBase(Material materialIn, String name) {
        super(materialIn);
        //this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        //setCreativeTab(TutorialMod.creativeTab); //this creativetab hasn't been implemented yet
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }


}

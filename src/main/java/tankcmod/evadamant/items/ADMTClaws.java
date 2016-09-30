package tankcmod.evadamant.items;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("axe");}
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return effectiveAgainst.contains(block) || super.canHarvestBlock(block.getDefaultState(),stack); // Check through the effective set if it can mine it
    }

        //public float getStrVsBlock(ItemStack stack, IBlockState state)
        //{
        //    Material material = state.getMaterial();
        //    return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
        //}

        //public float getStrVsBlock(stack, block) {
        //    if (block.getMaterial() == Material.WOOD || block.getMaterial() == Material.VINE || block.getMaterial() == Material.PLANTS)

        //        return this.efficiencyOnProperMaterial; // Return the efficiency for that material with this tool
        //    return effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block);
        //}
    //}


    @SideOnly(Side.CLIENT)
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));}
}


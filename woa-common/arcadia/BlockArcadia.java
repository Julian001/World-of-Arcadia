package arcadia;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArcadia extends Block {

	public BlockArcadia(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(arcadia.tabArcadiaBlocks);
	}

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == new ItemStack(arcadia.oreRuby).itemID ? new ItemStack(arcadia.gemRuby).itemID : 
        	(this.blockID == new ItemStack(arcadia.oreSapphire).itemID ? new ItemStack(arcadia.gemSapphire).itemID : this.blockID);
    }
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.blockIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));
	    }
}

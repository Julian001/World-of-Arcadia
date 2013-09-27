package arcadia.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import arcadia.arcadia;
import arcadia.items.ItemsArcadia;
import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArcadia extends Block {

	public BlockArcadia(int id, Material material) {
		super(id, material);
		this.setCreativeTab(arcadia.tabArcadiaBlocks);
	}

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == new ItemStack(BlocksArcadia.oreRuby).itemID ? new ItemStack(ItemsArcadia.gemRuby).itemID : 
        	(this.blockID == new ItemStack(BlocksArcadia.oreSapphire).itemID ? new ItemStack(ItemsArcadia.gemSapphire).itemID : this.blockID);
    }
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.blockIcon = par1IconRegister.registerIcon(References.ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));
	    }
}

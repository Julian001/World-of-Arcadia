package arcadia.blocks;

import arcadia.arcadia;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockStair extends BlockStairs
{
    protected BlockStair(int par1, Block par2Block, int par3)
    {
        super(par1, par2Block, par3);
        this.setHardness(par2Block.blockHardness);
        this.setResistance(par2Block.blockResistance / 3.0F);
        this.setStepSound(par2Block.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(arcadia.tabArcadiaBlocks);
    }
}

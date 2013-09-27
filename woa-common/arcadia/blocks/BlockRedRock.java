package arcadia.blocks;

import java.util.List;
import arcadia.arcadia;
import arcadia.blocks.BlockArcadia;
import arcadia.lib.References;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRedRock extends BlockArcadia {
	public int meta = 5;
	
	public BlockRedRock(int id, Material material) {
		super(id, material);
		this.setHardness(1.5F);
		this.setResistance(10F);
		this.setCreativeTab(arcadia.tabArcadiaBlocks);		
	}
	   	      
	public int damageDropped(int metadata)
    {
		if(metadata == 0){
			return 1;
   		}
   		else
   		{
	   		return metadata;
   		}
    }
	      
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
  
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	icons = new Icon[meta];
    	
    	for(int i = 0; i < icons.length; i++)
          {
        	  String name = "";
        	  switch(i)
              {
                     case 0:
                     {
                            name = "";
                            break;
                     }
                     case 1:
                     {
                            name = "Cobble";
                            break;
                     }
                     case 2:
                     {
                            name = "Brick";
                            break;
                     }
                     case 3:
                     {
                            name = "BrickCarved";
                            break;
                     }
                     case 4:
                     {
                            name = "BrickCracked";
                            break;
                     }
                     default: name = "Broken";
              }
        	  icons[i] = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)) + name);
          }
    }
  
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        switch(par2)
        {
            case 0:
            	  return icons[0];
            case 1:
        		  return icons[1];
            case 2:
	              return icons[2];
            case 3:
	              return icons[3];
            case 4:
	              return icons[4];
            case 5:
	              return icons[5];
            
            default:
            {
            	System.out.println("Invalid metadata for " + this.getUnlocalizedName());
                return icons[0];
            }
        }
    }
  
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
          for(int i = 0; i < meta; i++)
          {
        	  par3List.add(new ItemStack(par1, 1, i));
          }
    }
}

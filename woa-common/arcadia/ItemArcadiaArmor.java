package arcadia;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcadiaArmor extends ItemArmor{

    public ItemArcadiaArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(arcadia.tabArcadiaItems);        
    }
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
    
    public String getArmorTexture(ItemStack par1, Entity enity, int slot, int layer){
    	if(par1.itemID == arcadia.helmetSilver.itemID || par1.itemID == arcadia.chestplateSilver.itemID || par1.itemID == arcadia.bootsSilver.itemID){
    		return "arcadia:textures/models/armor/silver_1.png";
    		}
    	else if(par1.itemID == arcadia.leggingsSilver.itemID){
    		return "arcadia:textures/models/armor/silver_2.png";
    		}
    	if(par1.itemID == arcadia.helmetBronze.itemID || par1.itemID == arcadia.chestplateBronze.itemID || par1.itemID == arcadia.bootsBronze.itemID){
    		return "arcadia:textures/models/armor/bronze_1.png";
    		}
    	else if(par1.itemID == arcadia.leggingsBronze.itemID){
    		return "arcadia:textures/models/armor/bronze_2.png";
    		}
    	if(par1.itemID == arcadia.helmetRuby.itemID || par1.itemID == arcadia.chestplateRuby.itemID || par1.itemID == arcadia.bootsRuby.itemID){
    		return "arcadia:textures/models/armor/ruby_1.png";
    		}
    	else if(par1.itemID == arcadia.leggingsRuby.itemID){
    		return "arcadia:textures/models/armor/ruby_2.png";
    		}
    	if(par1.itemID == arcadia.helmetSapphire.itemID || par1.itemID == arcadia.chestplateSapphire.itemID || par1.itemID == arcadia.bootsSapphire.itemID){
    		return "arcadia:textures/models/armor/sapphire_1.png";
    		}
    	else if(par1.itemID == arcadia.leggingsSapphire.itemID){
    		return "arcadia:textures/models/armor/sapphire_2.png";
    		}
    	else{
    		return "arcadia:textures/models/armor/silver_1.png";
    	}
    }
}
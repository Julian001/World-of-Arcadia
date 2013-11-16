package arcadia.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import arcadia.arcadia;
import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorArcadia extends ItemArmor{

    public ItemArmorArcadia(int id, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(id, par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(arcadia.tabArcadiaItems);        
    }
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)));
	}
    
    public String getArmorTexture(ItemStack par1, Entity enity, int slot, int layer){
    	if(par1.itemID == ItemsArcadia.helmetSilver.itemID || par1.itemID == ItemsArcadia.chestplateSilver.itemID || par1.itemID == ItemsArcadia.bootsSilver.itemID){
    		return "arcadia:textures/models/armor/silver_1.png";
    		}
    	else if(par1.itemID == ItemsArcadia.leggingsSilver.itemID){
    		return "arcadia:textures/models/armor/silver_2.png";
    		}
    	if(par1.itemID == ItemsArcadia.helmetBronze.itemID || par1.itemID == ItemsArcadia.chestplateBronze.itemID || par1.itemID == ItemsArcadia.bootsBronze.itemID){
    		return "arcadia:textures/models/armor/bronze_1.png";
    		}
    	else if(par1.itemID == ItemsArcadia.leggingsBronze.itemID){
    		return "arcadia:textures/models/armor/bronze_2.png";
    		}
    	if(par1.itemID == ItemsArcadia.helmetRuby.itemID || par1.itemID == ItemsArcadia.chestplateRuby.itemID || par1.itemID == ItemsArcadia.bootsRuby.itemID){
    		return "arcadia:textures/models/armor/ruby_1.png";
    		}
    	else if(par1.itemID == ItemsArcadia.leggingsRuby.itemID){
    		return "arcadia:textures/models/armor/ruby_2.png";
    		}
    	if(par1.itemID == ItemsArcadia.helmetSapphire.itemID || par1.itemID == ItemsArcadia.chestplateSapphire.itemID || par1.itemID == ItemsArcadia.bootsSapphire.itemID){
    		return "arcadia:textures/models/armor/sapphire_1.png";
    		}
    	else if(par1.itemID == ItemsArcadia.leggingsSapphire.itemID){
    		return "arcadia:textures/models/armor/sapphire_2.png";
    		}
    	else{
    		return "arcadia:textures/models/armor/silver_1.png";
    	}
    }
}
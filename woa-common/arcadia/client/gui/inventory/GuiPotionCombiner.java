package arcadia.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import arcadia.inventory.ContainerPotionCombiner;
import arcadia.lib.References;
import arcadia.tileentity.TileEntityPotionCombiner;

public class GuiPotionCombiner extends GuiContainer
{
	public ResourceLocation iconLocation = new ResourceLocation(References.ID, "textures/gui/potionCombiner.png");
	private TileEntityPotionCombiner inventory;
	
	public GuiPotionCombiner(InventoryPlayer par1InventoryPlayer, TileEntityPotionCombiner par2TileEntity)
	{
	         super(new ContainerPotionCombiner(par1InventoryPlayer, par2TileEntity));
	         this.inventory = par2TileEntity;
	}
	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
			fontRenderer.drawString(StatCollector.translateToLocal("Potion Combiner"), 8, 6, 0x404040);
			fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, (ySize - 96) + 2, 0x404040);
	}
	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         mc.renderEngine.bindTexture(iconLocation);
	         int var5 = (this.width - this.xSize) / 2;
	         int var6 = (this.height - this.ySize) / 2;
	         this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	         int var7;
	         if (this.inventory.isBurning())
	         {
	                 var7 = this.inventory.getBurnTimeRemainingScaled(12);
	                 this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
	         }
	         var7 = this.inventory.getCookProgressScaled(24);
	         this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
	}
}
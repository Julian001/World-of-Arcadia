package arcadia.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import arcadia.anvil.ContainerAnvilArcadia;
import arcadia.lib.References;

public class GuiAnvilArcadia extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(References.ID + ":" + "textures/gui/anvil.png");
	public GuiAnvilArcadia(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
	{
	         super(new ContainerAnvilArcadia(inventoryplayer, world, i, j, k));
	}
	
	public void onGuiClosed()
	{
	         super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	         this.fontRenderer.drawString(StatCollector.translateToLocal("Anvil"), 16, 6, 0x404040);
	         this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 16, 109, 0x404040);
	}
	
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         mc.renderEngine.bindTexture(texture);
	         int l = (width - xSize) / 2;
	         int i1 = (height - ySize) / 2;
	         drawTexturedModalRect(l, i1, 0, 0, 190, 202);
	}
}
package arcadia.bag;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


public class GuiBagMediumArcadia extends GuiContainer
{
	/** x and y size of the inventory window in pixels. Defined as float, passed as int
	* These are used for drawing the player model. */
	private float xSize_lo;
	private float ySize_lo;
	private int xSize = 220;
	private int ySize = 180;
	
	/**
	ResourceLocation takes 2 parameters: ModId, path to texture at the location:
	"src/minecraft/assets/modid/"
	
	If you want a working texture to test out the tutorial with, I've uploaded one to my github page:
	https://github.com/coolAlias/Forge_Tutorials/tree/master/textures/gui
	*/
	public ResourceLocation iconLocation = new ResourceLocation("arcadia", "textures/gui/bagMedium.png");
	
	
	/** The inventory to render on screen */
	@SuppressWarnings("unused")
	private final InventoryBagMediumArcadia inventory;
	
	public GuiBagMediumArcadia(ContainerBagMediumArcadia container)
	{
	         super(container);
	         this.inventory = container.inventory;
	         
	         /*switch(ix)
             {
         		 case 0:
         		 {
                     iconLocation = new ResourceLocation("arcadia", "textures/gui/bagSmall.png");
                     break;
         		 }
                 case 1:
                 {
                     iconLocation = new ResourceLocation("arcadia", "textures/gui/bagMedium.png");
                     break;
                 }   
                 case 2:
                 {
                	 iconLocation = new ResourceLocation("arcadia", "textures/gui/bagHuge.png");
                	 break;
                 }
                 default: iconLocation = new ResourceLocation("arcadia", "textures/gui/bagHuge.png");
                 
             }*/
             //if (mc.thePlayer.getHeldItem().itemID = arcadia.bagHuge.itemID) {
            	 
             
	}
	
	/**
	* Draws the screen and all the components in it.
	*/
	public void drawScreen(int par1, int par2, float par3)
	{
	         super.drawScreen(par1, par2, par3);
	         this.xSize_lo = (float)par1;
	         this.ySize_lo = (float)par2;
	}
	
	/**
	* Draw the foreground layer for the GuiContainer (everything in front of the items)
	*/
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	         //String s = this.inventory.isInvNameLocalized() ? this.inventory.getInvName() : I18n.getString(this.inventory.getInvName());
	         this.fontRenderer.drawString("Medium Bag", this.xSize / 2 - 102, -1, 4210752);
	         //this.fontRenderer.drawString("Huge Bag", 8, -30, 4210752);
	         this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, 68, 4210752);
	}
	
	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         this.mc.renderEngine.bindTexture(iconLocation);
	         int k = (this.width - this.xSize) / 2 + 22;
	         int l = (this.height - this.ySize) / 2 + 1;
	         //int k = 125;
	         //int l = 0;
	         this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	         //int i1;
	         //drawPlayerModel(k + 51, l + 75, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo, this.mc.thePlayer);
	         drawPlayerModel(k - 21, l + 135 - 58, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo, this.mc.thePlayer);
	}
	
	/**
	* This renders the player model in standard inventory position
	*/
	public static void drawPlayerModel(int par0, int par1, int par2, float par3, float par4, EntityLivingBase par5EntityLivingBase)
	{
	         GL11.glEnable(GL11.GL_COLOR_MATERIAL);
	         GL11.glPushMatrix();
	         GL11.glTranslatef((float)par0, (float)par1, 50.0F);
	         GL11.glScalef((float)(-par2), (float)par2, (float)par2);
	         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	         float f2 = par5EntityLivingBase.renderYawOffset;
	         float f3 = par5EntityLivingBase.rotationYaw;
	         float f4 = par5EntityLivingBase.rotationPitch;
	         float f5 = par5EntityLivingBase.prevRotationYawHead;
	         float f6 = par5EntityLivingBase.rotationYawHead;
	         GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
	         RenderHelper.enableStandardItemLighting();
	         GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
	         GL11.glRotatef(-((float)Math.atan((double)(par4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
	         par5EntityLivingBase.renderYawOffset = (float)Math.atan((double)(par3 / 40.0F)) * 20.0F;
	         par5EntityLivingBase.rotationYaw = (float)Math.atan((double)(par3 / 40.0F)) * 40.0F;
	         par5EntityLivingBase.rotationPitch = -((float)Math.atan((double)(par4 / 40.0F))) * 20.0F;
	         par5EntityLivingBase.rotationYawHead = par5EntityLivingBase.rotationYaw;
	         par5EntityLivingBase.prevRotationYawHead = par5EntityLivingBase.rotationYaw;
	         GL11.glTranslatef(0.0F, par5EntityLivingBase.yOffset, 0.0F);
	         RenderManager.instance.playerViewY = 180.0F;
	         RenderManager.instance.renderEntityWithPosYaw(par5EntityLivingBase, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
	         par5EntityLivingBase.renderYawOffset = f2;
	         par5EntityLivingBase.rotationYaw = f3;
	         par5EntityLivingBase.rotationPitch = f4;
	         par5EntityLivingBase.prevRotationYawHead = f5;
	         par5EntityLivingBase.rotationYawHead = f6;
	         GL11.glPopMatrix();
	         RenderHelper.disableStandardItemLighting();
	         GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	         OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	         GL11.glDisable(GL11.GL_TEXTURE_2D);
	         OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
package arcadia.entity;

import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import arcadia.entity.ModelShark;

@SideOnly(Side.CLIENT)
public class RenderShark extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation(References.ID + ":" + "textures/entity/shark.png");

    public RenderShark(ModelBase par1, float par2)
    {
        super(new ModelShark(), par2);
    }

    public void renderShark(EntityShark par1EntityShark, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityShark, par2, par4, par6, par8, par9);
    }
 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderShark((EntityShark)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderShark((EntityShark)par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getSharkTextures(EntityShark par1EntityShark)
    {
        return texture;
    }
    
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getSharkTextures((EntityShark)par1Entity);
    }
}
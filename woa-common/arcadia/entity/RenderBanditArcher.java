package arcadia.entity;

import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderBanditArcher extends RenderBiped
{
	private static final ResourceLocation skin = new ResourceLocation(References.ID, "textures/models/entity/banditArcher.png");
	
	public RenderBanditArcher(ModelBiped par1ModelBiped, float par2)
	{
		this(par1ModelBiped, par2, 1.0F);
	}
	
	public RenderBanditArcher(ModelBiped par1ModelBiped, float par2, float par3)
	{
		super(par1ModelBiped, par2);
		this.modelBipedMain = par1ModelBiped;
		this.field_77070_b = par3;
		this.func_82421_b();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return  skin;
	}
}
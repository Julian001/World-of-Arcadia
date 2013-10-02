package arcadia.proxies;

import net.minecraft.client.model.ModelBiped;
import arcadia.entity.EntityBandit;
import arcadia.entity.EntityBanditArcher;
import arcadia.entity.EntityShark;
import arcadia.entity.ModelShark;
import arcadia.entity.RenderBandit;
import arcadia.entity.RenderBanditArcher;
import arcadia.entity.RenderShark;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyArcadia extends CommonProxyArcadia {

	@Override
    public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new RenderBandit(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBanditArcher.class, new RenderBanditArcher(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark(new ModelShark(), 0.5F));
    }
}

package arcadia.proxies;

import net.minecraft.client.model.ModelBiped;
import arcadia.entity.EntityBandit;
import arcadia.entity.RenderBandit;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxyArcadia extends CommonProxyArcadia {

	@Override
    public void registerRenderers() 
	{
		float shadowSize = 0.5F;

		//MOBS
		RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new RenderBandit(new ModelBiped(), shadowSize));
        
    }
}

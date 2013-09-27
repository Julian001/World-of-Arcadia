package arcadia;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import arcadia.bag.ContainerBagArcadia;
import arcadia.bag.ContainerBagMediumArcadia;
import arcadia.bag.ContainerBagSmallArcadia;
import arcadia.bag.GuiBagArcadia;
import arcadia.bag.GuiBagMediumArcadia;
import arcadia.bag.GuiBagSmallArcadia;
import arcadia.bag.InventoryBagArcadia;
import arcadia.bag.InventoryBagMediumArcadia;
import arcadia.bag.InventoryBagSmallArcadia;
import arcadia.blocks.BlocksArcadia;
import arcadia.client.gui.inventory.GuiPotionCombiner;
import arcadia.inventory.ContainerPotionCombiner;
import arcadia.lib.config.GuiIds;
import arcadia.tileentity.TileEntityPotionCombiner;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerArcadia implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(id)
		{
			case 0: return id == GuiIds.guiAnvilIndex && world.getBlockId(x, y, z) == BlocksArcadia.anvilArcadia.blockID ? new ContainerAnvilArcadia(player.inventory, world, x, y, z) : null;
			case 1: return id == GuiIds.guiBagSmallIndex ? new ContainerBagSmallArcadia(player, player.inventory, new InventoryBagSmallArcadia(player.getHeldItem())) : null;
			case 2: return id == GuiIds.guiBagMediumIndex ? new ContainerBagMediumArcadia(player, player.inventory, new InventoryBagMediumArcadia(player.getHeldItem())) : null;
			case 3: return id == GuiIds.guiBagHugeIndex ? new ContainerBagArcadia(player, player.inventory, new InventoryBagArcadia(player.getHeldItem())) : null;
			case 4: return new ContainerPotionCombiner(player.inventory, (TileEntityPotionCombiner) tile_entity);
		}
			return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		switch(id)
		{
			case 0: return id == GuiIds.guiAnvilIndex && world.getBlockId(x, y, z) == BlocksArcadia.anvilArcadia.blockID ? new GuiAnvilArcadia(player.inventory, world, x, y, z) : null;
			case 1: return id == GuiIds.guiBagSmallIndex ? new GuiBagSmallArcadia((ContainerBagSmallArcadia) new ContainerBagSmallArcadia(player, player.inventory, new InventoryBagSmallArcadia(player.getHeldItem()))) : null;
			case 2: return id == GuiIds.guiBagMediumIndex ? new GuiBagMediumArcadia((ContainerBagMediumArcadia) new ContainerBagMediumArcadia(player, player.inventory, new InventoryBagMediumArcadia(player.getHeldItem()))) : null;
			case 3: return id == GuiIds.guiBagHugeIndex ? new GuiBagArcadia((ContainerBagArcadia) new ContainerBagArcadia(player, player.inventory, new InventoryBagArcadia(player.getHeldItem()))) : null;
			case 4: return new GuiPotionCombiner(player.inventory, (TileEntityPotionCombiner) tile_entity);
		}
			return null;
	}
}
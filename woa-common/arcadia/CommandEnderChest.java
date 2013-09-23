package arcadia;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.tileentity.TileEntityEnderChest;

public class CommandEnderChest extends CommandBase {

	@Override
	public String getCommandName() {
		return "enderchest";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/enderchest";
	}

	public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);
		
        InventoryEnderChest inventory = player.getInventoryEnderChest();
        player.displayGUIChest(inventory);
        
	}
}

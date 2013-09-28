package arcadia.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommandDayArcadia extends CommandBase 
{
    public int getRequiredPermissionLevel() {
        return 2;
    }

	@Override
	public String getCommandName() {
		return "day";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/day";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		World world = icommandsender.getEntityWorld();
		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);
		world.setWorldTime(0);
		player.addChatMessage("\u00a7eTime set to day");
	}
}


package arcadia.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class CommandSpeedArcadia extends CommandBase 
{
	public int getRequiredPermissionLevel() {
        return 2;
    }

	@Override
	public String getCommandName() {
		return "speed";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/speed";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 100 * 20, 10));
		player.addChatMessage("\u00a79Speed aplied!");
	}
}
package arcadia.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

public class CommandHealArcadia extends CommandBase 
{
	public int getRequiredPermissionLevel() {
        return 2;
    }

	@Override
	public String getCommandName() {
		return "heal";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/heal";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);
		player.heal(20);
		player.getFoodStats().setFoodLevel(20);
		player.getFoodStats().setFoodSaturationLevel(20);
		player.extinguish();
		player.removePotionEffect(Potion.wither.id);
		player.removePotionEffect(Potion.confusion.id);
		player.removePotionEffect(Potion.digSlowdown.id);
		player.removePotionEffect(Potion.blindness.id);
		player.removePotionEffect(Potion.poison.id);
		player.removePotionEffect(Potion.weakness.id);
		player.removePotionEffect(Potion.moveSlowdown.id);
		player.removePotionEffect(Potion.hunger.id);
		player.addChatMessage("\u00a7aPlayer healed");
	}
}

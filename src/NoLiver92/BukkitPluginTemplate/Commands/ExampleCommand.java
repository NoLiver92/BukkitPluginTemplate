package NoLiver92.BukkitPluginTemplate.Commands;

import NoLiver92.BukkitPluginTemplate.BukkitTemplate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Nick on 03/01/14.
 */
public class ExampleCommand implements CommandExecutor
{
    public BukkitTemplate plugin;

    public ExampleCommand(BukkitTemplate plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            if ((player.hasPermission("BT.example")))
            {
                player.sendMessage("Ran Command");
            }
            else
            {
                player.sendMessage("Permission Denied");
            }
        }

        return false;
    }
}

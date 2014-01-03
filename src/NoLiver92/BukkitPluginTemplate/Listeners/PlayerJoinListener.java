package NoLiver92.BukkitPluginTemplate.Listeners;

import NoLiver92.BukkitPluginTemplate.BukkitTemplate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Nick on 03/01/14.
 */
public class PlayerJoinListener implements Listener
{
    public BukkitTemplate plugin;

    public PlayerJoinListener(BukkitTemplate plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event)
    {
        event.getPlayer().sendMessage("You Have Just Joined the Server");
    }
}

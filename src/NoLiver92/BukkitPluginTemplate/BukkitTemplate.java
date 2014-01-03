package NoLiver92.BukkitPluginTemplate;

import NoLiver92.BukkitPluginTemplate.Commands.ExampleCommand;
import NoLiver92.BukkitPluginTemplate.Listeners.PlayerJoinListener;
import NoLiver92.BukkitPluginTemplate.Utils.CheckFiles;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Nick on 03/01/14.
 */
public class BukkitTemplate extends JavaPlugin
{
    public void onEnable()
    {
        //Check For Config File (leave at top)
        CheckFiles fileCheck = new CheckFiles(this);
        fileCheck.checkConfig("config.yml");

        //Register Listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        //Register Commands
        this.getCommand("example").setExecutor(new ExampleCommand(this));
    }

    public void onDisable()
    {

    }
}

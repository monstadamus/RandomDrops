package izarro.randomDrops;

import izarro.randomDrops.handler.SimpleEventHandler;
import izarro.randomDrops.commands.DropsManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomDrops extends JavaPlugin {

    private static RandomDrops instance;
    private static boolean dropEnabled = true;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SimpleEventHandler(this), this);
        this.getCommand("rd").setExecutor(new DropsManager(this));
        this.getCommand("rd").setTabCompleter(new DropsManager(this));
    }

    public static RandomDrops getInstance(){
        return instance;
    }

    public static boolean isDropEnabled() {
        return dropEnabled;
    }

    public static void setDropEnabled(boolean enabled) {
        dropEnabled = enabled;
    }
}

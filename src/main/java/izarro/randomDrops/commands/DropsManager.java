package izarro.randomDrops.commands;

import izarro.randomDrops.RandomDrops;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropsManager implements CommandExecutor, TabCompleter {
    private final RandomDrops plugin;

    public DropsManager(RandomDrops plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command is only available to players");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + "Use: /rd drop <enable|disable>");
            return true;
        }

        if (args[0].equalsIgnoreCase("drop")) {
            if (args[1].equalsIgnoreCase("enable")) {
                RandomDrops.setDropEnabled(true);
                player.sendMessage(ChatColor.YELLOW + "Drops " + ChatColor.GREEN + "enabled " + ChatColor.YELLOW + "for all players");
            } else if (args[1].equalsIgnoreCase("disable")) {
                RandomDrops.setDropEnabled(false);
                player.sendMessage(ChatColor.YELLOW + "Drops " + ChatColor.RED + "disabled " + ChatColor.YELLOW + "for all players");
            } else {
                player.sendMessage(ChatColor.RED + "Use: /rd drop <enable|disable>");
            }
        }
//asdfsdf
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("drop");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("drop")) {
            return Arrays.asList("enable", "disable");
        }
        return new ArrayList<>();
    }
}

package izarro.randomDrops.handler;

import izarro.randomDrops.RandomDrops;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class SimpleEventHandler implements Listener {
    private final Random random = new Random();
    private final RandomDrops plugin;

    public SimpleEventHandler(RandomDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleBlockBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();

        if (!RandomDrops.isDropEnabled()) {
            return;
        }

        if (player.getGameMode() != GameMode.SURVIVAL) {
            return;
        }

        e.setCancelled(true);
        e.getBlock().setType(Material.AIR);

        Material[] materials = Material.values();
        Material randomMaterial;

        randomMaterial = materials[random.nextInt(materials.length)];

        ItemStack randomDrop = new ItemStack(randomMaterial, 1);

        Location blockLocation = e.getBlock().getLocation();
        e.getBlock().getWorld().dropItemNaturally(blockLocation, randomDrop);
    }
}

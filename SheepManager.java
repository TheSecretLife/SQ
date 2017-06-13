package net.playfriik.sheepquest.managers;

import net.playfriik.sheepquest.SheepQuest;
import net.playfriik.sheepquest.arenas.Arena;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;

public class SheepManager {

   private SheepQuest plugin = (SheepQuest)Bukkit.getPluginManager().getPlugin("SheepQuest");


   public void spawnNewSheep(String arenaName) {
      Arena arena = this.plugin.getArenaManager().getArena(arenaName);
      if(arena != null) {
         World world = Bukkit.getServer().getWorld(arena.getName());
         Location loc = new Location(world, this.plugin.getConfigManager().getConfig("arenas.yml").getDouble("arenas." + arena.getName() + ".spawnpoints.sheep.x"), this.plugin.getConfigManager().getConfig("arenas.yml").getDouble("arenas." + arena.getName() + ".spawnpoints.sheep.y"), this.plugin.getConfigManager().getConfig("arenas.yml").getDouble("arenas." + arena.getName() + ".spawnpoints.sheep.z"));
         loc.setPitch((float)this.plugin.getConfigManager().getConfig("arenas.yml").getDouble("arenas." + arena.getName() + ".spawnpoints.sheep.pitch"));
         loc.setYaw((float)this.plugin.getConfigManager().getConfig("arenas.yml").getDouble("arenas." + arena.getName() + ".spawnpoints.sheep.yaw"));
         Sheep sheep = (Sheep)world.spawn(loc, Sheep.class);
         sheep.setColor(DyeColor.WHITE);
         sheep.setTarget((LivingEntity)null);
         arena.getArenaSheeps().add(sheep);
      }

   }
}

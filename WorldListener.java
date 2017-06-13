package net.playfriik.sheepquest.listeners;

import java.util.Iterator;
import net.playfriik.sheepquest.SheepQuest;
import net.playfriik.sheepquest.Translation;
import net.playfriik.sheepquest.arenas.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.world.ChunkUnloadEvent;

public class WorldListener implements Listener {

   private SheepQuest plugin = (SheepQuest)Bukkit.getPluginManager().getPlugin("SheepQuest");


   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onCreatureSpawn(CreatureSpawnEvent e) {
      if(Arena.arenaObjects.contains(this.plugin.getArenaManager().getArena(e.getEntity().getWorld().getName())) && e.getSpawnReason() != SpawnReason.CUSTOM) {
         e.setCancelled(true);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onChunkUnload(ChunkUnloadEvent e) {
      Iterator var3 = Arena.arenaObjects.iterator();

      while(var3.hasNext()) {
         Arena arena = (Arena)var3.next();
         Entity entity;
         int var5;
         int var6;
         Entity[] var7;
         Sheep zombie;
         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.blue.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.SHEEP) {
                  zombie = (Sheep)entity;
                  if(zombie.getCustomName() != null && zombie.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BLUE_TEAM")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.green.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.SHEEP) {
                  zombie = (Sheep)entity;
                  if(zombie.getCustomName() != null && zombie.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-GREEN_TEAM")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.red.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.SHEEP) {
                  zombie = (Sheep)entity;
                  if(zombie.getCustomName() != null && zombie.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-RED_TEAM")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.yellow.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.SHEEP) {
                  zombie = (Sheep)entity;
                  if(zombie.getCustomName() != null && zombie.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-YELLOW_TEAM")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         Zombie var9;
         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.beserker.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.ZOMBIE) {
                  var9 = (Zombie)entity;
                  if(var9.getCustomName() != null && var9.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BESERKER_KIT")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.archer.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.ZOMBIE) {
                  var9 = (Zombie)entity;
                  if(var9.getCustomName() != null && var9.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-ARCHER_KIT")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }

         if(e.getChunk().getWorld().getName().equals(this.plugin.getConfigManager().getConfig("arenas.yml").getString("arenas." + arena.getName() + ".lobby.npc.brute.world"))) {
            var6 = (var7 = e.getChunk().getEntities()).length;

            for(var5 = 0; var5 < var6; ++var5) {
               entity = var7[var5];
               if(entity.getType() == EntityType.ZOMBIE) {
                  var9 = (Zombie)entity;
                  if(var9.getCustomName() != null && var9.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BRUTE_KIT")))) {
                     e.setCancelled(true);
                     break;
                  }
               }
            }
         }
      }

   }
}

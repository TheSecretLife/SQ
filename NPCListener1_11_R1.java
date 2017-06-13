package net.playfriik.sheepquest.versions;

import java.util.Iterator;
import net.playfriik.sheepquest.SheepQuest;
import net.playfriik.sheepquest.Translation;
import net.playfriik.sheepquest.arenas.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class NPCListener1_11_R1 implements Listener {

   private SheepQuest plugin = (SheepQuest)Bukkit.getPluginManager().getPlugin("SheepQuest");


   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
      if(e.getHand() != EquipmentSlot.OFF_HAND) {
         Player player = e.getPlayer();
         Arena playerObject = null;
         Iterator rightClicked = Arena.arenaObjects.iterator();

         while(rightClicked.hasNext()) {
            Arena arena = (Arena)rightClicked.next();
            if(arena.getPlayers().contains(player.getName())) {
               playerObject = arena;
            }
         }

         if(playerObject != null) {
            if(e.getRightClicked() instanceof Sheep) {
               Sheep rightClicked1 = (Sheep)e.getRightClicked();
               if(rightClicked1.getCustomName() != null) {
                  if(rightClicked1.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BLUE_TEAM")))) {
                     if(!playerObject.getGameScoreboard().getTeam("Blue").hasPlayer(player)) {
                        if(!this.plugin.teamIsTooBig(playerObject.getGameScoreboard().getTeam("Blue"), playerObject.getName())) {
                           playerObject.getGameScoreboard().getPlayerTeam(player).removePlayer(player);
                           playerObject.getGameScoreboard().getTeam("Blue").addPlayer(player);
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_JOINED").replaceAll("%TEAMCOLOR%", "&b&l").replaceAll("%TEAM%", Translation.translate("MAIN-BLUE"))));
                        } else {
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_TOO_BIG").replaceAll("%TEAMCOLOR%", "&b&l").replaceAll("%TEAM%", Translation.translate("MAIN-BLUE"))));
                        }
                     } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_PLAYER_ON_TEAM").replaceAll("%TEAMCOLOR%", "&b&l").replaceAll("%TEAM%", Translation.translate("MAIN-BLUE"))));
                     }

                     e.setCancelled(true);
                  }

                  if(rightClicked1.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-GREEN_TEAM")))) {
                     if(!playerObject.getGameScoreboard().getTeam("Green").hasPlayer(player)) {
                        if(!this.plugin.teamIsTooBig(playerObject.getGameScoreboard().getTeam("Green"), playerObject.getName())) {
                           playerObject.getGameScoreboard().getPlayerTeam(player).removePlayer(player);
                           playerObject.getGameScoreboard().getTeam("Green").addPlayer(player);
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_JOINED").replaceAll("%TEAMCOLOR%", "&a&l").replaceAll("%TEAM%", Translation.translate("MAIN-GREEN"))));
                        } else {
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_TOO_BIG").replaceAll("%TEAMCOLOR%", "&a&l").replaceAll("%TEAM%", Translation.translate("MAIN-GREEN"))));
                        }
                     } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_PLAYER_ON_TEAM").replaceAll("%TEAMCOLOR%", "&a&l").replaceAll("%TEAM%", Translation.translate("MAIN-GREEN"))));
                     }

                     e.setCancelled(true);
                  }

                  if(rightClicked1.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-RED_TEAM")))) {
                     if(!playerObject.getGameScoreboard().getTeam("Red").hasPlayer(player)) {
                        if(!this.plugin.teamIsTooBig(playerObject.getGameScoreboard().getTeam("Red"), playerObject.getName())) {
                           playerObject.getGameScoreboard().getPlayerTeam(player).removePlayer(player);
                           playerObject.getGameScoreboard().getTeam("Red").addPlayer(player);
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_JOINED").replaceAll("%TEAMCOLOR%", "&c&l").replaceAll("%TEAM%", Translation.translate("MAIN-RED"))));
                        } else {
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_TOO_BIG").replaceAll("%TEAMCOLOR%", "&c&l").replaceAll("%TEAM%", Translation.translate("MAIN-RED"))));
                        }
                     } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_PLAYER_ON_TEAM").replaceAll("%TEAMCOLOR%", "&c&l").replaceAll("%TEAM%", Translation.translate("MAIN-RED"))));
                     }

                     e.setCancelled(true);
                  }

                  if(rightClicked1.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-YELLOW_TEAM")))) {
                     if(!playerObject.getGameScoreboard().getTeam("Yellow").hasPlayer(player)) {
                        if(!this.plugin.teamIsTooBig(playerObject.getGameScoreboard().getTeam("Yellow"), playerObject.getName())) {
                           playerObject.getGameScoreboard().getPlayerTeam(player).removePlayer(player);
                           playerObject.getGameScoreboard().getTeam("Yellow").addPlayer(player);
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_JOINED").replaceAll("%TEAMCOLOR%", "&e&l").replaceAll("%TEAM%", Translation.translate("MAIN-YELLOW"))));
                        } else {
                           player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_TOO_BIG").replaceAll("%TEAMCOLOR%", "&e&l").replaceAll("%TEAM%", Translation.translate("MAIN-YELLOW"))));
                        }
                     } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-TEAM_PLAYER_ON_TEAM").replaceAll("%TEAMCOLOR%", "&e&l").replaceAll("%TEAM%", Translation.translate("MAIN-YELLOW"))));
                     }

                     e.setCancelled(true);
                  }
               }
            }

            if(e.getRightClicked() instanceof Zombie) {
               Zombie rightClicked2 = (Zombie)e.getRightClicked();
               if(rightClicked2.getCustomName() != null) {
                  Scoreboard SBManager;
                  Objective scoreboard;
                  String objective;
                  Iterator var9;
                  ScoreboardManager SBManager1;
                  Scoreboard scoreboard1;
                  Objective objective1;
                  if(rightClicked2.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BESERKER_KIT")))) {
                     player.sendMessage("");
                     player.sendMessage("");
                     player.sendMessage("");
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-BESERKER_LINE1")));
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-BESERKER_LINE2")));
                     player.sendMessage("");
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-BESERKER_LINE4")));
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-BESERKER_LINE5")));
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                     this.plugin.getKitManager().setKit(player, "Beserker", playerObject.getName());
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-KIT_EQUIPPED").replaceAll("%KITCOLOR%", "&e&l").replaceAll("%KIT%", Translation.translate("MAIN-BESERKER_KIT"))));
                     player.playSound(player.getLocation(), "random.orb", 1.0F, 1.0F);
                     player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0F, 1.0F);
                     if(playerObject.getPlayerStartScoreboard().get(player.getName()) != null) {
                        SBManager = (Scoreboard)playerObject.getPlayerStartScoreboard().get(player.getName());
                        scoreboard = SBManager.getObjective("SheepQuest");
                        var9 = SBManager.getEntries().iterator();

                        while(var9.hasNext()) {
                           objective = (String)var9.next();
                           SBManager.resetScores(objective);
                        }

                        if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                           scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                        }

                        if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                           scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                        }

                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), SBManager)).setScore(6);
                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), SBManager)).setScore(5);
                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), SBManager)).setScore(4);
                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), SBManager)).setScore(3);
                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), SBManager)).setScore(2);
                        scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), SBManager)).setScore(1);
                        player.setScoreboard(SBManager);
                     } else {
                        SBManager1 = Bukkit.getScoreboardManager();
                        scoreboard1 = SBManager1.getNewScoreboard();
                        objective1 = scoreboard1.registerNewObjective("SheepQuest", "dummy");
                        if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                           objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                        }

                        if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                           objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                        }

                        objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), scoreboard1)).setScore(6);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), scoreboard1)).setScore(5);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), scoreboard1)).setScore(4);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), scoreboard1)).setScore(3);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), scoreboard1)).setScore(2);
                        objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), scoreboard1)).setScore(1);
                        player.setScoreboard(scoreboard1);
                        playerObject.getPlayerStartScoreboard().put(player.getName(), scoreboard1);
                     }

                     e.setCancelled(true);
                  }

                  if(rightClicked2.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-ARCHER_KIT")))) {
                     if(!player.hasPermission("sq.kit.*") && !player.hasPermission("sq.kit.archer")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-KIT_NOT_OWNED").replaceAll("%KITCOLOR%", "&a&l").replaceAll("%KIT%", Translation.translate("MAIN-ARCHER_KIT"))));
                        e.setCancelled(true);
                     } else {
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-ARCHER_LINE1")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-ARCHER_LINE2")));
                        player.sendMessage("");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-ARCHER_LINE4")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-ARCHER_LINE5")));
                        player.sendMessage("");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-ARCHER_LINE7")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-ARCHER_LINE8")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                        this.plugin.getKitManager().setKit(player, "Archer", playerObject.getName());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-KIT_EQUIPPED").replaceAll("%KITCOLOR%", "&a&l").replaceAll("%KIT%", Translation.translate("MAIN-ARCHER_KIT"))));
                        player.playSound(player.getLocation(), "random.orb", 1.0F, 1.0F);
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0F, 1.0F);
                        if(playerObject.getPlayerStartScoreboard().get(player.getName()) != null) {
                           SBManager = (Scoreboard)playerObject.getPlayerStartScoreboard().get(player.getName());
                           scoreboard = SBManager.getObjective("SheepQuest");
                           var9 = SBManager.getEntries().iterator();

                           while(var9.hasNext()) {
                              objective = (String)var9.next();
                              SBManager.resetScores(objective);
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                              scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                              scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                           }

                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), SBManager)).setScore(6);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), SBManager)).setScore(5);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), SBManager)).setScore(4);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), SBManager)).setScore(3);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), SBManager)).setScore(2);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), SBManager)).setScore(1);
                           player.setScoreboard(SBManager);
                        } else {
                           SBManager1 = Bukkit.getScoreboardManager();
                           scoreboard1 = SBManager1.getNewScoreboard();
                           objective1 = scoreboard1.registerNewObjective("SheepQuest", "dummy");
                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                              objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                              objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                           }

                           objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), scoreboard1)).setScore(6);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), scoreboard1)).setScore(5);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), scoreboard1)).setScore(4);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), scoreboard1)).setScore(3);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), scoreboard1)).setScore(2);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), scoreboard1)).setScore(1);
                           player.setScoreboard(scoreboard1);
                           playerObject.getPlayerStartScoreboard().put(player.getName(), scoreboard1);
                        }

                        e.setCancelled(true);
                     }
                  }

                  if(rightClicked2.getCustomName().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("NPC-BRUTE_KIT")))) {
                     if(!player.hasPermission("sq.kit.*") && !player.hasPermission("sq.kit.brute")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-KIT_NOT_OWNED").replaceAll("%KITCOLOR%", "&a&l").replaceAll("%KIT%", Translation.translate("MAIN-BRUTE_KIT"))));
                        e.setCancelled(true);
                     } else {
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-BRUTE_LINE1")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-BRUTE_LINE2")));
                        player.sendMessage("");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("KDESC-BRUTE_LINE4")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-BRUTE_LINE5")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "  " + Translation.translate("KDESC-BRUTE_LINE6")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m============================================"));
                        this.plugin.getKitManager().setKit(player, "Brute", playerObject.getName());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-KIT_EQUIPPED").replaceAll("%KITCOLOR%", "&a&l").replaceAll("%KIT%", Translation.translate("MAIN-BRUTE_KIT"))));
                        player.playSound(player.getLocation(), "random.orb", 1.0F, 1.0F);
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0F, 1.0F);
                        if(playerObject.getPlayerStartScoreboard().get(player.getName()) != null) {
                           SBManager = (Scoreboard)playerObject.getPlayerStartScoreboard().get(player.getName());
                           scoreboard = SBManager.getObjective("SheepQuest");
                           var9 = SBManager.getEntries().iterator();

                           while(var9.hasNext()) {
                              objective = (String)var9.next();
                              SBManager.resetScores(objective);
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                              scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                              scoreboard.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                           }

                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), SBManager)).setScore(6);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), SBManager)).setScore(5);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), SBManager)).setScore(4);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), SBManager)).setScore(3);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), SBManager)).setScore(2);
                           scoreboard.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), SBManager)).setScore(1);
                           player.setScoreboard(SBManager);
                        } else {
                           SBManager1 = Bukkit.getScoreboardManager();
                           scoreboard1 = SBManager1.getNewScoreboard();
                           objective1 = scoreboard1.registerNewObjective("SheepQuest", "dummy");
                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-WAITING")))) {
                              objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-WAITING_FOR_PLAYERS")));
                           }

                           if(playerObject.getGameState().equals(ChatColor.translateAlternateColorCodes('&', Translation.translate("GAMESTATE-STARTING")))) {
                              objective1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-STARTING_IN").replaceAll("%TIME%", this.plugin.getTimerManager().timeString(playerObject.getStartTime()))));
                           }

                           objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&1"), scoreboard1)).setScore(6);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-PLAYERS")), scoreboard1)).setScore(5);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + playerObject.getPlayers().size() + "/" + playerObject.getMaxPlayers()), scoreboard1)).setScore(4);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&2"), scoreboard1)).setScore(3);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', Translation.translate("SBOARD-KIT")), scoreboard1)).setScore(2);
                           objective1.getScore(this.plugin.scoreboardScore(ChatColor.translateAlternateColorCodes('&', "&f" + Translation.translate("SBOARD-" + this.plugin.getKitManager().getKit(player, playerObject.getName()).toUpperCase())), scoreboard1)).setScore(1);
                           player.setScoreboard(scoreboard1);
                           playerObject.getPlayerStartScoreboard().put(player.getName(), scoreboard1);
                        }

                        e.setCancelled(true);
                     }
                  }
               }
            }
         }

      }
   }
}

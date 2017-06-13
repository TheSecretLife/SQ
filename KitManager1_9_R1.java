package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_9_R1.NBTTagByte;
import net.minecraft.server.v1_9_R1.NBTTagCompound;
import net.playfriik.sheepquest.SheepQuest;
import net.playfriik.sheepquest.Translation;
import net.playfriik.sheepquest.arenas.Arena;
import net.playfriik.sheepquest.managers.KitManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class KitManager1_9_R1 implements KitManager {

   private SheepQuest plugin = (SheepQuest)Bukkit.getPluginManager().getPlugin("SheepQuest");


   public String getKit(Player player, String arenaName) {
      Arena arena = this.plugin.getArenaManager().getArena(arenaName);
      if(arena != null) {
         String playerKit;
         if(arena.getPlayersKit().containsKey(player.getName())) {
            playerKit = (String)arena.getPlayersKit().get(player.getName());
            return playerKit;
         } else {
            playerKit = "None";
            return playerKit;
         }
      } else {
         return "None";
      }
   }

   public void setKit(Player player, String kitName, String arenaName) {
      Arena arena = this.plugin.getArenaManager().getArena(arenaName);
      if(arena != null) {
         arena.getPlayersKit().put(player.getName(), kitName);
      }

   }

   public void giveKitItems(Player player, String arenaName) {
      Arena arena = this.plugin.getArenaManager().getArena(arenaName);
      if(arena != null) {
         String playerKit = (String)arena.getPlayersKit().get(player.getName());
         ItemStack is1;
         ItemMeta im1;
         net.minecraft.server.v1_9_R1.ItemStack nmsIS1;
         NBTTagCompound tag1;
         ItemStack is2;
         ItemMeta im2;
         ItemStack is3;
         LeatherArmorMeta im3;
         if(playerKit.equals("Beserker")) {
            is1 = new ItemStack(Material.IRON_AXE);
            im1 = is1.getItemMeta();
            im1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIron Axe"));
            is1.setItemMeta(im1);
            nmsIS1 = CraftItemStack.asNMSCopy(is1);
            tag1 = nmsIS1.hasTag()?nmsIS1.getTag():new NBTTagCompound();
            tag1.set("Unbreakable", new NBTTagByte((byte)1));
            nmsIS1.setTag(tag1);
            is1 = CraftItemStack.asBukkitCopy(nmsIS1);
            is2 = new ItemStack(Material.SADDLE);
            im2 = is2.getItemMeta();
            im2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-GRAB_SHEEP_ITEM")));
            is2.setItemMeta(im2);
            is3 = new ItemStack(Material.LEATHER_CHESTPLATE);
            im3 = (LeatherArmorMeta)is3.getItemMeta();
            if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l" + Translation.translate("MAIN-BLUE")));
                  im3.setColor(Color.AQUA);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l" + Translation.translate("MAIN-GREEN")));
                  im3.setColor(Color.LIME);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&l" + Translation.translate("MAIN-RED")));
                  im3.setColor(Color.RED);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l" + Translation.translate("MAIN-YELLOW")));
                  im3.setColor(Color.YELLOW);
               }
            }

            is3.setItemMeta(im3);
            this.giveArmor(player, arenaName);
            player.getInventory().setItem(0, is1);
            player.getInventory().setItem(1, is2);
            player.getInventory().setItem(8, is3);
            player.updateInventory();
         }

         if(playerKit.equals("Archer")) {
            is1 = new ItemStack(Material.WOOD_SWORD);
            im1 = is1.getItemMeta();
            im1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fWooden Sword"));
            is1.setItemMeta(im1);
            nmsIS1 = CraftItemStack.asNMSCopy(is1);
            tag1 = nmsIS1.hasTag()?nmsIS1.getTag():new NBTTagCompound();
            tag1.set("Unbreakable", new NBTTagByte((byte)1));
            nmsIS1.setTag(tag1);
            is1 = CraftItemStack.asBukkitCopy(nmsIS1);
            is2 = new ItemStack(Material.BOW);
            im2 = is2.getItemMeta();
            im2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBow"));
            is2.setItemMeta(im2);
            net.minecraft.server.v1_9_R1.ItemStack is32 = CraftItemStack.asNMSCopy(is2);
            NBTTagCompound im32 = is32.hasTag()?is32.getTag():new NBTTagCompound();
            im32.set("Unbreakable", new NBTTagByte((byte)1));
            is32.setTag(im32);
            is2 = CraftItemStack.asBukkitCopy(is32);
            ItemStack is31 = new ItemStack(Material.SADDLE);
            ItemMeta im31 = is31.getItemMeta();
            im31.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-GRAB_SHEEP_ITEM")));
            is31.setItemMeta(im31);
            ItemStack is4 = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta im4 = (LeatherArmorMeta)is4.getItemMeta();
            if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
                  im4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l" + Translation.translate("MAIN-BLUE")));
                  im4.setColor(Color.AQUA);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
                  im4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l" + Translation.translate("MAIN-GREEN")));
                  im4.setColor(Color.LIME);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
                  im4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&l" + Translation.translate("MAIN-RED")));
                  im4.setColor(Color.RED);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
                  im4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l" + Translation.translate("MAIN-YELLOW")));
                  im4.setColor(Color.YELLOW);
               }
            }

            is4.setItemMeta(im4);
            this.giveArmor(player, arenaName);
            player.getInventory().setItem(0, is1);
            player.getInventory().setItem(1, is2);
            player.getInventory().setItem(2, is31);
            player.getInventory().setItem(8, is4);
            player.updateInventory();
         }

         if(playerKit.equals("Brute")) {
            is1 = new ItemStack(Material.IRON_SWORD);
            im1 = is1.getItemMeta();
            im1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fIron Sword"));
            is1.setItemMeta(im1);
            nmsIS1 = CraftItemStack.asNMSCopy(is1);
            tag1 = nmsIS1.hasTag()?nmsIS1.getTag():new NBTTagCompound();
            tag1.set("Unbreakable", new NBTTagByte((byte)1));
            nmsIS1.setTag(tag1);
            is1 = CraftItemStack.asBukkitCopy(nmsIS1);
            is2 = new ItemStack(Material.SADDLE);
            im2 = is2.getItemMeta();
            im2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Translation.translate("MAIN-GRAB_SHEEP_ITEM")));
            is2.setItemMeta(im2);
            is3 = new ItemStack(Material.LEATHER_CHESTPLATE);
            im3 = (LeatherArmorMeta)is3.getItemMeta();
            if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l" + Translation.translate("MAIN-BLUE")));
                  im3.setColor(Color.AQUA);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l" + Translation.translate("MAIN-GREEN")));
                  im3.setColor(Color.LIME);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&l" + Translation.translate("MAIN-RED")));
                  im3.setColor(Color.RED);
               }

               if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
                  im3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l" + Translation.translate("MAIN-YELLOW")));
                  im3.setColor(Color.YELLOW);
               }
            }

            is3.setItemMeta(im3);
            this.giveArmor(player, arenaName);
            player.getInventory().setItem(0, is1);
            player.getInventory().setItem(1, is2);
            player.getInventory().setItem(8, is3);
            player.updateInventory();
         }
      }

   }

   public void giveArmor(Player player, String arenaName) {
      Arena arena = this.plugin.getArenaManager().getArena(arenaName);
      ItemStack is1 = new ItemStack(Material.LEATHER_HELMET);
      LeatherArmorMeta im1 = (LeatherArmorMeta)is1.getItemMeta();
      if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
            im1.setColor(Color.AQUA);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
            im1.setColor(Color.LIME);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
            im1.setColor(Color.RED);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
            im1.setColor(Color.YELLOW);
         }
      }

      is1.setItemMeta(im1);
      net.minecraft.server.v1_9_R1.ItemStack nmsIS1 = CraftItemStack.asNMSCopy(is1);
      NBTTagCompound tag1 = nmsIS1.hasTag()?nmsIS1.getTag():new NBTTagCompound();
      tag1.set("Unbreakable", new NBTTagByte((byte)1));
      nmsIS1.setTag(tag1);
      is1 = CraftItemStack.asBukkitCopy(nmsIS1);
      ItemStack is2 = new ItemStack(Material.LEATHER_CHESTPLATE);
      LeatherArmorMeta im2 = (LeatherArmorMeta)is2.getItemMeta();
      if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
            im2.setColor(Color.AQUA);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
            im2.setColor(Color.LIME);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
            im2.setColor(Color.RED);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
            im2.setColor(Color.YELLOW);
         }
      }

      is2.setItemMeta(im2);
      net.minecraft.server.v1_9_R1.ItemStack nmsIS2 = CraftItemStack.asNMSCopy(is2);
      NBTTagCompound tag2 = nmsIS2.hasTag()?nmsIS2.getTag():new NBTTagCompound();
      tag2.set("Unbreakable", new NBTTagByte((byte)1));
      nmsIS2.setTag(tag2);
      is2 = CraftItemStack.asBukkitCopy(nmsIS2);
      ItemStack is3 = new ItemStack(Material.LEATHER_LEGGINGS);
      LeatherArmorMeta im3 = (LeatherArmorMeta)is3.getItemMeta();
      if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
            im3.setColor(Color.AQUA);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
            im3.setColor(Color.LIME);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
            im3.setColor(Color.RED);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
            im3.setColor(Color.YELLOW);
         }
      }

      is3.setItemMeta(im3);
      net.minecraft.server.v1_9_R1.ItemStack nmsIS3 = CraftItemStack.asNMSCopy(is3);
      NBTTagCompound tag3 = nmsIS3.hasTag()?nmsIS3.getTag():new NBTTagCompound();
      tag3.set("Unbreakable", new NBTTagByte((byte)1));
      nmsIS3.setTag(tag3);
      is3 = CraftItemStack.asBukkitCopy(nmsIS3);
      ItemStack is4 = new ItemStack(Material.LEATHER_BOOTS);
      LeatherArmorMeta im4 = (LeatherArmorMeta)is4.getItemMeta();
      if(arena.getGameScoreboard().getPlayerTeam(player) != null) {
         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Blue")) {
            im4.setColor(Color.AQUA);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Green")) {
            im4.setColor(Color.LIME);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Red")) {
            im4.setColor(Color.RED);
         }

         if(arena.getGameScoreboard().getPlayerTeam(player).getName().equals("Yellow")) {
            im4.setColor(Color.YELLOW);
         }
      }

      is4.setItemMeta(im4);
      net.minecraft.server.v1_9_R1.ItemStack nmsIS4 = CraftItemStack.asNMSCopy(is4);
      NBTTagCompound tag4 = nmsIS4.hasTag()?nmsIS4.getTag():new NBTTagCompound();
      tag4.set("Unbreakable", new NBTTagByte((byte)1));
      nmsIS4.setTag(tag4);
      is4 = CraftItemStack.asBukkitCopy(nmsIS4);
      player.getInventory().setHelmet(is1);
      player.getInventory().setChestplate(is2);
      player.getInventory().setLeggings(is3);
      player.getInventory().setBoots(is4);
      player.updateInventory();
   }
}

package net.playfriik.sheepquest;

import net.playfriik.sheepquest.SheepQuest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Translation {

   private static SheepQuest plugin = (SheepQuest)Bukkit.getPluginManager().getPlugin("SheepQuest");


   public static String translate(String id) {
      return ChatColor.stripColor((String)plugin.messages.get(id));
   }
}

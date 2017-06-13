package net.playfriik.sheepquest.managers;

import org.bukkit.entity.Player;

public interface KitManager {

   String getKit(Player var1, String var2);

   void setKit(Player var1, String var2, String var3);

   void giveKitItems(Player var1, String var2);

   void giveArmor(Player var1, String var2);
}

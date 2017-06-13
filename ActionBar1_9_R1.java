package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import net.minecraft.server.v1_9_R1.IChatBaseComponent.ChatSerializer;
import net.playfriik.sheepquest.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar1_9_R1 implements ActionBar {

   public void sendActionBar(Player player, String msg) {
      String text = ChatColor.translateAlternateColorCodes('&', msg);
      IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + text + "\"}");
      PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
   }
}

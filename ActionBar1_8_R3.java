package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.playfriik.sheepquest.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar1_8_R3 implements ActionBar {

   public void sendActionBar(Player player, String msg) {
      String text = ChatColor.translateAlternateColorCodes('&', msg);
      IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + text + "\"}");
      PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
   }
}

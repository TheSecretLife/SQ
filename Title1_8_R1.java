package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import net.playfriik.sheepquest.Title;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Title1_8_R1 implements Title {

   public void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
      PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
      PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(EnumTitleAction.TIMES, (IChatBaseComponent)null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
      connection.sendPacket(packetPlayOutTimes);
      IChatBaseComponent titleSub;
      PacketPlayOutTitle packetPlayOutSubTitle;
      if(title != null) {
         title = ChatColor.translateAlternateColorCodes('&', title);
         titleSub = ChatSerializer.a("{\"text\": \"" + title + "\"}");
         packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleSub);
         connection.sendPacket(packetPlayOutSubTitle);
      }

      if(subtitle != null) {
         subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
         titleSub = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
         packetPlayOutSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, titleSub);
         connection.sendPacket(packetPlayOutSubTitle);
      }

   }
}

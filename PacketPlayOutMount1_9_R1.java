package net.playfriik.sheepquest.versions;

import net.playfriik.sheepquest.PacketPlayOutMount;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PacketPlayOutMount1_9_R1 implements PacketPlayOutMount {

   public void sendPacket(Player player) {
      net.minecraft.server.v1_9_R1.PacketPlayOutMount packet = new net.minecraft.server.v1_9_R1.PacketPlayOutMount(((CraftPlayer)player).getHandle());
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
   }
}

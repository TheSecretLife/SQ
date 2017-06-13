package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_8_R2.EnumParticle;
import net.minecraft.server.v1_8_R2.PacketPlayOutWorldParticles;
import net.playfriik.sheepquest.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ParticleEffect1_8_R2 implements ParticleEffect {

   public void sendParticleEffect(Object effect, Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) {
      PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles((EnumParticle)effect, true, (float)location.getX(), (float)location.getY(), (float)location.getZ(), offsetX, offsetY, offsetZ, speed, count, new int[0]);
      ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
   }
}

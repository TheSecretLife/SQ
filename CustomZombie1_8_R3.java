package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_8_R3.DamageSource;
import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class CustomZombie1_8_R3 extends EntityZombie {

   public CustomZombie1_8_R3(CraftWorld world) {
      super(world.getHandle());
   }

   public void g(double d0, double d1, double d2) {}

   public boolean damageEntity(DamageSource damagesource, float f) {
      return false;
   }

   public static Zombie spawnZombie(Location loc) {
      CraftWorld mcWorld = (CraftWorld)loc.getWorld();
      CustomZombie1_8_R3 customEntity = new CustomZombie1_8_R3(mcWorld);
      customEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
      customEntity.aK = loc.getYaw();
      customEntity.yaw = loc.getYaw();
      customEntity.pitch = loc.getPitch();
      ((CraftLivingEntity)customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
      mcWorld.getHandle().addEntity(customEntity, SpawnReason.CUSTOM);
      removeSounds(customEntity);
      removeAI(customEntity);
      return (CraftZombie)customEntity.getBukkitEntity();
   }

   private static void removeSounds(CustomZombie1_8_R3 customEntity) {
      CraftZombie craftEntity = (CraftZombie)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("Silent", 1);
      craftEntity.getHandle().f(nbtTag);
   }

   private static void removeAI(CustomZombie1_8_R3 customEntity) {
      CraftZombie craftEntity = (CraftZombie)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("NoAI", 1);
      craftEntity.getHandle().f(nbtTag);
   }
}

package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_10_R1.DamageSource;
import net.minecraft.server.v1_10_R1.EntityZombie;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftZombie;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class CustomZombie1_10_R1 extends EntityZombie {

   public CustomZombie1_10_R1(CraftWorld world) {
      super(world.getHandle());
   }

   public void g(double d0, double d1, double d2) {}

   public boolean damageEntity(DamageSource damagesource, float f) {
      return false;
   }

   public static Zombie spawnZombie(Location loc) {
      CraftWorld mcWorld = (CraftWorld)loc.getWorld();
      CustomZombie1_10_R1 customEntity = new CustomZombie1_10_R1(mcWorld);
      customEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
      customEntity.aQ = loc.getYaw();
      customEntity.yaw = loc.getYaw();
      customEntity.pitch = loc.getPitch();
      ((CraftLivingEntity)customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
      mcWorld.getHandle().addEntity(customEntity, SpawnReason.CUSTOM);
      removeSounds(customEntity);
      removeAI(customEntity);
      return (CraftZombie)customEntity.getBukkitEntity();
   }

   private static void removeSounds(CustomZombie1_10_R1 customEntity) {
      CraftZombie craftEntity = (CraftZombie)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("Silent", 1);
      craftEntity.getHandle().f(nbtTag);
   }

   private static void removeAI(CustomZombie1_10_R1 customEntity) {
      CraftZombie craftEntity = (CraftZombie)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("NoAI", 1);
      craftEntity.getHandle().f(nbtTag);
   }
}

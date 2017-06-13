package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_10_R1.DamageSource;
import net.minecraft.server.v1_10_R1.EntitySheep;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftSheep;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class CustomSheep1_10_R1 extends EntitySheep {

   public CustomSheep1_10_R1(CraftWorld world) {
      super(world.getHandle());
   }

   public void g(double d0, double d1, double d2) {}

   public boolean damageEntity(DamageSource damagesource, float f) {
      return false;
   }

   public static Sheep spawnSheep(Location loc) {
      CraftWorld mcWorld = (CraftWorld)loc.getWorld();
      CustomSheep1_10_R1 customEntity = new CustomSheep1_10_R1(mcWorld);
      customEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
      customEntity.aQ = loc.getYaw();
      customEntity.yaw = loc.getYaw();
      customEntity.pitch = loc.getPitch();
      ((CraftLivingEntity)customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
      mcWorld.getHandle().addEntity(customEntity, SpawnReason.CUSTOM);
      removeSounds(customEntity);
      removeAI(customEntity);
      return (CraftSheep)customEntity.getBukkitEntity();
   }

   private static void removeSounds(CustomSheep1_10_R1 customEntity) {
      CraftSheep craftEntity = (CraftSheep)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("Silent", 1);
      craftEntity.getHandle().f(nbtTag);
   }

   private static void removeAI(CustomSheep1_10_R1 customEntity) {
      CraftSheep craftEntity = (CraftSheep)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("NoAI", 1);
      craftEntity.getHandle().f(nbtTag);
   }
}

package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_8_R3.DamageSource;
import net.minecraft.server.v1_8_R3.EntitySheep;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSheep;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class CustomSheep1_8_R3 extends EntitySheep {

   public CustomSheep1_8_R3(CraftWorld world) {
      super(world.getHandle());
   }

   public void g(double d0, double d1, double d2) {}

   public boolean damageEntity(DamageSource damagesource, float f) {
      return false;
   }

   public static Sheep spawnSheep(Location loc) {
      CraftWorld mcWorld = (CraftWorld)loc.getWorld();
      CustomSheep1_8_R3 customEntity = new CustomSheep1_8_R3(mcWorld);
      customEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
      customEntity.aK = loc.getYaw();
      customEntity.yaw = loc.getYaw();
      customEntity.pitch = loc.getPitch();
      ((CraftLivingEntity)customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
      mcWorld.getHandle().addEntity(customEntity, SpawnReason.CUSTOM);
      removeSounds(customEntity);
      removeAI(customEntity);
      return (CraftSheep)customEntity.getBukkitEntity();
   }

   private static void removeSounds(CustomSheep1_8_R3 customEntity) {
      CraftSheep craftEntity = (CraftSheep)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("Silent", 1);
      craftEntity.getHandle().f(nbtTag);
   }

   private static void removeAI(CustomSheep1_8_R3 customEntity) {
      CraftSheep craftEntity = (CraftSheep)customEntity.getBukkitEntity();
      NBTTagCompound nbtTag = new NBTTagCompound();
      craftEntity.getHandle().c(nbtTag);
      nbtTag.setInt("NoAI", 1);
      craftEntity.getHandle().f(nbtTag);
   }
}

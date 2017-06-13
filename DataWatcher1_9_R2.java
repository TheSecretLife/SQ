package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_9_R2.AttributeInstance;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.GenericAttributes;
import net.playfriik.sheepquest.DataWatcher;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftEntity;
import org.bukkit.entity.Sheep;

public class DataWatcher1_9_R2 implements DataWatcher {

   public void extendTargetingRange(Sheep sheep, Location targetingLocation) {
      double targetingDistance = sheep.getLocation().distance(targetingLocation);
      AttributeInstance attributes = ((EntityInsentient)((CraftEntity)sheep).getHandle()).getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
      attributes.setValue(targetingDistance + 16.0D);
   }
}

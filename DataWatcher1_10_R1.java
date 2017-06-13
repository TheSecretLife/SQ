package net.playfriik.sheepquest.versions;

import net.minecraft.server.v1_10_R1.AttributeInstance;
import net.minecraft.server.v1_10_R1.EntityInsentient;
import net.minecraft.server.v1_10_R1.GenericAttributes;
import net.playfriik.sheepquest.DataWatcher;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Sheep;

public class DataWatcher1_10_R1 implements DataWatcher {

   public void extendTargetingRange(Sheep sheep, Location targetingLocation) {
      double targetingDistance = sheep.getLocation().distance(targetingLocation);
      AttributeInstance attributes = ((EntityInsentient)((CraftEntity)sheep).getHandle()).getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
      attributes.setValue(targetingDistance + 16.0D);
   }
}

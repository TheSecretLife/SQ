package net.playfriik.sheepquest.managers;

import org.bukkit.Location;

public interface TimerManager {

   void startTimer(String var1);

   void gameStartTimer(String var1);

   void onSecondTimer(String var1);

   void gameEndTimer(String var1);

   void spawnFireworks(String var1);

   void arrowTimer(String var1);

   void sheepTimer(String var1);

   void cooldownTimer(String var1, String var2);

   void sheepGrabTimer(String var1);

   Location getCenter(Location var1, Location var2, String var3);

   String timeString(int var1);

   boolean isInside(Location var1, Location var2, Location var3);
}

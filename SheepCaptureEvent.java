package net.playfriik.sheepquest.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SheepCaptureEvent extends Event {

   private Player player;
   private int amount;
   private static HandlerList handlers = new HandlerList();


   public SheepCaptureEvent(Player player, int amount) {
      this.player = player;
      this.amount = amount;
   }

   public Player getPlayer() {
      return this.player;
   }

   public int getAmount() {
      return this.amount;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }
}

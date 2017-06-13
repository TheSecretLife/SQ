package net.playfriik.sheepquest.events;

import java.util.ArrayList;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TeamLoseEvent extends Event {

   private ArrayList teams;
   private static HandlerList handlers = new HandlerList();


   public TeamLoseEvent(ArrayList teams) {
      this.teams = teams;
   }

   public ArrayList getTeams() {
      return this.teams;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }
}

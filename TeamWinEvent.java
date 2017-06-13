package net.playfriik.sheepquest.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scoreboard.Team;

public class TeamWinEvent extends Event {

   private Team team;
   private static HandlerList handlers = new HandlerList();


   public TeamWinEvent(Team team) {
      this.team = team;
   }

   public Team getTeam() {
      return this.team;
   }

   public HandlerList getHandlers() {
      return handlers;
   }

   public static HandlerList getHandlerList() {
      return handlers;
   }
}

package net.playfriik.sheepquest.arenas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Arena {

   public static ArrayList arenaObjects = new ArrayList();
   public Scoreboard gameScoreboard;
   private String name;
   private int neededPlayers;
   private int maxPlayers;
   private ArrayList players = new ArrayList();
   private int startTime;
   private float gameStartTime;
   private int gameTime;
   private int sheepTime;
   private int startTimerID;
   private int gameStartTimerID;
   private int arrowTimerID;
   private int onSecondTimerID;
   private int sheepTimerID;
   private int sheepGrabTimerID;
   private int gameEndTimerID;
   private int blueSheeps = 0;
   private int greenSheeps = 0;
   private int redSheeps = 0;
   private int yellowSheeps = 0;
   private ArrayList arenaSheeps = new ArrayList();
   private ArrayList playersDead = new ArrayList();
   private ArrayList playersGrabCooldowned = new ArrayList();
   private ArrayList playersThrowCooldowned = new ArrayList();
   private HashMap playersDoubleJumpCooldowned = new HashMap();
   private HashMap playersDrawing = new HashMap();
   private HashMap playersDrawingTaskID0 = new HashMap();
   private HashMap playersDrawingTaskID1 = new HashMap();
   private HashMap playersDrawingTaskID2 = new HashMap();
   private HashMap playersDrawingTaskID3 = new HashMap();
   private HashMap playersDrawingTaskID4 = new HashMap();
   private HashMap playersDrawingTaskID5 = new HashMap();
   private HashMap playersGrabRecord = new HashMap();
   private HashMap playerStartScoreboard = new HashMap();
   private HashMap playersKit = new HashMap();
   private HashMap playerTeamValues = new HashMap();
   private boolean firstBlood;
   private boolean overTime;
   private String gameState;
   private Team winningTeam;


   public Arena(String arenaName, int startTime, int gameStartTime, int gameTime, int sheepTime, int neededPlayers, int maxPlayers) {
      this.name = arenaName;
      this.startTime = startTime;
      this.gameStartTime = (float)gameStartTime;
      this.gameTime = gameTime;
      this.sheepTime = sheepTime;
      this.neededPlayers = neededPlayers;
      this.maxPlayers = maxPlayers;
      arenaObjects.add(this);
   }

   public Scoreboard getGameScoreboard() {
      return this.gameScoreboard;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getNeededPlayers() {
      return this.neededPlayers;
   }

   public void setNeededPlayers(int neededPlayers) {
      this.neededPlayers = neededPlayers;
   }

   public int getMaxPlayers() {
      return this.maxPlayers;
   }

   public void setMaxPlayers(int maxPlayers) {
      this.maxPlayers = maxPlayers;
   }

   public ArrayList getPlayers() {
      return this.players;
   }

   public int getStartTime() {
      return this.startTime;
   }

   public void setStartTime(int startTime) {
      this.startTime = startTime;
   }

   public float getGameStartTime() {
      return this.gameStartTime;
   }

   public void setGameStartTime(float gameStartTime) {
      this.gameStartTime = gameStartTime;
   }

   public int getGameTime() {
      return this.gameTime;
   }

   public void setGameTime(int gameTime) {
      this.gameTime = gameTime;
   }

   public int getSheepTime() {
      return this.sheepTime;
   }

   public void setSheepTime(int sheepTime) {
      this.sheepTime = sheepTime;
   }

   public int getStartTimerID() {
      return this.startTimerID;
   }

   public void setStartTimerID(int startTimerID) {
      this.startTimerID = startTimerID;
   }

   public int getGameStartTimerID() {
      return this.gameStartTimerID;
   }

   public void setGameStartTimerID(int gameStartTimerID) {
      this.gameStartTimerID = gameStartTimerID;
   }

   public int getArrowTimerID() {
      return this.arrowTimerID;
   }

   public void setArrowTimerID(int arrowTimerID) {
      this.arrowTimerID = arrowTimerID;
   }

   public int getOnSecondTimerID() {
      return this.onSecondTimerID;
   }

   public void setOnSecondTimerID(int onSecondTimerID) {
      this.onSecondTimerID = onSecondTimerID;
   }

   public int getSheepTimerID() {
      return this.sheepTimerID;
   }

   public void setSheepTimerID(int sheepTimerID) {
      this.sheepTimerID = sheepTimerID;
   }

   public int getSheepGrabTimerID() {
      return this.sheepGrabTimerID;
   }

   public void setSheepGrabTimerID(int sheepGrabTimerID) {
      this.sheepGrabTimerID = sheepGrabTimerID;
   }

   public int getGameEndTimerID() {
      return this.gameEndTimerID;
   }

   public void setGameEndTimerID(int gameEndTimerID) {
      this.gameEndTimerID = gameEndTimerID;
   }

   public int getBlueSheeps() {
      return this.blueSheeps;
   }

   public void setBlueSheeps(int blueSheeps) {
      this.blueSheeps = blueSheeps;
   }

   public int getGreenSheeps() {
      return this.greenSheeps;
   }

   public void setGreenSheeps(int greenSheeps) {
      this.greenSheeps = greenSheeps;
   }

   public int getRedSheeps() {
      return this.redSheeps;
   }

   public void setRedSheeps(int redSheeps) {
      this.redSheeps = redSheeps;
   }

   public int getYellowSheeps() {
      return this.yellowSheeps;
   }

   public void setYellowSheeps(int yellowSheeps) {
      this.yellowSheeps = yellowSheeps;
   }

   public ArrayList getArenaSheeps() {
      return this.arenaSheeps;
   }

   public ArrayList getPlayersDead() {
      return this.playersDead;
   }

   public ArrayList getPlayersGrabCooldowned() {
      return this.playersGrabCooldowned;
   }

   public ArrayList getPlayersThrowCooldowned() {
      return this.playersThrowCooldowned;
   }

   public HashMap getPlayersDoubleJumpCooldowned() {
      return this.playersDoubleJumpCooldowned;
   }

   public HashMap getPlayersDrawing() {
      return this.playersDrawing;
   }

   public HashMap getPlayersDrawingTaskID0() {
      return this.playersDrawingTaskID0;
   }

   public HashMap getPlayersDrawingTaskID1() {
      return this.playersDrawingTaskID1;
   }

   public HashMap getPlayersDrawingTaskID2() {
      return this.playersDrawingTaskID2;
   }

   public HashMap getPlayersDrawingTaskID3() {
      return this.playersDrawingTaskID3;
   }

   public HashMap getPlayersDrawingTaskID4() {
      return this.playersDrawingTaskID4;
   }

   public HashMap getPlayersDrawingTaskID5() {
      return this.playersDrawingTaskID5;
   }

   public HashMap getPlayersGrabRecord() {
      return this.playersGrabRecord;
   }

   public HashMap getPlayerStartScoreboard() {
      return this.playerStartScoreboard;
   }

   public HashMap getPlayersKit() {
      return this.playersKit;
   }

   public HashMap getPlayerTeamValues() {
      return this.playerTeamValues;
   }

   public boolean getFirstBlood() {
      return this.firstBlood;
   }

   public void setFirstBlood(boolean firstBlood) {
      this.firstBlood = firstBlood;
   }

   public boolean getOverTime() {
      return this.overTime;
   }

   public void setOverTime(boolean overTime) {
      this.overTime = overTime;
   }

   public String getGameState() {
      return this.gameState;
   }

   public void setGameState(String gameState) {
      this.gameState = gameState;
   }

   public Team getWinningTeam() {
      return this.winningTeam;
   }

   public void setWinningTeam(Team winningTeam) {
      this.winningTeam = winningTeam;
   }

   public void sendMessage(String message) {
      Iterator var3 = this.players.iterator();

      while(var3.hasNext()) {
         String arenaPlayer = (String)var3.next();
         Bukkit.getPlayer(arenaPlayer).sendMessage(message);
      }

   }
}

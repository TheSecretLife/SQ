package net.playfriik.sheepquest.arenas;

import java.io.IOException;
import net.playfriik.sheepquest.arenas.Arena;
import org.bukkit.entity.Player;

public interface ArenaManager {

   Arena getArena(String var1);

   void addPlayer(Player var1, String var2);

   void removePlayer(Player var1, String var2);

   void endArena(String var1);

   void loadArenas();

   void createArena(String var1, int var2, int var3, int var4, int var5, int var6, int var7) throws IOException;

   void deleteArena(String var1) throws IOException;
}

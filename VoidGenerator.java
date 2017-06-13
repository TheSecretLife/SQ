package net.playfriik.sheepquest;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;

public class VoidGenerator extends ChunkGenerator {

   public byte[] generate(World world, Random rand, int chunkX, int chunkZ) {
      byte[] chunk = new byte['\u8000'];
      if(chunkX == 0 && chunkZ == 0) {
         chunk[0] = (byte)Material.BEDROCK.getId();
      }

      for(int x = 0; x < 16; ++x) {
         for(int z = 0; z < 16; ++z) {
            world.setBiome(x, z, Biome.PLAINS);
         }
      }

      return chunk;
   }
}

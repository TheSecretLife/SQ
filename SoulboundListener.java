package net.playfriik.sheepquest.listeners;

import java.util.Arrays;
import java.util.Iterator;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SoulboundListener implements Listener {

   private static final String soulboundTag = ChatColor.GOLD + "Soulbound";


   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onSoulboundDrop(PlayerDropItemEvent e) {
      if(isSoulbound(e.getItemDrop().getItemStack())) {
         Player player = e.getPlayer();
         player.playSound(player.getLocation(), "mob.blaze.hit", 0.25F, 0.5F);
         player.playSound(player.getLocation(), "entity.blaze.hurt", 0.25F, 0.5F);
         e.getItemDrop().remove();
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public void onPlayerDeath(PlayerDeathEvent e) {
      Iterator it = e.getDrops().iterator();

      while(it.hasNext()) {
         if(isSoulbound((ItemStack)it.next())) {
            it.remove();
         }
      }

   }

   public static boolean isSoulbound(ItemStack item) {
      ItemMeta meta = item.getItemMeta();
      return item.hasItemMeta() && meta.hasLore() && meta.getLore().contains(soulboundTag);
   }

   public static void soulbind(ItemStack stack) {
      ItemMeta meta = stack.getItemMeta();
      if(!meta.hasLore()) {
         meta.setLore(Arrays.asList(new String[]{soulboundTag}));
      } else {
         meta.getLore().add(soulboundTag);
      }

      stack.setItemMeta(meta);
   }
}

package me.morgancentral99.extreme.inventorys;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.morgancentral99.extreme.Main;
import me.morgancentral99.extreme.api.ItemBuilder;

public class Inventorys implements Listener {

	Main main;
	public static Inventory guard = Bukkit.createInventory(null, 36, ChatColor.GOLD + "Guard");
	


	static ItemStack GPM = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
	static ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1);
	ItemMeta skullMeta = skull.getItemMeta();
	static ItemStack feed = new ItemBuilder(Material.COOKED_BEEF, 1).displayname(ChatColor.AQUA + "Feed Yourself")
			.build();
	static ItemStack serverInfo = new ItemBuilder(Material.PAPER, 1).displayname(ChatColor.AQUA + "Server Info")
			.build();
	static ItemStack diamondHelm = new ItemBuilder(Material.DIAMOND_HELMET, 1)
			.displayname(ChatColor.AQUA + "Equip yourself").build();
	static ItemStack exit = new ItemBuilder(Material.LAPIS_BLOCK, 1).displayname(ChatColor.AQUA + "Exit").build();

	public static void openMenu(Player player) {
		
		guard.setItem(0, GPM);
		guard.setItem(1, GPM);
		guard.setItem(2, GPM);
		guard.setItem(3, GPM);
		guard.setItem(4, GPM);
		guard.setItem(5, GPM);
		guard.setItem(6, GPM);
	    guard.setItem(7, GPM);
	    guard.setItem(8, GPM);
		guard.setItem(9, GPM);
		guard.setItem(10, GPM);
		guard.setItem(11, GPM);
		guard.setItem(12, GPM);
		guard.setItem(13, GPM);
		guard.setItem(14, GPM);
		guard.setItem(15, GPM);
		guard.setItem(16, GPM);
		guard.setItem(17, GPM);
		guard.setItem(18, GPM);
		guard.setItem(19, GPM);
		guard.setItem(20, feed);
		guard.setItem(21, GPM);
		guard.setItem(22, serverInfo);
		guard.setItem(23, GPM);
		guard.setItem(24, diamondHelm);
		guard.setItem(25, GPM);
		guard.setItem(26, GPM);
		guard.setItem(27, GPM);
		guard.setItem(28, GPM);
		guard.setItem(29, GPM);
		guard.setItem(30, GPM);
		guard.setItem(31, GPM);
		guard.setItem(32, GPM);
		guard.setItem(33, GPM);
		guard.setItem(34, GPM);
		guard.setItem(35, exit);
		
		
		
		player.openInventory(guard);
	}

	private void equipEqu(Player player) {
		
		
		System.out.println("equipEqu");
		
		
		
		ItemStack helm = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta im = (LeatherArmorMeta) helm.getItemMeta();
		im.setColor(Color.BLUE);
		im.spigot().setUnbreakable(true);
		helm.setItemMeta(im);
		ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta im2 = (LeatherArmorMeta) chest.getItemMeta();
		im2.setColor(Color.BLUE);
		im2.spigot().setUnbreakable(true);
		chest.setItemMeta(im2);
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta im3 = (LeatherArmorMeta) leggings.getItemMeta();
		im3.setColor(Color.BLUE);
		im3.spigot().setUnbreakable(true);
		leggings.setItemMeta(im3);
		ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta im4 = (LeatherArmorMeta) boots.getItemMeta();
		im4.setColor(Color.BLUE);
		im4.spigot().setUnbreakable(true);
		boots.setItemMeta(im4);
		
		ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta ironMeta = ironSword.getItemMeta();
		ironMeta.setDisplayName(ChatColor.DARK_RED + "Guards Emergancy Sword");
		ironMeta.setLore(Arrays.asList(ChatColor.RED + "Use in LOCKDOWN MODE"));
		
		
		
		ItemStack[] armour = {};
		armour[0] = helm;
		armour[1] = chest;
		armour[2] = leggings;
		armour[3] = boots;
		
		player.getInventory().setArmorContents(armour);
		
		ItemStack[] items = {};
		items[0] = ironSword;
		
	
	} 
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		System.out.println("onInventoryClick");
			Player player = (Player) e.getWhoClicked();
			System.out.println("Who Clicked" + player);
			ItemStack clicked = e.getCurrentItem();
			Inventory inv2 = e.getInventory();
			//		e.setCancelled(true);
		//	System.out.println("Clicked: " + clicked.get);
					if(clicked.isSimilar(GPM)) {
						e.setCancelled(true);
					} else if(clicked.isSimilar(serverInfo)) {
						Main.sendInfo(player);
						e.setCancelled(true);
					} else if(clicked.isSimilar(diamondHelm)) {
						equipEqu(player);
						e.setCancelled(true);
					} else if (clicked.isSimilar(feed)) {
						player.setFoodLevel(20);
						e.setCancelled(true);
					} else if (clicked.isSimilar(exit)) {
						player.closeInventory();
						e.setCancelled(true);
					}
		
		}
}

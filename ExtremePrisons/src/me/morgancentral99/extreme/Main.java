package me.morgancentral99.extreme;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.morgancentral99.extreme.api.ItemBuilder;
import me.morgancentral99.extreme.commands.GuardCommand;
import me.morgancentral99.extreme.inventorys.Inventorys;
import me.morgancentral99.extreme.listeners.Click;

public class Main extends JavaPlugin implements Listener {
	
	Logger logger = Bukkit.getLogger();
	private static Main instance;
	int guard1;
	
	
	@Override
	public void onEnable() {
		logger.info("ExtremePrisons Loading");
		instance = this;
		registerCommands();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		registerEvents();
	}
	
	private void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new Click(), this);
		pm.registerEvents(new Inventorys(), this);
	}

	private void registerCommands() {
		 ((CraftServer) this.getServer()).getCommandMap().register("Guards", new GuardCommand("Guards"));
		
	}

	public static Main getInstance() {
		return instance;
	}
	
	ItemStack guard = new ItemBuilder(Material.BLAZE_ROD).displayname("&6Guard").build();
 //&6Guard"
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		//logger.fine("Someone Clicked");
		 
		p.sendMessage("You Clicked: " + p.getInventory().getName());
		if(((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			p.sendMessage(p.getInventory().getItemInHand().getItemMeta().getDisplayName() + "" + guard.getItemMeta().getDisplayName());
			if(p.getItemInHand().isSimilar(guard)) {
				p.sendMessage("Opening the Guard GUI");
				Inventorys.openMenu(p);
			}

		}
	}



	public static void sendInfo(Player player) {
		
		player.sendMessage("There are currently");
		
		
	}

	

}

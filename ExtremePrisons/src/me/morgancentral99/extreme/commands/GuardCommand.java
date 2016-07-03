package me.morgancentral99.extreme.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.morgancentral99.extreme.api.ItemBuilder;

public class GuardCommand extends BukkitCommand {

	public GuardCommand(String name) {
		super(name);
		this.description = "Get Guard Gear";
		this.usageMessage = "/Guard";
		this.setPermission("Extreme.Guard");
		this.setAliases(new ArrayList<String>());
	}

	@Override
	public boolean execute(CommandSender s, String label, String[] args) {
		Player player = (Player)s;
		if(!s.hasPermission(this.getPermission())) {
			s.sendMessage(ChatColor.RED + "No permissions");
			return true;
		} else {
			s.sendMessage("Giving you Guard Stick");
				ItemStack guard = new ItemBuilder(Material.BLAZE_ROD).displayname(ChatColor.GOLD + "Guard").build();
					player.getInventory().addItem(guard);
					return true;
	} 
	}
	
	
}

	
	
	
	
	

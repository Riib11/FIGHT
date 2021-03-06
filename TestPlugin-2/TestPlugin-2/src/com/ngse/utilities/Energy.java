package com.ngse.utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.ngse.fight.FIGHT;

public class Energy {

	// TODO: Improve ascetic quality of energy display

	private int energy;

	private static String fillChar = " ";
	private static String frontChar = "[";
	private static String backChar = "]";

	public int getEnergy() {
		return energy;
	}

	public Energy(int a) {
		energy = a;
	}

	public static int get(Player p) {
		if (p.hasMetadata("energy")) {
			return ((Energy) (p.getMetadata("energy").get(0).value()))
					.getEnergy();
		} else {
			return -1;
		}
	}

	public static int set(Player p, int a) {
		int b = get(p);
		p.setMetadata("energy", new FixedMetadataValue(FIGHT.plugin,
				new Energy(a)));
		sendEnergyStatus(p, b - a);
		return get(p);
	}

	public static int add(Player p, int a) {
		set(p, get(p) + a);
		sendEnergyStatus(p, a);
		return get(p);
	}

	public static String convertToString(Energy e) {
		return convertToString(e.getEnergy());
	}

	public static String convertToString(int a) {
		String str = frontChar;
		if (a > 0) {
			for (int i = 0; i < a; i++) {
				str += fillChar;
			}
			str += backChar;
		}
		return str;
	}

	/*
	 * Sends amount of energy the player has
	 * 
	 * @Param d: >0 means positive change recently. <0 means negative change
	 * recently. 0 means no change
	 */
	public static void sendEnergyStatus(Player p, int d) {
		if (d > 0) {
			// p.sendMessage(ChatColor.BLUE + "[ENERGY] " + ChatColor.GREEN
			// + Energy.convertToString(Energy.get(p)));
			updateEnergyDisplay(p, ChatColor.GOLD);
		} else if (d < 0) {
			// p.sendMessage(ChatColor.RED + "[ENERGY] " + ChatColor.GREEN
			// + Energy.convertToString(Energy.get(p)));
			updateEnergyDisplay(p, ChatColor.RED);
		} else if (d == 0) {
			// nothing
		}
	}

	public static void updateEnergyDisplay(Player p, ChatColor c) {
		// p.setTotalExperience(get(p) / 5);
		// p.sendMessage(String.valueOf(p.getTotalExperience()) + " : "
		// + String.valueOf(get(p)));
		Title title = new Title(" ", convertToString(get(p)), 0, 15, 0);
		title.setSubtitleColor(c);
		title.send(p);
	}
}

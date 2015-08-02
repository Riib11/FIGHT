package com.ngse.utilities;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;

public class Effects {

	public static void play(Location l, Effect e, int times) {
		play(l, e, times, 1);
	}

	public static void play(Location l, Effect e, int times, int data) {
		for (int x = 0; x <= times; x++) {
			l.getWorld().playEffect(l, e, data);
		}
	}

	public static void sound(Location l, Sound s, int times, float volume,
			float pitch) {
		for (int x = 0; x <= times; x++) {
			l.getWorld().playSound(l, s, volume, pitch);
		}
	}

	public static void sound(Location l, Sound s) {
		l.getWorld().playSound(l, s, 0.5f, 1);		
	}
}

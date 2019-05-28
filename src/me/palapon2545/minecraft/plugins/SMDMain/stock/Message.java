package me.palapon2545.minecraft.plugins.SMDMain.stock;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.ChatColor;

public class Message {
	File langFile = new File(StockInt.pluginDir + File.separator + "language.yml");
	FileConfiguration langData = YamlConfiguration.loadConfiguration(langFile);

	public class thailand {
		public String spawn_not_found = langData.getString("th.spawn_not_found");
		public String spawn_teleport = langData.getString("th.spawn_not_found");
		public String spawn_prefix = langData.getString("th.spawn_prefix");
		public String spawn_set = langData.getString("th.spawn_set");
		public String teleport_prefix = langData.getString("th.teleport_prefix");
	};

	public static thailand th;

	public class english {
		public String spawn_not_found = langData.getString("en.spawn_not_found");
		public String spawn_teleport = langData.getString("en.spawn_not_found");
		public String spawn_prefix = langData.getString("en.spawn_prefix");
		public String spawn_set = langData.getString("en.spawn_set");
		public String teleport_prefix = langData.getString("th.teleport_prefix");
	};

	public static english en;

	public void createDefaultMessage() {
		try {
			langData.set("th.teleport_prefix", ChatColor.LIGHT_PURPLE + "ระบบวาร์ป> ");
			langData.set("en.teleport_prefix", ChatColor.LIGHT_PURPLE + "Teleportation> ");

			langData.set("th.spawn_prefix", ChatColor.LIGHT_PURPLE + "ระบบวาร์ป> ");
			langData.set("en.spawn_prefix", ChatColor.LIGHT_PURPLE + "Teleportation> ");

			langData.set("th.spawn_not_found", ChatColor.RED + "จุดเกิดหลักของเซิฟเวอร์ยังไม่ได้รับการตั้งค่า");
			langData.set("en.spawn_not_found", ChatColor.RED + "The server's spawn location hasn't been set yet.");
			langData.set("th.spawn_teleport", ChatColor.GREEN + "คุณถูกวาร์ปมายังจุดเกิดหลักของเซิฟเวอร์");
			langData.set("en.spawn_teleport", ChatColor.GREEN + "You have been teleported to the server's global spawn.");
			langData.set("th.spawn_set", ChatColor.AQUA + "คุณได้เซ็ตจุดเกิดหลักของเซิฟเวอร์");
			langData.set("en.spawn_set", ChatColor.AQUA + "You set the server's global spawn.");
			langData.save(langFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

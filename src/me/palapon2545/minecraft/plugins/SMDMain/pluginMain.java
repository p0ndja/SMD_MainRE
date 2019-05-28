package me.palapon2545.minecraft.plugins.SMDMain;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.palapon2545.minecraft.plugins.SMDMain.stock.Message;
import me.palapon2545.minecraft.plugins.SMDMain.stock.StockInt;

public class pluginMain extends JavaPlugin implements Listener {

	public final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onEnable() {
		if (getConfig().getBoolean("spawn.avalible") == true
				&& Bukkit.getWorld(getConfig().getString("spawn.world")) != null) {
			StockInt.SpawnLocation.x = getConfig().getDouble("spawn.x");
			StockInt.SpawnLocation.y = getConfig().getDouble("spawn.y");
			StockInt.SpawnLocation.z = getConfig().getDouble("spawn.z");
			StockInt.SpawnLocation.yaw = getConfig().getDouble("spawn.yaw");
			StockInt.SpawnLocation.pitch = getConfig().getDouble("spawn.pitch");
			StockInt.SpawnLocation.world = Bukkit.getWorld(getConfig().getString("spawn.world"));

			StockInt.SpawnLocation.isSpawnSet = true;
		}

		logger.info("Enabled");
	}

	@Override
	public void onDisable() {
		logger.info("Disabled");
	}

	public void sendMessage(String target, String prefix, String... message) {
		Player t = Bukkit.getPlayer(target);
		t.sendMessage(prefix + " " + message);
	}

	public boolean isPlayer(CommandSender sender) {
		if (sender instanceof Player)
			return true;
		return false;
	}

	public String checkLang(Player name) {
		// if (check player prefer language) EN = 0 , TH = 1
		return "th";

	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

	}

	File langFile = new File(StockInt.pluginDir + File.separator + "language.yml");
	FileConfiguration langData = YamlConfiguration.loadConfiguration(langFile);

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if (CommandLabel.equalsIgnoreCase("spawn") && isPlayer(sender)) {
			Player p = (Player) sender;
			if (StockInt.SpawnLocation.isSpawnSet) {

			} else {
				p.sendMessage(langData.getString(checkLang(p) + ".spawn_prefix")
						+ langData.getString(checkLang(p) + ".spawn_not_found"));
			}
		} else {
			logger.info("You're not PLAYER to use this command");
		}

		if (CommandLabel.equalsIgnoreCase("setspawn")) {

		}

		if (CommandLabel.equalsIgnoreCase("removespawn")) {

		}

		return true;
	}
}

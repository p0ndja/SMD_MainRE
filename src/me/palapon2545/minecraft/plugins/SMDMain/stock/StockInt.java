package me.palapon2545.minecraft.plugins.SMDMain.stock;

import org.bukkit.World;

public class StockInt {
	public static String pluginDir = "plugins/SMDMain/";
	
	public class spawn {
		public double x,y,z,yaw,pitch;
		public World world;
		public boolean isSpawnSet = false;
	};
	
	public static spawn SpawnLocation;

}

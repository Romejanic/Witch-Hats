package assets.witch.common.core;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	
	public static int witchHatID;
	
	public static String witchHatName;
	
	public static boolean useXmasHat;
	
	public ConfigHandler(File file) {
		
		final String itemIDs = "Item IDs";
		final String local = "String localization";
		final String settings = "Settings";
		
		Configuration config = new Configuration(file);
		
		config.load();
		
		config.addCustomCategoryComment(itemIDs, "The in-code IDs for all the mod's items");
		config.addCustomCategoryComment(local, "The translation of unlocalized strings to human-readable text");
		config.addCustomCategoryComment(settings, "Customizable settings and inner workings of the mod");
		
		witchHatID = config.get(itemIDs, "Witch Hat ID", 700).getInt();
		
		witchHatName = config.get(local, "item.witch.hat.name", "Witch Hat").getString();
		
		useXmasHat = config.get(settings, "Xmas hat enabled", true, "Does the hat's texture change in December?").getBoolean(true);
		
		config.save();
		
	}
	
	public static void setup() {
		
		File folder = new File(".", "romejanic");
		Side s = FMLCommonHandler.instance().getEffectiveSide();
		
		if(s == s.CLIENT) {
			
			folder = new File(Minecraft.getMinecraft().mcDataDir, "romejanic");
			
		}
		
		new ConfigHandler(new File(folder, "Witch Hats.txt"));
		
	}

}

package assets.witch.common;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import assets.witch.common.core.CommonProxy;
import assets.witch.common.core.ConfigHandler;
import assets.witch.common.core.ConnectionHandler;
import assets.witch.common.item.ItemWitchHat;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid="WitchHats", name="Witch Hats", version="1.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WitchHats {
	
	public static Item witchHat;
	
	public static final String updateURL = "https://dl.dropboxusercontent.com/s/ku7som1tkhvrlww/1.1UpToDate.txt?dl=1&token_hash=AAGYkgfkvgVBYilwro_4hj-t6xItfK3VT3GCHlLJY0VSPA";
	public static boolean upToDate = true;
	
	@Mod.Instance
	public static WitchHats instance;
	
	@SidedProxy(clientSide="assets.witch.client.core.ClientProxy", serverSide="assets.witch.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ConfigHandler.setup();
		
		witchHat = new ItemWitchHat(ConfigHandler.witchHatID).setUnlocalizedName("witch.hat");
		
		proxy.registerLang();
		
		MinecraftForge.EVENT_BUS.register(new assets.witch.common.core.EventHandler());
		NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());
		
	}

}

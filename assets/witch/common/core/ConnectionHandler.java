package assets.witch.common.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import assets.witch.common.WitchHats;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class ConnectionHandler implements IConnectionHandler {

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {

		EntityPlayer realPlayer = netHandler.getPlayer();
		
		File folder = new File(".", "romejanic");
		Side s = FMLCommonHandler.instance().getEffectiveSide();
		
		if(s == s.CLIENT) {
			
			folder = new File(Minecraft.getMinecraft().mcDataDir, "romejanic");
			
		}
		
		File theFile = new File(folder, "WitchHatsUpToDate.txt");
		
		checkForUpdates(theFile, realPlayer);
		
	}
	
	public void checkForUpdates(File targetFile, EntityPlayer player) {
		
		System.out.println("Checking for updates...");
		
		File theFile = targetFile;
		
		try {
			
			FileUtils.copyURLToFile(new URL(WitchHats.updateURL), theFile);
		
		} catch (MalformedURLException e) {
			
			System.err.println("The URL \"" + WitchHats.updateURL + "\" is incorrect!");
			
			theFile.delete();
			
			return;
			
		} catch (IOException e) {
			
			System.err.println("Could not download file: " + theFile);
			
			theFile.delete();
			
			return;
			
		}
		
		String contents = "y";
		
		try {
			
			FileUtils.readFileToString(theFile);
		
		} catch (IOException e) {

			System.err.println("Cannot read file: " + theFile);
			
			theFile.delete();
			
			return;

		}
		
		if(contents.equalsIgnoreCase("n")) {
			
			System.out.println("A new version is avaliable!");
			
			WitchHats.upToDate = false;
			
		}
		else {
			
			System.out.println("No new updates found!");
			
		}
		
		if(!WitchHats.upToDate) {
			
			player.addChatMessage("A new verison of Witch Hats is avaliable!\nGet it at: http://planetminecraft.com/member/romejanicdev");
			
		}
		
		theFile.delete();
		
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		
		return null;
	
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {

	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {

	}

	@Override
	public void connectionClosed(INetworkManager manager) {

	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {

	}

}

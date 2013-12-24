package assets.witch.common.core;

import java.util.Random;

import assets.witch.common.WitchHats;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EventHandler {

	@ForgeSubscribe
	public void entityDeathEvent(LivingDeathEvent event) {
		
		if(event.entity instanceof EntityWitch && !event.entity.worldObj.isRemote) {
			
			event.entity.dropItem(WitchHats.witchHat.itemID, 1);
			
		}
		
	}
	
}

package assets.witch.common.core;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy {

	public void registerLang() {
		
		LanguageRegistry reg = LanguageRegistry.instance();
		
		reg.addStringLocalization("item.witch.hat.name", ConfigHandler.witchHatName);
		
	}
	
}

package assets.witch.common.item;

import java.util.Calendar;
import java.util.Date;

import assets.witch.client.model.ModelWitchHat;
import assets.witch.common.core.ConfigHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

public class ItemWitchHat extends ItemArmor {

	public ItemWitchHat(int par1) {
		
		super(par1, EnumHelper.addArmorMaterial("witchHat", 1200, new int[] {
				
				0,
				0,
				0,
				0
				
		}, 20), 0, 0);
	
		setCreativeTab(CreativeTabs.tabMisc);
		
	}

	@Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
    {
        return new ModelWitchHat();
    }
	
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
    	if(Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER && ConfigHandler.useXmasHat) {
    		
    		return "witch:textures/entity/hat_xmas.png";
    		
    	}
    	
        return "textures/entity/witch.png";
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		
		this.itemIcon = ir.registerIcon("witch:witchHat");
		
	}
	
}

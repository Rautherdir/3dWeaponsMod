package Rautherdir.ThreeDWeaponStand.Auxiliary;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabTDWeapons extends CreativeTabs {
	public TabTDWeapons(int position, String tabID) {
		super(position, tabID);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return null; flag
		//return new ItemStack();
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return "3d Weapons";
	}
}

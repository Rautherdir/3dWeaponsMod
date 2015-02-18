package Rautherdir.ThreeDWeaponStand.Registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import Rautherdir.ThreeDWeaponStand.ThreeDWeaponStand;
import Reika.DragonAPI.Interfaces.IDRegistry;

public enum ExtraConfigIDs implements IDRegistry {
	PLASMATANK("Tank IDs", "Plasma tank Items", 30100, Item.class);
	
	private String name;
	private String category;
	private int defaultID;
	private Class type;
	
	public static final ExtraConfigIDs[] idList = ExtraConfigIDs.values();

	private ExtraConfigIDs(String cat, String n, int d, Class c) {
		name = n;
		category = cat;
		defaultID = d;
		type = c;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getDefaultID() {
		return defaultID;
	}

	public boolean isBlock() {
		return type == Block.class;
	}

	public boolean isItem() {
		return type == Item.class;
	}
	
	public int getValue() {
		return ThreeDWeaponStand.config.getOtherID(this.ordinal());
	}
	
	public int getShiftedValue() {
		return ThreeDWeaponStand.config.getOtherID(this.ordinal())+256;
	}
	
	@Override
	public String getConfigName() {
		return this.getName();
	}
}

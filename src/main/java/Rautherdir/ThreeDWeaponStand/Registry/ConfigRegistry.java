package Rautherdir.ThreeDWeaponStand.Registry;

import Rautherdir.ThreeDWeaponStand.ThreeDWeaponStand;
import Reika.DragonAPI.Interfaces.ConfigList;

public enum ConfigRegistry implements ConfigList {
	
	BASEDAMAGE("Multiplier for weapon damage", 1.0f);
	
	private String label;
	private boolean defaultState;
	private int defaultValue;
	private float defaultFloat;
	private Class type;
	private boolean enforcing = false;
	
	public static final ConfigRegistry[] optionList = values();
	
	private ConfigRegistry(String l, boolean d) {
		label = l;
		defaultState = d;
		type = boolean.class;
	}
	
	private ConfigRegistry(String l, boolean d, boolean tag) {
		this(l, d);
		enforcing = true;
	}
	
	private ConfigRegistry(String l, int d) {
		label = l;
		defaultValue = d;
		type = int.class;
	}
	
	private ConfigRegistry(String l, float d) {
		label = l;
		defaultFloat = d;
		type = float.class;
	}
	
	public boolean isBoolean() {
		return type == boolean.class;
	}
	
	public boolean isNumeric() {
		return type == int.class;
	}
	
	public boolean isDecimal() {
		return type == float.class;
	}
	
	public Class getPropertyType() {
		return type;
	}
	
	public String getLabel() {
		return label;
	}
	
	public boolean getState() {
		return (Boolean)ThreeDWeaponStand.config.getControl(this.ordinal());
	}
	
	public int getValue() {
		return (Integer)ThreeDWeaponStand.config.getControl(this.ordinal());
	}
	
	public float getFloat() {
		return (Float)ThreeDWeaponStand.config.getControl(this.ordinal());
	}
	
	@Override
	public boolean getDefaultState() {
		return defaultState;
	}
	
	@Override
	public int getDefaultValue() {
		return defaultValue;
	}

	@Override
	public float getDefaultFloat() {
		return defaultFloat;
	}
	
	@Override
	public boolean isEnforcingDefaults() {
		return enforcing;
	}

	@Override
	public boolean shouldLoad() {
		return true;
	}
}

package Rautherdir.ThreeDWeaponStand;

import java.util.ArrayList;

import Rautherdir.ThreeDWeaponStand.Registry.WeaponsAchievements;
import Reika.DragonAPI.Auxiliary.EnumDifficulty;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.IO.ControlledConfig;
import Reika.DragonAPI.Interfaces.ConfigList;
import Reika.DragonAPI.Interfaces.IDRegistry;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;

public class WeaponsConfig extends ControlledConfig {
	public WeaponsConfig(DragonAPIMod mod, ConfigList[] option, IDRegistry[] blocks, IDRegistry[] items, IDRegistry[] id, int cfg) {
		super(mod, option, blocks, items, id, cfg);
	}
	
	private static final ArrayList<String> entries = ReikaJavaLibrary.getEnumEntriesWithoutInitializing(WeaponsAchievements.class);
	public int[] achievementIDs = new int[entries.size()];
	
	public static final boolean debugmode = true;
	
	public static final EnumDifficulty EASIEST = EnumDifficulty.EASY;
	public static final EnumDifficulty HARDEST = EnumDifficulty.HARD;
	
	
	@Override
	protected void loadAdditionalData() {
		for (int i = 0; i < entries.size(); i++) {
			String name = entries.get(i);
			achievementIDs[i] = config.get("Achievement IDs", name, 26000+i).getInt();
		}
	}
	
	@Override
	protected void onInit() {
		
	}
}

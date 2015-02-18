package Rautherdir.ThreeDWeaponStand.Registry;

import Rautherdir.ThreeDWeaponStand.ThreeDWeaponStand;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public enum WeaponsAchievements {
	MAKEMAKER(		0, 0);
	
	public static final WeaponsAchievements[] list = values();
	
	public final WeaponsAchievements dependency;
	public final int xPosition;
	public final int yPosition;
	public final boolean isSpecial;
	private final ItemStack iconItem;
	
	private WeaponsAchievements(int x, int y, Item icon, WeaponsAchievements preReq, boolean special) {
		this(x, y, new ItemStack(icon), preReq, special);
	}
	
	private WeaponsAchievements(int x, int y, Block icon, WeaponsAchievements preReq, boolean special) {
		this(x, y, new ItemStack(icon), preReq, special);
	}
	
	private WeaponsAchievements(int x, int y, ItemRegistry icon, WeaponsAchievements preReq, boolean special) {
		this(x, y, icon.getStackOf(), preReq, special);
	}
	
	private WeaponsAchievements(int x, int y, MachineRegistry icon, WeaponsAchievements preReq, boolean special) {
		this(x, y, icon.getCraftedProduct(), preReq, special);
	}
	
	private WeaponsAchievements(int x, int y, ItemStack icon, WeaponsAchievements preReq, boolean special) {
		xPosition = x;
		yPosition = y;
		dependency = preReq;
		iconItem = icon;
		isSpecial = special;
	}
	
	public Achievement get() {
		return ThreeDWeaponStand.achievements[this.ordinal()];
	}
	
	public void triggerAchievement(EntityPlayer ep) {
		if (!ConfigRegistry.ACHIEVEMENTS.getState())
			return;
		if (ep == null) {
			ThreeDWeaponStand.logger.debug("Something bad happened when giving the achievement \""+this+"\"; namely, there was no one to give it to.");
		}
		else {
			ep.triggerAchievement(this.get());
		}
	}
	
	public boolean hasDependency() {
		return dependency != null;
	}
	
	public static void registerAchievements() {
		String li;
		for (int i = 0; i < list.length; i++) {
			WeaponsAchievements a = list[i];
			int id = ThreeDWeaponStand.config.achievementIDs[i];
			Achievement dep = a.hasDependency() ? a.dependency.get() : null;
			Achievement ach = new Achievement(id, a.name().toLowerCase(), a.xPosition, a.yPosition, a.iconItem, dep);
			id = ach.statId;
			if (a.isSpecial)
				ach.setSpecial();
			WeaponsAchievements.achievements[i] = ach;
			ach.registerAchievement();
			li = li + id;
		}
		ThreeDWeaponStand.logger.log(li);
		ThreeDWeaponStand.logger.log("That was the list of achievement ids. I will eventually add a config setting for more information.");
		AchievementPage.registerAchievementPage(new TDWSAchievementPage("3d Weapons", ThreeDWeaponStand.achievements));
	}
}

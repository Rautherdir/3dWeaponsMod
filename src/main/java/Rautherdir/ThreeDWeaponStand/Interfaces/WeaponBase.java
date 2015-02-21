package Rautherdir.ThreeDWeaponStand.Interfaces;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

public class WeaponBase {
	
	/*public double getDamagePercentageModifier();
	public double getRangePercentageModifier();
	public double getAccuracyPercentageModifier();
	public double getKnockbackPercentageModifier();
	public int upgradeSlots();
	public void addUpgrade(UpgradeBase upgrade);
	
	
	public String getDescription(int line);
	
	public IModelCustom getModel(String Type);*/
	protected String baseDescription;
	protected String ammoDescription;
	protected boolean isLoaded;
	protected boolean isHandheld;
	protected boolean isPlaceableOnRArm;
	protected double damagePerc;
	protected double accuracyPerc;
	protected double rangePerc;
	protected double knockbackPerc;
	protected int slots;
	protected AmmoType ammo;
	protected String[] description;
	protected List<IModelCustom> baseModels;
	protected List<ResourceLocation> textures;
	protected List<UpgradeBase> upgrades;
	protected List<AmmoType> acceptableAmmo;
	
	protected void updateDescription(List<UpgradeBase> upgradelist) {
		if(upgradelist.size() == 0) {
		} else {
			for(int i = upgradelist.size(); i != 0; i--) {
				upgrades.add(i, upgradelist.get(i));
			}
		}
	}
	
	protected void updateDescription() {
		description[0] = baseDescription;
		description[1] = ammoDescription;
		for(int i = upgrades.size(); i != 0; i--) {
			description[i + 2] = upgrades.get(i).getDescrption();
		}
		String r;
		int i = 0;
		do {
			r = getPartDescription(i);
			i++;
			if(r != null) {
				description[upgrades.size() + 3 + i] = r;
			}
		} while (r != null);
	}

	public double getDamagePercentageModifier() {
		return damagePerc;
	}

	public String getDescription(int line) {
		return description[line];
	}
	
	public List<ResourceLocation> getTextures() {
		return textures;
	}

	public List<IModelCustom> getModels() {
		return baseModels;
	}

	public double getRangePercentageModifier() {
		return rangePerc;
	}

	public double getAccuracyPercentageModifier() {
		return accuracyPerc;
	}

	public int upgradeSlots() {
		return slots;
	}

	public double getKnockbackPercentageModifier() {
		return knockbackPerc;
	}

	public void addUpgrade(UpgradeBase upgrade) {
		upgrades.add(upgrade);
		this.updateDescription();
		upgrade.applyUpgrade(this);
	}
	
	public void refreshStats() {
		
	}

	public String getPartDescription(int i) {
		return null;
	}
	
	public void renderAll() {
		
	}
}

package Rautherdir.ThreeDWeaponStand.WeaponType;

import java.util.List;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.PartBase;
import Rautherdir.ThreeDWeaponStand.Interfaces.UpgradeBase;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;

public class Pistol implements WeaponBase{
	private double damagePerc = 0.65;
	private double accuracyPerc = 0.65;
	private double rangePerc = 0.7;
	private double knockbackPerc = 0.2;
	private int slots = 2;
	private AmmoType ammo;
	private String description[];
	private IModelCustom baseModel;
	private List<UpgradeBase> upgrades;
	private PartBase handle;
	
	public Pistol(AmmoType amm, List<UpgradeBase> upgradelist) {
		baseModel = AdvancedModelLoader.loadModel(null);
		ammo = amm;
		updateDescription(upgradelist);
	}
	
	private void updateDescription(List<UpgradeBase> upgradelist) {
		description[0]  = "A low-kick gun designed for use with "+ ammo.getName() + ".";
		if(upgradelist.size() == 0) {
			description[1] = "This weapon has no upgrades installed.";
		} else {
			for(int i = upgradelist.size(); i != 0; i--) {
				description[i + 1] = upgradelist.get(i).getDescrption();
				upgradelist.get(i).applyUpgrade(this);
				upgrades.add(i, upgradelist.get(i));
			}
		}
	}
	
	private void updateDescription() {
		description[0]  = "A low-kick gun designed for use with "+ ammo.getName() + ".";
		for(int i = upgrades.size(); i != 0; i--) {
			description[i + 1] = upgrades.get(i).getDescrption();
		}
	}

	@Override
	public double getDamagePercentageModifier() {
		return damagePerc;
	}

	@Override
	public String getDescription(int line) {
		return description[line];
	}

	@Override
	public IModelCustom getModel(String Type) {
		return baseModel;
	}

	@Override
	public double getRangePercentageModifier() {
		return rangePerc;
	}

	@Override
	public double getAccuracyPercentageModifier() {
		return accuracyPerc;
	}

	@Override
	public int upgradeSlots() {
		return slots;
	}

	@Override
	public double getKnockbackPercentageModifier() {
		return knockbackPerc;
	}

	@Override
	public void addUpgrade(UpgradeBase upgrade) {
		upgrades.add(upgrade);
		this.updateDescription();
		upgrade.applyUpgrade(this);
	}

}

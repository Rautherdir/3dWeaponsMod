package Rautherdir.ThreeDWeaponStand.WeaponType;

import java.util.List;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.PartBase;
import Rautherdir.ThreeDWeaponStand.Interfaces.UpgradeBase;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.Barrel;
import Rautherdir.ThreeDWeaponStand.PartTypes.FiringMech;
import Rautherdir.ThreeDWeaponStand.PartTypes.Handle;

public class Pistol extends WeaponBase{
	private double baseDamagePerc = 0.65;
	private double baseAccuracyPerc = 0.65;
	private double baseRangePerc = 0.7;
	private double baseKnockbackPerc = 0.2;
	protected Handle handle;
	protected Barrel barrel;
	protected FiringMech trigger;
	
	public Pistol(Handle h, Barrel b, FiringMech T, List<UpgradeBase> upgradelist) {
		isHandheld = true;
		isPlaceableOnRArm = h.isPlaceableOnRArm();
		handle = h;
		barrel = b;
		trigger = T;
		updateDescription(upgradelist);
		refreshStats();
	}
	
	@Override
	public void refreshStats() {
		acceptableAmmoCheck(handle, barrel, trigger);
		
		if(ammo == null) isLoaded = false;
		else isLoaded = true;
		
		damagePerc = baseDamagePerc * trigger.getDamageMod();
		accuracyPerc = baseAccuracyPerc * handle.getAccuracyMod() * barrel.getAccuracyMod();
		rangePerc = baseRangePerc * barrel.getRangeMod();
		knockbackPerc = baseKnockbackPerc * handle.getKnockbackMod();
		
		baseModels.add(handle.getModel());
		baseModels.add(barrel.getModel());
		baseModels.add(trigger.getModel());
		
		textures.add(handle.getTexture());
		textures.add(barrel.getTexture());
		textures.add(trigger.getTexture());
		
		baseDescription = "A low-kick gun with a"+handle.getName()+", a"+barrel.getName()+", and a"+trigger.getName()+".";
		if(isLoaded) ammoDescription = "This pistol is loaded with "+ammo.getAmountString();
		else ammoDescription = "This pistol is not loaded.";
		updateDescription();
	}
	
	private List<AmmoType> acceptableAmmoCheck(Handle h, Barrel b, FiringMech t) {
		List<AmmoType> o;
		o = h.getSupportedAmmo();
		List<AmmoType> temp = h.getSupportedAmmo();
		temp.clear();
		for(int i = o.size(); i != 0; i--) {
			if(b.getSupportedAmmo().contains(o.get(i))) {
				temp.add(o.get(i));
			}
		}
		o = temp;
		temp.clear();
		for(int i = o.size(); i != 0; i--) {
			if(t.getSupportedAmmo().contains(o.get(i))) {
				temp.add(o.get(i));
			}
		}
		return o;
	}
	
	@Override
	public String getPartDescription(int i) {
		if(i == 0) return handle.getDescription();
		else if(i == 1) return barrel.getDescription();
		else if(i == 2) return trigger.getDescription();
		else return null;
	}
}

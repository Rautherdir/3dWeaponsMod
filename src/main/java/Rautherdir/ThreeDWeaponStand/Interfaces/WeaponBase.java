package Rautherdir.ThreeDWeaponStand.Interfaces;

import net.minecraftforge.client.model.IModelCustom;

public interface WeaponBase {
	
	public double getDamagePercentageModifier();
	public double getRangePercentageModifier();
	public double getAccuracyPercentageModifier();
	public double getKnockbackPercentageModifier();
	public int upgradeSlots();
	public void addUpgrade(UpgradeBase upgrade);
	
	
	public String getDescription(int line);
	
	public IModelCustom getModel(String Type);
}

package Rautherdir.ThreeDWeaponStand.Interfaces;

public interface UpgradeBase {
	public String getDescrption();
	public void applyUpgrade(WeaponBase weapon);
	public boolean removable();
	public boolean isRendered();
}

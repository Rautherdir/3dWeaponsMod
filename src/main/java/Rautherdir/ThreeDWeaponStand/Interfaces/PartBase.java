package Rautherdir.ThreeDWeaponStand.Interfaces;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

public interface PartBase {
	public String getDescription();
	public List<AmmoType> getSupportedAmmo();
	public IModelCustom getModel();
	public double getWear();
	public ResourceLocation getTexture();
	public String getWarning();
	//Note: this is right after a, without a space.
	public String getName();
	public void onShoot(WeaponBase weapon);
}

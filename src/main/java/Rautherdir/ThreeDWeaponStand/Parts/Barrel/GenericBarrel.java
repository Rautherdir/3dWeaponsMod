package Rautherdir.ThreeDWeaponStand.Parts.Barrel;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.Barrel;

public class GenericBarrel implements Barrel {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Vector3f firingMechConnectorAngle;
	Vector3f firingMechConnectorOrigin;
	Vector3f underBarrelConectorAngle;
	Vector3f underBarrelConectorOrigin;
	Vector3f frontConnectorAngle;
	Vector3f frontConnectorOrigin;
	Vector3f overBarrelConnectorAngle;
	Vector3f overBarrelConnectorOrigin;
	
	@Override
	public String getDescription() {
		if (wear > 250) return " new generic barrel";
		else if(wear > 120) return " generic barrel";
		else if(wear > 10) return "n used generic barrel";
		else return " worn-out generic barrel";
	}

	@Override
	public List<AmmoType> getSupportedAmmo() {
		return supportedAmmo;
	}

	@Override
	public IModelCustom getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWear() {
		return wear;
	}

	@Override
	public ResourceLocation getTexture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWarning() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "Generic Barrel";
	}

	@Override
	public void onShoot(WeaponBase weapon) {
		wear -= weapon.getDamagePercentageModifier() * 2.0;
	}

	@Override
	public double getAccuracyMod() {
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

	@Override
	public double getRangeMod() {
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

}

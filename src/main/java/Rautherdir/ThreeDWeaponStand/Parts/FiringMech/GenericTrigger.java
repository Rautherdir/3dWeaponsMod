package Rautherdir.ThreeDWeaponStand.Parts.FiringMech;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.FiringMech;

public class GenericTrigger implements FiringMech {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Vector3f barrelConnectorAngle;
	Vector3f barrelConnectorOrigin;
	Vector3f handleConectorAngle;
	Vector3f handleConectorOrigin;
	
	@Override
	public String getDescription() {
		if (wear > 250) return " new generic trigger";
		else if(wear > 120) return " generic trigger";
		else if(wear > 10) return "n used generic trigger";
		else return " worn-out generic trigger";
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
		// TODO Auto-generated method stub
		return "Generic Trigger";
	}

	@Override
	public void onShoot(WeaponBase weapon) {
		// TODO Auto-generated method stub
		wear -= weapon.getDamagePercentageModifier() * 2.0;
	}

	@Override
	public double getDamageMod() {
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

	@Override
	public double getBackfirePerc() {
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

}

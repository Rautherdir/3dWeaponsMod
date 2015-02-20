package Rautherdir.ThreeDWeaponStand.Parts.Handle;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.util.vector.Vector3f;

import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.Handle;

public class GenericHandle implements Handle {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Vector3f connectorAngle;
	Vector3f connectorOrigin;
	
	public GenericHandle() {
		
	}
	
	@Override
	public String getDescription() {
		if (wear > 250) return " new generic handle";
		else if(wear > 120) return " generic handle";
		else if(wear > 10) return "n used generic handle";
		else return " worn-out generic handle";
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
		return "Generic Handle";
	}

	@Override
	public double getKnockbackMod() {
		return 1.0;
	}

	@Override
	public double getAccuracyMod() {
		return 1.0;
	}

	@Override
	public boolean isPlaceableOnRArm() {
		return true;
	}

	@Override
	public void setConnectPoint(Vector3f angle, Vector3f originTransform) {
		connectorAngle = angle;
		connectorOrigin = originTransform;
	}

	@Override
	public Vector3f getConnectPoint() {
		return connectorOrigin;
	}

	@Override
	public Vector3f getConnectAngle() {
		return connectorAngle;
	}

	@Override
	public void onShoot(WeaponBase weapon) {
		wear -= weapon.getKnockbackPercentageModifier() * 1.0;
	}

}

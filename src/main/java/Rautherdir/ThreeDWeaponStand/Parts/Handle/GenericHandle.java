package Rautherdir.ThreeDWeaponStand.Parts.Handle;

import java.util.Collection;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.util.vector.Vector3f;

import Rautherdir.ThreeDWeaponStand.Connection;
import Rautherdir.ThreeDWeaponStand.Connection.ConnectionType;
import Rautherdir.ThreeDWeaponStand.AmmoTypes.Bullet;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.Handle;

public class GenericHandle implements Handle {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Connection connection;
	
	public GenericHandle() {
		supportedAmmo.add(new Bullet());
		connection = new Connection(new Vector3f(0.4f, 1.0f, 0.1f), new Vector3f(0.0f, 1.0f, 0.0f), ConnectionType.generic);
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
		return AdvancedModelLoader.loadModel("/assets/rautherdir/models/genericHandle.obj");
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
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

	@Override
	public double getAccuracyMod() {
		if (wear > 250) return 1.1;
		else if(wear > 120) return 1.0;
		else if(wear > 10) return 0.8;
		else return 0.5;
	}

	@Override
	public boolean isPlaceableOnRArm() {
		return true;
	}

	@Override
	public void setConnectPoint(Vector3f angle, Vector3f originTransform) {
		connection = new Connection(originTransform, angle, ConnectionType.generic);
	}

	@Override
	public Vector3f getConnectPoint() {
		return connection.getOrigin();
	}

	@Override
	public Vector3f getConnectAngle() {
		return connection.getAngle();
	}

	@Override
	public void onShoot(WeaponBase weapon) {
		wear -= weapon.getKnockbackPercentageModifier() * 1.0;
	}

}

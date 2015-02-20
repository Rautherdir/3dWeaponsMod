package Rautherdir.ThreeDWeaponStand.PartTypes;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.PartBase;

public interface Handle extends PartBase{
	public double getKnockbackMod();
	public double getAccuracyMod();
	public boolean isPlaceableOnRArm();
	public void setConnectPoint(Vector3f angle, Vector3f originTransform);
	public Vector3f getConnectPoint();
	public Vector3f getConnectAngle();
}

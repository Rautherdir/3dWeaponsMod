package Rautherdir.ThreeDWeaponStand.Parts.FiringMech;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import Rautherdir.ThreeDWeaponStand.Connection;
import Rautherdir.ThreeDWeaponStand.Connection.ConnectionType;
import Rautherdir.ThreeDWeaponStand.AmmoTypes.Bullet;
import Rautherdir.ThreeDWeaponStand.Interfaces.AmmoType;
import Rautherdir.ThreeDWeaponStand.Interfaces.WeaponBase;
import Rautherdir.ThreeDWeaponStand.PartTypes.FiringMech;

public class GenericTrigger implements FiringMech {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Connection barrelConnector;
	Connection handleConnector;
	
	public GenericTrigger() {
		supportedAmmo.add(new Bullet());
		barrelConnector = new Connection(new Vector3f(0.5f, 0.15f, 0.15f), new Vector3f(1.0f, 0.0f, 0.0f), ConnectionType.generic);
		handleConnector = new Connection(new Vector3f(0.1f, 0.0f, 0.15f), new Vector3f(0.0f, -1.0f, 0.0f), ConnectionType.generic);
	}
	
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
		return AdvancedModelLoader.loadModel("/assets/rautherdir/models/genericTrigger.bcs_git_wont_read_obj");
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

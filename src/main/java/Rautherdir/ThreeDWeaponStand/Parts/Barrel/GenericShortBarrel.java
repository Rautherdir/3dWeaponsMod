package Rautherdir.ThreeDWeaponStand.Parts.Barrel;

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
import Rautherdir.ThreeDWeaponStand.PartTypes.Barrel;

public class GenericShortBarrel implements Barrel {

	List<AmmoType> supportedAmmo;
	double wear = 256;
	Connection firingMech;
	Connection underBarrel;
	Connection front;
	Connection overBarrel;
	
	public GenericShortBarrel() {
		supportedAmmo.add(new Bullet());
		firingMech = new Connection(new Vector3f(0.0f, 0.2f, 0.2f), new Vector3f(-1.0f, 0.0f, 0.0f), ConnectionType.generic);
		front = new Connection(new Vector3f(1.6f, 0.2f, 0.2f), new Vector3f(1.0f, 0.0f, 0.0f), ConnectionType.generic);
		overBarrel = new Connection(new Vector3f(0.8f, 0.4f, 0.2f), new Vector3f(0.0f, 1.0f, 0.0f), ConnectionType.generic);
		underBarrel = new Connection(new Vector3f(0.8f, 0.0f, 0.2f), new Vector3f(0.0f, -1.0f, 0.0f), ConnectionType.generic);
	}
	
	@Override
	public String getDescription() {
		if (wear > 250) return " new generic short barrel";
		else if(wear > 120) return " generic short barrel";
		else if(wear > 10) return "n used generic short barrel";
		else return " worn-out generic short barrel";
	}

	@Override
	public List<AmmoType> getSupportedAmmo() {
		return supportedAmmo;
	}

	@Override
	public IModelCustom getModel() {
		return AdvancedModelLoader.loadModel("/assets/rautherdir/models/genericShortBarrel.since_git_wont_read_obj");
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
		return "Generic Short Barrel";
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
		if (wear > 250) return 0.8;
		else if(wear > 120) return 0.75;
		else if(wear > 10) return 0.5;
		else return 0.4;
	}

}

package Rautherdir.ThreeDWeaponStand.PartTypes;

import Rautherdir.ThreeDWeaponStand.Interfaces.PartBase;

public interface FluidTank extends PartBase, net.minecraftforge.fluids.IFluidTank {
	public double getRateOfTransfer();
	public double getAccuracyMod();
}

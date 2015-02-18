package Rautherdir.ThreeDWeaponStand.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import Reika.DragonAPI.Base.BlockTEBase;

public class BlockRoboticArm extends BlockTEBase {
	public BlockRoboticArm(int id, Material mat) {
		super(id, mat);
		// TODO Auto-generated constructor stub
	}

	public final boolean isInWorld() {
		return worldObj != null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack is)		//Directional code
	{
		int base = 0;
		int heldmeta = par5EntityLiving.getHeldItem().getItemDamage();
		if (heldmeta == 6)
			base = 6;
		if (MathHelper.abs(par5EntityLiving.rotationPitch) < 60) {
			int i = MathHelper.floor_double((par5EntityLiving.rotationYaw * 4F) / 360F + 0.5D);
			while (i > 3)
				i -= 4;
			while (i < 0)
				i += 4;
			switch (i) {
			case 0:
				world.setBlockMetadataWithNotify(x, y, z, base+0, 3);
				break;
			case 1:
				world.setBlockMetadataWithNotify(x, y, z, base+3, 3);
				break;
			case 2:
				world.setBlockMetadataWithNotify(x, y, z, base+2, 3);
				break;
			case 3:
				world.setBlockMetadataWithNotify(x, y, z, base+1, 3);
				break;
			}
		}
		else { //Looking up/down
			if (base == 6) { //cross
				world.setBlockMetadataWithNotify(x, y, z, base+0, 3);
				return;
			}
			if (par5EntityLiving.rotationPitch > 0)
				world.setBlockMetadataWithNotify(x, y, z, 4, 3); //set to up
			else
				world.setBlockMetadataWithNotify(x, y, z, 5, 3); //set to down
		}
	}

	@Override
	public boolean hasTileEntity(int meta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}

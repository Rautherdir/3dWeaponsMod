package Rautherdir.ThreeDWeaponStand;

import java.net.URL;
import java.util.Random;

import Rautherdir.ThreeDWeaponStand.Auxiliary.TabTDWeapons;
import Rautherdir.ThreeDWeaponStand.Registry.BlockRegistry;
import Rautherdir.ThreeDWeaponStand.Registry.ConfigRegistry;
import Rautherdir.ThreeDWeaponStand.Registry.ExtraConfigIDs;
import Rautherdir.ThreeDWeaponStand.Registry.ItemRegistry;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.CustomStringDamageSource;
import Reika.DragonAPI.Instantiable.IO.ModLogger;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.stats.Achievement;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "ThreeDWeaponsMod", name = "3d weapons mod", version = "Indev", dependencies = "required-after:DragonAPI")
public class ThreeDWeaponStand extends DragonAPIMod {
	public static final CreativeTabs tabWeapons = new TabTDWeapons(CreativeTabs.getNextID(), "3d Weapons");
	
	public static final CustomStringDamageSource plasma = new Reika.DragonAPI.Instantiable.CustomStringDamageSource("was incinerated by plasma");
	
	static final Random rand = new Random();
	
	public static final Block[] machineBlocks = new Block[BlockRegistry.blockList.length];
	
	public static Achievement[] achievements;
	
	@Instance("ThreeDWeaponsMod")
	public static ThreeDWeaponStand instance = new ThreeDWeaponStand();
	
	public static final WeaponsConfig config = new WeaponsConfig(instance, ConfigRegistry.optionList, BlockRegistry.blockList, ItemRegistry.itemList, ExtraConfigIDs.idList, 0);
	
	public static ModLogger logger;
	
	@EventHandler
	public void preload(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void load(FMLInitializationEvent event) {
		
	}

	@Override
	public void postload(FMLPostInitializationEvent evt) {
		
	}
	
	@Override
	public String getDisplayName() {
		return "3d Weapons Mod";
	}
	
	@Override
	public String getModAuthorName() {
		return "Rautherdir";
	}
	
	@Override
	public String getWiki() {
		return "";
	}
	
	@Override
	public String getUpdateCheckURL() {
		return "";
	}

	@Override
	public URL getDocumentationSite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModLogger getModLogger() {
		return logger;
	}
}

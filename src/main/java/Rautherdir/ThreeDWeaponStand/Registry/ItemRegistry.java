package Rautherdir.ThreeDWeaponStand.Registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import Ithithdui_.ThreeDWeaponStand.ThreeDWeaponStand;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.DragonAPI.Interfaces.RegistryEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;

public enum ItemRegistry implements RegistryEnum {
	PLASMA(0, true,				"item.plasma");
	
	private int index;
	private boolean hasSubtypes;
	private String name;
	private Class itemClass;
	private int texturesheet;
	private ModList condition;
	
	private int maxindex;
	
	private ItemRegistry(int tex, boolean sub, String n, Class <?extends Item> iCl) {
		this(tex, sub, n, iCl, null);
	}
	
	private ItemRegistry(int tex, boolean sub, String n, Class <?extends Item> iCl, ModList api) {
		texturesheet = 1;
		if (tex < 0) {
			tex = -tex;
			texturesheet = 0;
		}
		if (tex > 255) {
			texturesheet = tex/256;
			tex -= texturesheet*256;
		}
		index = tex;
		hasSubtypes = sub;
		name = n;
		itemClass = iCl;
		condition = api;
	}
	
	private ItemRegistry(int lotex, int hitex, boolean sub, String n, Class <?extends Item> iCl) {
		if (lotex > hitex)
			throw new RegistrationException(ThreeDWeaponStand.instance, "Invalid item sprite registration for "+n+"! Backwards texture bounds?");
		texturesheet = 1;
		if (lotex < 0) {
			lotex = -lotex;
			hitex = -hitex;
			texturesheet = 0;
		}
		if (lotex > 255) {
			texturesheet = lotex/256;
			lotex -= texturesheet*256;
			hitex -= texturesheet*256;
		}
		index = lotex;
		maxindex = lotex;
		hasSubtypes = sub;
		name = n;
		itemClass = iCl;
	}
	
	public static final ItemRegistry[] itemList = values();
	
	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{int.class, int.class};
	}
	
	public Object[] getConstructorParams() {
		return new Object[]{ThreeDWeaponStand.config.getItemID(this.ordinal()), this.getTextureIndex()};
	}
	
	public int getTextureIndex() {
		return index;
	}
	
	public static boolean isRegistered(ItemStack is) {
		return isRegistered(is.itemID);
	}
	
	public static boolean isRegistered(int id) {
		for (int i = 0; i < itemList.length; i++) {
			if (itemList[i].getShiftedID() == id)
				return true;
		}
		return false;
	}
	
	public static ItemRegistry getEntryByID(int id) {
		for (int i = 0; i <itemList.length; i++) {
			if (itemList[i].getShiftedID() == id)
				return itemList[i];
		}
		return null;
	}
	
	public static ItemRegistry getEntry(ItemStack is) {
		if (is == null)
			return null;
		return getEntryByID(is.itemID);
	}
	
	public String getName(int dmg) {
		if (this.hasMultiValuedName())
			return this.getMultiValuedName(dmg);
		return name;
	}
	
	public String getBasicName() {
		String sg = name;
		if (name.startsWith("#"))
			sg = name.substring(1);
		return StatCollector.translateToLocal(sg);
	}
	
	public String getUnlocalizedName() {
		return ReikaStringParser.stripSpaces(name).toLowerCase();
	}
	
	public int getID() {
		return ThreeDWeaponStand.config.getItemID(this.ordinal());
	}
	
	public int getShiftedID() {
		return ThreeDWeaponStand.config.getItemID(this.ordinal())+256;
	}
	
	public Item getItemInstance() {
		return ThreeDWeaponStand.basicItems[this.ordinal()];
	}
	
	public boolean hasMultiValuedName() {
		return name.startsWith("#");
	}
	
	public boolean isCharged() {
		return false;
		//work on this.
	}
	
	public int getTextureSheet() {
		return texturesheet;
	}
	
	public ItemStack getCraftedProduct(int amt) {
		return new ItemStack(this.getShiftedID(), amt, 0);
	}

	public ItemStack getCraftedMetadataProduct(int amt, int meta) {
		return new ItemStack(this.getShiftedID(), amt, meta);
	}
	
	public ItemStack getStackOf() {
		return this.getCraftedProduct(1);
	}

	public ItemStack getStackOfMetadata(int meta) {
		return this.getCraftedMetadataProduct(1, meta);
	}
	
	@Override
	public Class getObjectClass() {
		return itemClass;
	}
	
	@Override
	public Class<? extends ItemBlock> getItemBlock() {
		return null;
	}
	
	@Override
	public boolean hasItemBlock() {
		return false;
	}

	@Override
	public String getConfigName() {
		return this.getBasicName();
	}

	@Override
	public int getDefaultID() {
		return 30000+this.ordinal();
	}

	@Override
	public boolean isBlock() {
		return false;
	}

	@Override
	public boolean isItem() {
		return true;
	}
	
	public void addRecipe(Object... params) {
		GameRegistry.addRecipe(this.getStackOf(), params);
		WorktableRecipes.getInstance().addRecipe(this.getStackOf(), params)
	}
	
	public void addSizedRecipe(int num, Object... params) {
		GameRegistry.addRecipe(this.getCraftedProduct(num), params);
		WorktableRecipes.addRecipe(this.getCraftedProduct(num), params);
	}
	
	public void addMetaRecipe(int meta, Object... params) {
		GameRegistry.addRecipe(this.getStackOfMetadata(meta), params);
		WorktableRecipes.addRecipe(this.getStackOfMetadata(meta), params);
	}
	
	public void addSizedMetaRecipe(int meta, int num, Object... params) {
		GameRegistry.addRecipe(this.getCraftedMetadataProduct(num, meta), params);
		WorktableRecipes.addRecipe(this.getCraftedMetadataProduct(num, meta), params);
	}
	
	public void addShapelessRecipe(Object... params) {
		GameRegistry.addShapelessRecipe(this.getStackOf(), params);
		WorktableRecipes.getInstance().addShapelessRecipe(this.getStackOf(), params);
	}
	
	public void addRecipe(IRecipe ir) {
		GameRegistry.addRecipe(ir);
		WorktableRecipes.addRecipe(ir);
	}
	
	@Override
	public boolean overwritingItem() {
		return false;
	}
}

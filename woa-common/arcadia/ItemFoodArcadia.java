package arcadia;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemFoodArcadia extends ItemFood{

	/** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;

    /** The amount this food item heals the player. */
    @SuppressWarnings("unused")
	private final int healAmount;
    @SuppressWarnings("unused")
	private final float saturationModifier;

    /** Whether wolves like this food (true for raw and cooked porkchop). */
    @SuppressWarnings("unused")
	private final boolean isWolfsFavoriteMeat;

    /**
     * If this field is true, the food can be consumed even if the player don't need to eat.
     */
    @SuppressWarnings("unused")
	private boolean alwaysEdible;

    /**
     * represents the potion effect that will occurr upon eating this food. Set by setPotionEffect
     */
    @SuppressWarnings("unused")
	private int potionId;

    /** set by setPotionEffect */
    @SuppressWarnings("unused")
	private int potionDuration;

    /** set by setPotionEffect */
    @SuppressWarnings("unused")
	private int potionAmplifier;

    /** probably of the set potion effect occurring */
    @SuppressWarnings("unused")
	private float potionEffectProbability;

	public ItemFoodArcadia(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		 
	        this.itemUseDuration = 32;
	        this.healAmount = par2;
	        this.isWolfsFavoriteMeat = par4;
	        this.saturationModifier = par3;
	        this.setCreativeTab(arcadia.tabArcadiaItems);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

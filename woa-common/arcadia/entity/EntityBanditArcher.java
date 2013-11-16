package arcadia.entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBanditArcher extends EntityMob implements IRangedAttackMob
{
	public EntityBanditArcher(World world)
	{
		super(world);
		this.setSize(0.6F, 1.75F);
		
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
				
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveIndoors(this));
        this.tasks.addTask(2, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(4, new EntityAIArrowAttack(this, 0.5D, 20, 60, 15.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
	}
	//EntityZombie //RenderSkeleton EntityPlayer EntitySkeleton EntityVillager
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.6D);
    }
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
	
	protected boolean isAIEnabled()
	{
		return true;
	}
	
	protected boolean canDespawn()
	{
		return true;
	}
	
	protected String getLivingSound()
	{
        return "mob.zombie.say";
    }
 
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }
    
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.skeleton.step", 0.15F, 1.0F);
    }
    
    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    protected int getDropItemId()
    {
        return Item.arrow.itemID;
    }
    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j;
        int k;
        j = this.rand.nextInt(3 + par2);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Item.arrow.itemID, 1);
        }

        j = this.rand.nextInt(3 + par2);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Item.leather.itemID, 1);
        }
    }

    protected void dropRareDrop(int par1)
    {
        this.entityDropItem(new ItemStack(Item.skull.itemID, 1, 1), 0.0F);
    }
    
    protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Item.bow));
    }
    
    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        this.addRandomArmor();
        this.enchantEquipment();
        return par1EntityLivingData;
    }
    
    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
        EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float)(14 - this.worldObj.difficultySetting * 4));
        int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
        int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
        entityarrow.setDamage((double)(par2 * 5.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting * 0.22F));

        if (i > 0)
        {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0)
        {
            entityarrow.setKnockbackStrength(j);
        }

        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0)
        {
            entityarrow.setFire(100);
        }

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
    }
}
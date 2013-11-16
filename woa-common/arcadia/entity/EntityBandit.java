package arcadia.entity;

import arcadia.items.ItemsArcadia;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBandit extends EntityMob
{
	public EntityBandit(World world)
	{
		super(world);
		this.setSize(0.6F, 1.75F);
		
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
				
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIMoveIndoors(this));
        this.tasks.addTask(2, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.6D, false));
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityVillager.class, 0.6D, true));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
	}
	//EntityZombie //RenderSkeleton EntityPlayer EntitySkeleton EntityVillager
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(0.1D);
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
    
    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    protected int getDropItemId()
    {
        return Item.leather.itemID;
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
            this.dropItem(Item.leather.itemID, 1);
        }

        j = this.rand.nextInt(3 + par2);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Item.goldNugget.itemID, 1);
        }
    }

    protected void dropRareDrop(int par1)
    {
        this.entityDropItem(new ItemStack(Item.skull.itemID, 1, 1), 0.0F);
    }
    
    protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsArcadia.swordSilver));
    }
    
    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        this.addRandomArmor();
        this.enchantEquipment();
        return par1EntityLivingData;
    }
}
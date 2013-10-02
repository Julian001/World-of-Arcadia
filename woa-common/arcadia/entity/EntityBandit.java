package arcadia.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class EntityBandit extends EntityAnimal
{
	
	public EntityBandit(World world)
	{
		super(world);
		
		this.setSize(1.0F, 1.75F);
		
		this.getNavigator().setAvoidsWater(false);
		
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	//EntityPig
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.6D);
        //this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(7D);
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
        this.worldObj.playSoundAtEntity(this, "mob.zombie.step", 0.15F, 1.0F);
    }
    
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
	// TODO Auto-generated method stub
	return null;
	}

}
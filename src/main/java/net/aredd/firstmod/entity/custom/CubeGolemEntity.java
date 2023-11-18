package net.aredd.firstmod.entity.custom;

import net.aredd.firstmod.entity.ai.CubeGolemAttackGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CubeGolemEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(CubeGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public CubeGolemEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        }
        else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        }
        else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new CubeGolemAttackGoal(this, 1D,true));
        this.goalSelector.add(2, new WanderAroundFarGoal(this,1D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(0, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<WardenEntity>(this, WardenEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<EndermanEntity>(this, EndermanEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<VillagerEntity>(this, VillagerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<PillagerEntity>(this, PillagerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<EvokerEntity>(this, EvokerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<VindicatorEntity>(this, VindicatorEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<CreeperEntity>(this, CreeperEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<ZombieEntity>(this, ZombieEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<SkeletonEntity>(this, SkeletonEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<SpiderEntity>(this, SpiderEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<PigEntity>(this, PigEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<CowEntity>(this, CowEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<ChickenEntity>(this, ChickenEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<RabbitEntity>(this, RabbitEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<WitherEntity>(this, WitherEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<EnderDragonEntity>(this, EnderDragonEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<WitherSkeletonEntity>(this, WitherSkeletonEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<PiglinEntity>(this, PiglinEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<PiglinBruteEntity>(this, PiglinBruteEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<ZombifiedPiglinEntity>(this, ZombifiedPiglinEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<BlazeEntity>(this, BlazeEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<GhastEntity>(this, GhastEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<RavagerEntity>(this, RavagerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<GuardianEntity>(this, GuardianEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<ElderGuardianEntity>(this, ElderGuardianEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<ShulkerEntity>(this, ShulkerEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<DrownedEntity>(this, DrownedEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<HuskEntity>(this, HuskEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<FishEntity>(this, FishEntity.class, true));
        this.targetSelector.add(0, new ActiveTargetGoal<FishEntity>(this, FishEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createCubeGolemAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 240)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR,0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,15)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,100)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,0.01f);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean canSpawn(WorldAccess world, SpawnReason spawnReason) {
        return super.canSpawn(world, spawnReason);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    public boolean tryAttack(Entity target) {
        return super.tryAttack(target);
    }

    @Override
    public boolean canSpawn(WorldView world) {
        return super.canSpawn(world);
    }
}

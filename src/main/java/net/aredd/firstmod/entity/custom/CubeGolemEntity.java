package net.aredd.firstmod.entity.custom;

import net.aredd.firstmod.entity.ai.CubeGolemAttackGoal;
import net.aredd.firstmod.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

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

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, WardenEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, WitherEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, EndermanEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PatrolEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PassiveEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, CreeperEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, SkeletonEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, SpiderEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, GolemEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, EnderDragonEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, WitherSkeletonEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, AbstractPiglinEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ZombifiedPiglinEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, BlazeEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, GhastEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, GuardianEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ElderGuardianEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ShulkerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, DrownedEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, HuskEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, WaterCreatureEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, StriderEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, SlimeEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, AllayEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, AllayEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ZoglinEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, EndermiteEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, SilverfishEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, VexEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createCubeGolemAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 240)
                .add(EntityAttributes.GENERIC_ARMOR,0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,35)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,0.01)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 222);
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

    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
        ItemEntity itemEntity = this.dropItem(ModItems.CUBE_SHARD);
        if (itemEntity != null) {
            itemEntity.setCovetedItem();
        }
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
}
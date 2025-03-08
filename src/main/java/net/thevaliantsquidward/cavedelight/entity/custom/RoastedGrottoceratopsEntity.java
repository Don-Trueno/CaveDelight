package net.thevaliantsquidward.cavedelight.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RoastedGrottoceratopsEntity extends Entity {

    public RoastedGrottoceratopsEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
    }

    @Override
    public void tick() {
        super.tick();


        if (!this.onGround()) {
            double gravity = 0.04;
            double maxFallSpeed = -0.5;

            Vec3 velocity = this.getDeltaMovement();
            double newYVelocity = Math.max(velocity.y - gravity, maxFallSpeed);

            this.setDeltaMovement(velocity.x, newYVelocity, velocity.z);
        }

        this.move(MoverType.SELF, this.getDeltaMovement());

        if (this.onGround()) {
            Vec3 velocity = this.getDeltaMovement();
            this.setDeltaMovement(velocity.multiply(0.9, 1, 0.9)); // Reduce X/Z speed slightly
        }
    }
}

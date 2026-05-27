package com.winexp.simulated_cc_compat.content.blocks;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import dev.ryanhcode.sable.Sable;
import dev.ryanhcode.sable.api.sublevel.ServerSubLevelContainer;
import dev.ryanhcode.sable.api.sublevel.SubLevelContainer;
import dev.ryanhcode.sable.companion.math.JOMLConversion;
import dev.ryanhcode.sable.mixinterface.clip_overwrite.LevelPoseProviderExtension;
import dev.ryanhcode.sable.sublevel.ServerSubLevel;
import dev.ryanhcode.sable.sublevel.SubLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaterniond;

import java.util.List;

public class PhysicsDataAccessorBlockEntity extends SmartBlockEntity {
    private Vec3 pos = this.getBlockPos().getCenter();
    private Vec3 velocity = Vec3.ZERO;
    private Vec3 angularVel = Vec3.ZERO;
    private Quaterniond prevOrientation = new Quaterniond();
    private Quaterniond orientation = new Quaterniond();

    public PhysicsDataAccessorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    }

    @Override
    public void tick() {
        super.tick();
        this.pos = Sable.HELPER.projectOutOfSubLevel(this.level, this.getBlockPos().getCenter());
        this.velocity = Sable.HELPER.getVelocity(this.level, this.getBlockPos().getCenter());
        SubLevel sublevel = Sable.HELPER.getContaining(this);
        if (sublevel != null) {
            this.prevOrientation = this.orientation;
            if (this.level instanceof LevelPoseProviderExtension provider) {
                this.orientation = new Quaterniond(provider.sable$getPose(sublevel).orientation());
            } else {
                this.orientation = new Quaterniond(sublevel.logicalPose().orientation());
            }
            if (!this.level.isClientSide) {
                ServerSubLevelContainer container = SubLevelContainer.getContainer((ServerLevel) this.level);
                this.angularVel = JOMLConversion.toMojang(container.physicsSystem().getPhysicsHandle((ServerSubLevel) sublevel).getAngularVelocity());
            }
        }
    }

    public Vec3 getPos() {
        return this.pos;
    }

    public Vec3 getVelocity() {
        return this.velocity;
    }

    public Vec3 getAngularVel() {
        return this.angularVel;
    }

    public Quaterniond getPrevOrientation() {
        return this.prevOrientation;
    }

    public Quaterniond getOrientation() {
        return this.orientation;
    }
}

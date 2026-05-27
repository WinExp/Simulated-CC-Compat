package com.winexp.simulated_cc_compat.content.peripherals;

import com.winexp.simulated_cc_compat.content.blocks.PhysicsDataAccessorBlockEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dev.simulated_team.simulated.compat.computercraft.peripherals.SimPeripheral;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaterniond;

import java.util.List;

public class PhysicsDataAccessorPeripheral extends SimPeripheral<PhysicsDataAccessorBlockEntity> {
    public PhysicsDataAccessorPeripheral(PhysicsDataAccessorBlockEntity blockEntity) {
        super(blockEntity);
    }

    @LuaFunction
    public final List<Double> getPosition() {
        Vec3 pos = this.blockEntity.getPos();
        return List.of(pos.x, pos.y, pos.z);
    }

    @LuaFunction
    public final List<Double> getVelocity() {
        Vec3 linearVel = this.blockEntity.getVelocity();
        return List.of(linearVel.x, linearVel.y, linearVel.z);
    }

    @LuaFunction
    public final List<Double> getAngularVelocity() {
        Vec3 angVel = this.blockEntity.getAngularVel();
        return List.of(angVel.x, angVel.y, angVel.z);
    }

    @LuaFunction
    public final List<Double> getOrientation() {
        Quaterniond orientation = this.blockEntity.getOrientation();
        return List.of(orientation.x, orientation.y, orientation.z, orientation.w);
    }

    @Override
    public String getType() {
        return "sccc:physics_data_accessor";
    }
}

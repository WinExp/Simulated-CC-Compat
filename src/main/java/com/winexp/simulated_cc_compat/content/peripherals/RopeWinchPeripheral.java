package com.winexp.simulated_cc_compat.content.peripherals;

import dan200.computercraft.api.lua.LuaFunction;
import dev.simulated_team.simulated.compat.computercraft.peripherals.SimPeripheral;
import dev.simulated_team.simulated.content.blocks.rope.rope_winch.RopeWinchBlockEntity;

public class RopeWinchPeripheral extends SimPeripheral<RopeWinchBlockEntity> {
    public RopeWinchPeripheral(RopeWinchBlockEntity blockEntity) {
        super(blockEntity);
    }

    @LuaFunction
    public final int getLength() {
        return this.blockEntity.getCurrentValue();
    }

    @LuaFunction
    public final int getMinLength() {
        return this.blockEntity.getMinValue();
    }

    @LuaFunction
    public final int getMaxLength() {
        return this.blockEntity.getMaxValue();
    }

    @LuaFunction
    public final double getMovementSpeed() {
        return this.blockEntity.getMovementSpeed();
    }

    @Override
    public String getType() {
        return "rope_winch";
    }
}

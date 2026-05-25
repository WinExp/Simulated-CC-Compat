package com.winexp.simulated_cc_compat.content.peripherals;

import com.winexp.simulated_cc_compat.mixin_interface.WheelMountAccessor;
import dan200.computercraft.api.lua.LuaFunction;
import dev.ryanhcode.offroad.content.blocks.wheel_mount.WheelMountBlockEntity;
import dev.simulated_team.simulated.compat.computercraft.peripherals.SimPeripheral;

public class WheelMountPeripheral extends SimPeripheral<WheelMountBlockEntity> {
    public WheelMountPeripheral(WheelMountBlockEntity blockEntity) {
        super(blockEntity);
    }

    @LuaFunction
    public final int getStrength() {
        return ((WheelMountAccessor) this.blockEntity).aero_extra$getStrength();
    }

    @LuaFunction
    public final void setStrength(int strength) {
        ((WheelMountAccessor) this.blockEntity).aero_extra$setStrength(strength);
    }

    @Override
    public String getType() {
        return "wheel_mount";
    }
}

package com.winexp.simulated_cc_compat.content.peripherals;

import com.winexp.simulated_cc_compat.mixin_interface.HotAirBurnerAccessor;
import dan200.computercraft.api.lua.LuaFunction;
import dev.eriksonn.aeronautics.content.blocks.hot_air.hot_air_burner.HotAirBurnerBlockEntity;
import dev.simulated_team.simulated.compat.computercraft.peripherals.SimPeripheral;

public class HotAirBurnerPeripheral extends SimPeripheral<HotAirBurnerBlockEntity> {
    public HotAirBurnerPeripheral(HotAirBurnerBlockEntity blockEntity) {
        super(blockEntity);
    }

    @LuaFunction
    public final int getHotAirAmount() {
        return ((HotAirBurnerAccessor) this.blockEntity).sccc$getHotAirAmount();
    }

    @LuaFunction
    public final void setHotAirAmount(int amount) {
        ((HotAirBurnerAccessor) this.blockEntity).sccc$setHotAirAmount(amount);
    }

    @Override
    public String getType() {
        return "hot_air_burner";
    }
}

package com.winexp.simulated_cc_compat.mixin;

import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import com.winexp.simulated_cc_compat.mixin_interface.HotAirBurnerAccessor;
import dev.eriksonn.aeronautics.content.blocks.hot_air.steam_vent.SteamVentBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SteamVentBlockEntity.class)
public class SteamVentBlockEntityMixin implements HotAirBurnerAccessor {
    @Shadow
    protected ScrollValueBehaviour steamAmountBehaviour;

    @Override
    public int sccc$getHotAirAmount() {
        return this.steamAmountBehaviour.getValue();
    }

    @Override
    public void sccc$setHotAirAmount(int amount) {
        this.steamAmountBehaviour.setValue(amount);
    }
}

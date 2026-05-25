package com.winexp.simulated_cc_compat.mixin;

import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import com.winexp.simulated_cc_compat.mixin_interface.HotAirBurnerAccessor;
import dev.eriksonn.aeronautics.content.blocks.hot_air.hot_air_burner.HotAirBurnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HotAirBurnerBlockEntity.class)
public class HotAirBurnerBlockEntityMixin implements HotAirBurnerAccessor {
    @Shadow
    protected ScrollValueBehaviour hotAirAmountBehaviour;

    @Override
    public int sccc$getHotAirAmount() {
        return this.hotAirAmountBehaviour.getValue();
    }

    @Override
    public void sccc$setHotAirAmount(int amount) {
        this.hotAirAmountBehaviour.setValue(amount);
    }
}

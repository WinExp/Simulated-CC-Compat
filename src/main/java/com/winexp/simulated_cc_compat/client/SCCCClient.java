package com.winexp.simulated_cc_compat.client;

import com.winexp.simulated_cc_compat.SCCCMod;
import com.winexp.simulated_cc_compat.client.content.renderer.SCCCPartialModels;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(SCCCMod.MOD_ID)
@OnlyIn(Dist.CLIENT)
public class SCCCClient {
    public SCCCClient(IEventBus modEventBus, ModContainer modContainer) {
        SCCCPartialModels.init();
    }
}

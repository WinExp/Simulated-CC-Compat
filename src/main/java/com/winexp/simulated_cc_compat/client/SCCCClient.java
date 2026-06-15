package com.winexp.simulated_cc_compat.client;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import com.winexp.simulated_cc_compat.SCCCMod;
import com.winexp.simulated_cc_compat.client.content.renderer.SCCCPartialModels;
import com.winexp.simulated_cc_compat.client.content.renderer.block.PhysicsDataAccessorItemRenderer;
import com.winexp.simulated_cc_compat.config.SCCCConfig;
import com.winexp.simulated_cc_compat.content.registry.SCCCBlocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@Mod(value = SCCCMod.MOD_ID, dist = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class SCCCClient {
    public SCCCClient(IEventBus modEventBus) {
        if (SCCCConfig.CONFIG.registryEnabled.isTrue()) {
            SCCCPartialModels.init();
            modEventBus.addListener(SCCCClient::registerClientExtensions);
        }
    }

    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(SimpleCustomRenderer.create(
                SCCCBlocks.PHYSICS_DATA_ACCESSOR.asItem(),
                new PhysicsDataAccessorItemRenderer()
        ), SCCCBlocks.PHYSICS_DATA_ACCESSOR.asItem());
    }
}

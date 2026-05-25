package com.winexp.simulated_cc_compat;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(SimulatedComputerCraftCompat.MOD_ID)
public class SimulatedComputerCraftCompat {
    public static final String MOD_ID = "simulated_cc_compat";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SimulatedComputerCraftCompat(IEventBus modEventBus, ModContainer modContainer) {

    }
}

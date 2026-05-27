package com.winexp.simulated_cc_compat.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SCCCConfig {
    public static final SCCCConfig CONFIG;
    public static final ModConfigSpec CONFIG_SPEC;

    static {
        Pair<SCCCConfig, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(SCCCConfig::new);
        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }

    public final ModConfigSpec.BooleanValue registryEnabled;

    private SCCCConfig(ModConfigSpec.Builder builder) {
        this.registryEnabled = builder.define("registry_enabled", true);
    }
}

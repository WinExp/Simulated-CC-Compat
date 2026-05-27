package com.winexp.simulated_cc_compat;

import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.winexp.simulated_cc_compat.config.SCCCConfig;
import com.winexp.simulated_cc_compat.content.registry.SCCCBlockEntityTypes;
import com.winexp.simulated_cc_compat.content.registry.SCCCBlocks;
import dev.simulated_team.simulated.Simulated;
import dev.simulated_team.simulated.registrate.SimulatedRegistrate;
import dev.simulated_team.simulated.util.SimColors;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(SCCCMod.MOD_ID)
public class SCCCMod {
    public static final String MOD_ID = "simulated_cc_compat";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final NonNullSupplier<SimulatedRegistrate> REGISTRATE =
            NonNullSupplier.lazy(() -> (SimulatedRegistrate) new SimulatedRegistrate(Simulated.path("simulated"), MOD_ID)
                    .defaultCreativeTab((ResourceKey<CreativeModeTab>) null));

    public SCCCMod(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.STARTUP, SCCCConfig.CONFIG_SPEC);
        setTooltips();
        getRegistrate().registerEventListeners(modEventBus);
        if (SCCCConfig.CONFIG.registryEnabled.isTrue()) {
            SCCCBlocks.register();
            SCCCBlockEntityTypes.register();
        }
    }

    public static void setTooltips() {
        getRegistrate().setTooltipModifierFactory(item -> {
            Rarity rarity = item.getDefaultInstance().getRarity();
            FontHelper.Palette color = FontHelper.Palette.STANDARD_CREATE;
            if (rarity == Rarity.EPIC)
                color = new FontHelper.Palette(TooltipHelper.styleFromColor(SimColors.EPIC_OURPLE), TooltipHelper.styleFromColor(rarity.color()));

            return new ItemDescription
                    .Modifier(item, color)
                    .andThen(TooltipModifier.mapNull(KineticStats.create(item)));
        });
    }

    public static SimulatedRegistrate getRegistrate() {
        return REGISTRATE.get();
    }

    public static ResourceLocation asResource(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}

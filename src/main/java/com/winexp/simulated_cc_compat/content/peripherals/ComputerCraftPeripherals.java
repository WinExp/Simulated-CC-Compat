package com.winexp.simulated_cc_compat.content.peripherals;

import com.winexp.simulated_cc_compat.config.SCCCConfig;
import com.winexp.simulated_cc_compat.content.registry.SCCCBlockEntityTypes;
import dev.eriksonn.aeronautics.index.AeroBlockEntityTypes;
import dev.ryanhcode.offroad.index.OffroadBlockEntityTypes;
import dev.simulated_team.simulated.index.SimBlockEntityTypes;
import dev.simulated_team.simulated.service.ServiceUtil;
import dev.simulated_team.simulated.service.SimModCompatibilityService;
import dev.simulated_team.simulated.service.compat.SimPeripheralService;

public class ComputerCraftPeripherals implements SimModCompatibilityService {
    @Override
    public void init() {
        SimPeripheralService service = ServiceUtil.load(SimPeripheralService.class);
        service.addPeripheral(SimBlockEntityTypes.ROPE_WINCH, RopeWinchPeripheral::new);
        service.addPeripheral(AeroBlockEntityTypes.HOT_AIR_BURNER, HotAirBurnerPeripheral::new);
        service.addPeripheral(AeroBlockEntityTypes.STEAM_VENT, SteamVentPeripheral::new);
        service.addPeripheral(OffroadBlockEntityTypes.WHEEL_MOUNT, WheelMountPeripheral::new);

        if (SCCCConfig.CONFIG.registryEnabled.isTrue()) {
            service.addPeripheral(SCCCBlockEntityTypes.PHYSICS_DATA_ACCESSOR, PhysicsDataAccessorPeripheral::new);
        }
    }

    @Override
    public String getModId() {
        return "computercraft";
    }
}

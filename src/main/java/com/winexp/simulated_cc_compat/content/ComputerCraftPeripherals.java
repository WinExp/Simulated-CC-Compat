package com.winexp.simulated_cc_compat.content;

import com.winexp.simulated_cc_compat.content.peripherals.HotAirBurnerPeripheral;
import com.winexp.simulated_cc_compat.content.peripherals.SteamVentPeripheral;
import com.winexp.simulated_cc_compat.content.peripherals.WheelMountPeripheral;
import dev.eriksonn.aeronautics.index.AeroBlockEntityTypes;
import dev.ryanhcode.offroad.index.OffroadBlockEntityTypes;
import dev.simulated_team.simulated.service.ServiceUtil;
import dev.simulated_team.simulated.service.SimModCompatibilityService;
import dev.simulated_team.simulated.service.compat.SimPeripheralService;

public class ComputerCraftPeripherals implements SimModCompatibilityService {
    @Override
    public void init() {
        SimPeripheralService service = ServiceUtil.load(SimPeripheralService.class);
        service.addPeripheral(AeroBlockEntityTypes.HOT_AIR_BURNER, HotAirBurnerPeripheral::new);
        service.addPeripheral(AeroBlockEntityTypes.STEAM_VENT, SteamVentPeripheral::new);
        service.addPeripheral(OffroadBlockEntityTypes.WHEEL_MOUNT, WheelMountPeripheral::new);
    }

    @Override
    public String getModId() {
        return "computercraft";
    }
}

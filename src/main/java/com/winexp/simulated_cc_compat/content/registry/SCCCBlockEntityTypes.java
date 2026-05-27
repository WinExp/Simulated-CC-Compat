package com.winexp.simulated_cc_compat.content.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.winexp.simulated_cc_compat.SCCCMod;
import com.winexp.simulated_cc_compat.client.content.renderer.block.PhysicsDataAccessorRenderer;
import com.winexp.simulated_cc_compat.content.blocks.PhysicsDataAccessorBlockEntity;
import dev.simulated_team.simulated.registrate.SimulatedRegistrate;

public class SCCCBlockEntityTypes {
    private static final SimulatedRegistrate REGISTRATE = SCCCMod.getRegistrate();

    public static final BlockEntityEntry<PhysicsDataAccessorBlockEntity> PHYSICS_DATA_ACCESSOR = REGISTRATE
            .blockEntity("physics_data_accessor", PhysicsDataAccessorBlockEntity::new)
            .renderer(() -> PhysicsDataAccessorRenderer::new)
            .validBlocks(SCCCBlocks.PHYSICS_DATA_ACCESSOR)
            .register();

    public static void register() {}
}

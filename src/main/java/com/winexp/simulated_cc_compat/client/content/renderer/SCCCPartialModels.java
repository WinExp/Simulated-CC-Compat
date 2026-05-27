package com.winexp.simulated_cc_compat.client.content.renderer;

import com.winexp.simulated_cc_compat.SCCCMod;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SCCCPartialModels {
    public static final PartialModel
            PHYSICS_DATA_ACCESSOR_INNER_CUBE = block("creative_physics_data_accessor/inner_cube"),
            PHYSICS_DATA_ACCESSOR_OUTER_CUBE = block("creative_physics_data_accessor/outer_cube");

    private static PartialModel block(String id) {
        return PartialModel.of(SCCCMod.asResource("block/" + id));
    }

    public static void init() {}
}

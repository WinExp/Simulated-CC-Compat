package com.winexp.simulated_cc_compat.content.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.winexp.simulated_cc_compat.SCCCMod;
import com.winexp.simulated_cc_compat.content.blocks.PhysicsDataAccessorBlock;
import dev.simulated_team.simulated.registrate.SimulatedRegistrate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;

public class SCCCBlocks {
    private static final SimulatedRegistrate REGISTRATE = SCCCMod.getRegistrate();

    public static final BlockEntry<PhysicsDataAccessorBlock> PHYSICS_DATA_ACCESSOR = builder("creative_physics_data_accessor", PhysicsDataAccessorBlock::new)
            .properties(p -> p
                    .sound(SoundType.GLASS)
                    .isRedstoneConductor(SCCCBlocks::never)
                    .isSuffocating(SCCCBlocks::never)
                    .noOcclusion())
            .simpleItem()
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), ((BlockModelBuilder) prov.cubeAll(ctx.getEntry())).renderType("translucent")))
            .register();

    private static <T extends Block> BlockBuilder<T, CreateRegistrate> builder(String id, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return REGISTRATE.block(id, factory)
                .setData(ProviderType.LANG, (ctx, prov) -> {})
                .setData(ProviderType.BLOCKSTATE, (ctx, prov) -> {});
    }

    private static boolean never(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    public static void register() {}
}

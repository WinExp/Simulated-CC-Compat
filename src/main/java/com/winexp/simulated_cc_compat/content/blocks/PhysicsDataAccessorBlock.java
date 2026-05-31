package com.winexp.simulated_cc_compat.content.blocks;

import com.mojang.serialization.MapCodec;
import com.simibubi.create.foundation.block.IBE;
import com.winexp.simulated_cc_compat.content.registry.SCCCBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhysicsDataAccessorBlock extends BaseEntityBlock implements IBE<PhysicsDataAccessorBlockEntity> {
    public static final MapCodec<PhysicsDataAccessorBlock> CODEC = simpleCodec(PhysicsDataAccessorBlock::new);

    public PhysicsDataAccessorBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        IBE.onRemove(state, level, pos, newState);
    }

    @Override
    protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    protected MapCodec<PhysicsDataAccessorBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public Class<PhysicsDataAccessorBlockEntity> getBlockEntityClass() {
        return PhysicsDataAccessorBlockEntity.class;
    }

    @Override
    public BlockEntityType<PhysicsDataAccessorBlockEntity> getBlockEntityType() {
        return SCCCBlockEntityTypes.PHYSICS_DATA_ACCESSOR.get();
    }
}

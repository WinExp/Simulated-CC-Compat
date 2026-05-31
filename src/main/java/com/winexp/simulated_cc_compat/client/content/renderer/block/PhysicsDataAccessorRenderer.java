package com.winexp.simulated_cc_compat.client.content.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import com.winexp.simulated_cc_compat.client.content.renderer.SCCCPartialModels;
import com.winexp.simulated_cc_compat.content.blocks.PhysicsDataAccessorBlockEntity;
import dev.ryanhcode.sable.companion.math.JOMLConversion;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;

public class PhysicsDataAccessorRenderer extends SmartBlockEntityRenderer<PhysicsDataAccessorBlockEntity> {
    public PhysicsDataAccessorRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(PhysicsDataAccessorBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        BlockState state = be.getBlockState();
        VertexConsumer vb = buffer.getBuffer(RenderType.solid());
        SuperByteBuffer innerCube = CachedBuffers.partial(SCCCPartialModels.PHYSICS_DATA_ACCESSOR_INNER_CUBE, state);
        float yRot = 2 * AnimationTickHolder.getRenderTime(be.getLevel());
        Quaternionf rotation = new Quaternionf(be.getPrevOrientation().slerp(be.getOrientation(), partialTicks, new Quaterniond()).invert())
                .rotateY(-yRot * Mth.DEG_TO_RAD);
        Vec3 baseTranslation = JOMLConversion.toMojang(rotation.transform(-1, -1, -1, new Vector3d()));
        innerCube
                .translate(baseTranslation.scale(1.5))
                .translate(0.5, 0.5, 0.5)
                .rotate(rotation)
                .scale(3)
                .light(LightTexture.FULL_BRIGHT)
                .renderInto(ms, vb);

        vb = buffer.getBuffer(RenderType.translucent());
        SuperByteBuffer outerCube = CachedBuffers.partial(SCCCPartialModels.PHYSICS_DATA_ACCESSOR_OUTER_CUBE, state);
        outerCube
                .translate(baseTranslation.scale(1.8))
                .translate(0.5, 0.5, 0.5)
                .rotate(rotation)
                .scale(3.6f)
                .light(LightTexture.FULL_BRIGHT)
                .renderInto(ms, vb);
    }
}

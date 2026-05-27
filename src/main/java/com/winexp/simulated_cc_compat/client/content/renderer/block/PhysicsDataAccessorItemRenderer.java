package com.winexp.simulated_cc_compat.client.content.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.winexp.simulated_cc_compat.client.content.renderer.SCCCPartialModels;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

@OnlyIn(Dist.CLIENT)
public class PhysicsDataAccessorItemRenderer extends CustomRenderedItemModelRenderer {
    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);
        float yRot;
        Quaternionf rotation;
        if (transformType == ItemDisplayContext.GUI) {
            rotation = new Quaternionf();
            yRot = 0;
        } else {
            rotation = ms.last().pose().getUnnormalizedRotation(new Quaternionf()).invert();
            yRot = 2 * AnimationTickHolder.getRenderTime();
        }
        rotation.rotateY(-yRot * Mth.DEG_TO_RAD);
        ms.pushPose();
        ms.mulPose(rotation);
        ms.scale(3, 3, 3);
        renderer.renderSolid(SCCCPartialModels.PHYSICS_DATA_ACCESSOR_INNER_CUBE.get(), LightTexture.FULL_BRIGHT);
        ms.popPose();

        ms.pushPose();
        ms.mulPose(rotation);
        ms.scale(3.6f, 3.6f, 3.6f);
        renderer.render(SCCCPartialModels.PHYSICS_DATA_ACCESSOR_OUTER_CUBE.get(), LightTexture.FULL_BRIGHT);
        ms.popPose();
    }
}

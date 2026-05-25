package com.winexp.simulated_cc_compat.mixin;

import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import com.winexp.simulated_cc_compat.mixin_interface.WheelMountAccessor;
import dev.ryanhcode.offroad.content.blocks.wheel_mount.WheelMountBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Mixin(WheelMountBlockEntity.class)
public abstract class WheelMountBlockEntityMixin implements WheelMountAccessor {
    @Unique
    private Field sccc$strengthField;
    @Unique
    private Method sccc$getValueMethod;
    @Unique
    private Method sccc$setValueMethod;

    @Unique
    private void sccc$loadFieldsAndMethods() {
        if (this.sccc$strengthField != null) return;
        try {
            Class<?> outer = WheelMountBlockEntity.class;
            Field field = outer.getDeclaredField("strength");
            field.setAccessible(true);
            this.sccc$strengthField = field;

            Class<?> clazz = ScrollValueBehaviour.class;
            Method getValue = clazz.getDeclaredMethod("getValue");
            getValue.setAccessible(true);
            this.sccc$getValueMethod = getValue;

            Method setValue = clazz.getDeclaredMethod("setValue", int.class);
            setValue.setAccessible(true);
            this.sccc$setValueMethod = setValue;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public int sccc$getStrength() {
        this.sccc$loadFieldsAndMethods();
        try {
            return (int) this.sccc$getValueMethod.invoke(this.sccc$strengthField.get(this));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void sccc$setStrength(int strength) {
        this.sccc$loadFieldsAndMethods();
        try {
            this.sccc$setValueMethod.invoke(this.sccc$strengthField.get(this), strength);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}

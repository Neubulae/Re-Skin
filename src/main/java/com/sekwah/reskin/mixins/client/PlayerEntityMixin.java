package com.sekwah.reskin.mixins.client;

import com.sekwah.reskin.api.IReSkinPlayer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin extends LivingEntity implements IReSkinPlayer {

    private static final TrackedData<String> RESKIN_LOC;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "initDataTracker", at=@At("TAIL"))
    public void initDataTracker(CallbackInfo ci) {
        this.dataTracker.startTracking(RESKIN_LOC, null);
    }

    @Inject(method = "readCustomDataFromTag", at=@At("TAIL"))
    public void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        if(tag.contains("ReSkinLoc", 8)) {
            this.setSkin(tag.getString("ReSkinLoc"));
        }
    }

    @Inject(method = "writeCustomDataToTag", at=@At("TAIL"))
    public void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.putString("ReSkinLoc", this.getSkin());
    }

    @Override
    public void setSkin(String url) {
        this.getDataTracker().set(RESKIN_LOC, url);
    }

    @Override
    public String getSkin() {
        return this.getDataTracker().get(RESKIN_LOC);
    }

    static {
        RESKIN_LOC = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.STRING);
    }

    // Useless methods after this

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public Arm getMainArm() {
        return null;
    }
}

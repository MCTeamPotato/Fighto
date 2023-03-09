package com.teampotato.fighto.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.world.item.ItemStack;

public class EventUtil {
    public static void setUnbreakable(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.put("Unbreakable", IntTag.valueOf(1));
    }
}
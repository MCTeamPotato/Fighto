package com.teampotato.fighto.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class CompoundTagUtil {
    public static void setUnbreakable(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt("Unbreakable", 1);
        System.out.println(stack.getOrCreateTag().toString());
    }
}

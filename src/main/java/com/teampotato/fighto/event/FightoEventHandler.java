package com.teampotato.fighto.event;

import com.teampotato.fighto.Fighto;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.world.item.*;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber
public class FightoEventHandler {

    @SubscribeEvent
    public static void onItemIntoEnchantSlot(GuiScreenEvent.MouseClickedEvent.Pre event) {
        if (!(event.getGui() instanceof EnchantmentScreen)) return;
        ItemStack itemStack = Objects.requireNonNull(((EnchantmentScreen) event.getGui()).getSlotUnderMouse()).getItem();
        Item item = itemStack.getItem();
        if (!itemStack.isEmpty() && Fighto.UNBREAKABLE_WEAPONS_AND_ARMORS.get()
                && (
                        item instanceof ArmorItem ||
                        item instanceof SwordItem ||
                        item instanceof AxeItem ||
                        item instanceof HoeItem ||
                        item instanceof PickaxeItem ||
                        item instanceof ShovelItem
                )
        ) {
            itemStack.setTag(itemStack.getOrCreateTag().merge((CompoundTag) new CompoundTag().put("Unbreakable", IntTag.valueOf(1))));
        }
    }
}

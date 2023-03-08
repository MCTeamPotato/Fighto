package com.teampotato.fighto.event;

import com.teampotato.fighto.Fighto;
import com.teampotato.fighto.util.CompoundTagUtil;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FightoEventHandler {
    @SubscribeEvent
    public static void onItemIntoEnchantSlot(GuiScreenEvent.MouseClickedEvent.Pre event) {
        if (!(event.getGui() instanceof EnchantmentScreen)) return;
        Slot slot = ((EnchantmentScreen) event.getGui()).getSlotUnderMouse();
        if (slot == null) return;
        ItemStack itemStack = slot.getItem();
        if (itemStack.isEmpty()) return;
        Item item = itemStack.getItem();
        if (Fighto.UNBREAKABLE_WEAPONS_AND_ARMORS.get() && !itemStack.getOrCreateTag().contains("Unbreakable")
                && (
                        item instanceof ArmorItem ||
                        item instanceof SwordItem ||
                        item instanceof AxeItem ||
                        item instanceof HoeItem ||
                        item instanceof PickaxeItem ||
                        item instanceof ShovelItem ||
                        item instanceof BowItem ||
                        item instanceof CrossbowItem ||
                        item instanceof TridentItem
                )
        ) {
            CompoundTagUtil.setUnbreakable(itemStack);
        }
    }
}

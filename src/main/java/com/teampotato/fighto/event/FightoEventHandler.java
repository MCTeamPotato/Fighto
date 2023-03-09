package com.teampotato.fighto.event;

import com.teampotato.fighto.Fighto;
import com.teampotato.fighto.util.EventUtil;
import net.minecraft.world.item.*;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FightoEventHandler {
    @SubscribeEvent
    public static void onItemEnchant(EnchantmentLevelSetEvent event) {
        ItemStack itemStack = event.getItem();
        if (itemStack.isEmpty() || event.getWorld().isClientSide) return;
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
            EventUtil.setUnbreakable(itemStack);
        }
    }
}

package com.teampotato.fighto;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Fighto.MOD_ID)
public class Fighto {
    public static final String MOD_ID = "fighto";
    public Fighto() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG);
    }

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.BooleanValue UNBREAKABLE_WEAPONS_AND_ARMORS;

    static {
        ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();
        CONFIG_BUILDER.comment("Fighto!").push("general");
        UNBREAKABLE_WEAPONS_AND_ARMORS = CONFIG_BUILDER.define("Unbreakable weapons and armors", true);
        CONFIG_BUILDER.pop();
        COMMON_CONFIG = CONFIG_BUILDER.build();
    }
}

package io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.util;

import io.github.thebutterbrotman.just_enough_hammers.JustEnoughHammers;
import net.fabricmc.loader.api.FabricLoader;

import java.text.MessageFormat;

public class IMUtils {
    public static String awpPrefix(String modid) {
        return MessageFormat.format("jeh_{0}", modid);
    }

    public static final String LOADING = "Loading {1} for {0}...";
    public static final String LOADED = "Finished loading {1} for {0}!";
    public static final String PACK = "resourcepacks";
    public static final String REG = "registrations";
    //Inter Mod List
    //Dirtmonds
    public static final String DIRTMONDS_MODID = "dirtmonds";
    public static final String DIRTMONDS_MODNAME = "Dirtmonds";

    public static void logInterModRegStatus(String modName, String element, boolean isFinished) {
        JustEnoughHammers.LOGGER.info(MessageFormat.format((isFinished) ? LOADED : LOADING, modName, element));
    }

    public static final boolean DIRTMONDS_LOADED = FabricLoader.getInstance().isModLoaded(DIRTMONDS_MODID);
}

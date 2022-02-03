package io.github.thebutterbrotman.awesome_plates.common.compatibilities.util;

import io.github.thebutterbrotman.awesome_plates.AwesomePlates;
import net.fabricmc.loader.api.FabricLoader;

import java.text.MessageFormat;

public class IMUtils {
    public static String awpPrefix(String modid) {
        return MessageFormat.format("awp_{0}", modid);
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
        AwesomePlates.LOGGER.info(MessageFormat.format((isFinished) ? LOADED : LOADING, modName, element));
    }

    public static final boolean DIRTMONDS_LOADED = FabricLoader.getInstance().isModLoaded(DIRTMONDS_MODID);
}

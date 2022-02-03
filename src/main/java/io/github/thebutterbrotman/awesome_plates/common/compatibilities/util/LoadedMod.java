package io.github.thebutterbrotman.awesome_plates.common.compatibilities.util;

import net.fabricmc.loader.api.FabricLoader;

import java.text.MessageFormat;

public class LoadedMod {
    public static String awpPrefix(String modid) {
        return MessageFormat.format("awp_{0}", modid);
    }

    public static final String DIRTMONDS_MODID = "dirtmonds";

    public static final boolean DIRTMONDS_LOADED = FabricLoader.getInstance().isModLoaded(DIRTMONDS_MODID);
}

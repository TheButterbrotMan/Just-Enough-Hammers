package io.github.thebutterbrotman.awesomeplates.common.compatibilities.util;

import net.fabricmc.loader.api.FabricLoader;

public class LoadedMod {
    public static final String DIRTMONDS_MODID = "dirtmonds";

    public static final boolean DIRTMONDS_LOADED = FabricLoader.getInstance().isModLoaded(DIRTMONDS_MODID);
}

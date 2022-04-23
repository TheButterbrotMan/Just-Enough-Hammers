package io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.util;

import io.github.thebutterbrotman.just_enough_hammers.JustEnoughHammers;
import net.fabricmc.loader.api.FabricLoader;

import java.text.MessageFormat;

public class IMUtils {
    public static String jehPrefix(String modid) {
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

    //Therrassium
    public static final String THERRASSIUM_MODID = "therrassium";
    public static final String THERRASSIUM_MODNAME = "Therrassium";

    //Amethyst Equipment
    public static final String AMETHYSTEQUIPMENT_MODID = "amethystequipment";
    public static final String AMETHYSTEQUIPMENT_MODNAME = "Amethyst Equipment";

    //AdventureZ
    public static final String ADVENTUREZ_MODID = "adventurez";
    public static final String ADVENTUREZ_MODNAME = "Adventure Z";

    //Minecraft Comes Alive
    public static final String MCA_MODID = "mca";
    public static final String MCA_MODNAME = "Minecraft Comes Alive";

    public static void logInterModRegStatus(String modName, String element, boolean isFinished) {
        JustEnoughHammers.LOGGER.info(MessageFormat.format((isFinished) ? LOADED : LOADING, modName, element));
    }

    public static final boolean DIRTMONDS_LOADED = FabricLoader.getInstance().isModLoaded(DIRTMONDS_MODID);
    public static final boolean THERRASSIUM_LOADED = FabricLoader.getInstance().isModLoaded(THERRASSIUM_MODID);
    public static final boolean AMETHYSTEQUIPMENT_LOADED = FabricLoader.getInstance().isModLoaded(AMETHYSTEQUIPMENT_MODID);
    public static final boolean ADVENTUREZ_LOADED = FabricLoader.getInstance().isModLoaded(ADVENTUREZ_MODID);
    public static final boolean MCA_LOADED = FabricLoader.getInstance().isModLoaded(MCA_MODID);
}
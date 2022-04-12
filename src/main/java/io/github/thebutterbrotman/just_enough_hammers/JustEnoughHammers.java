package io.github.thebutterbrotman.just_enough_hammers;

import io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.item.InterModItems;
import io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.resourcePack.InterModResourcePacks;
import io.github.thebutterbrotman.just_enough_hammers.common.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JustEnoughHammers implements ModInitializer {

    public static final String MOD_ID = "just_enough_hammers";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        InterModItems.registerItems();
        InterModResourcePacks.registerPacks();
    }
}

package io.github.thebutterbrotman.awesome_plates;

import io.github.thebutterbrotman.awesome_plates.common.compatibilities.item.InterModItems;
import io.github.thebutterbrotman.awesome_plates.common.compatibilities.resourcePack.InterModResourcePacks;
import io.github.thebutterbrotman.awesome_plates.common.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AwesomePlates implements ModInitializer {

    public static final String MOD_ID = "awesome_plates";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        InterModItems.registerItems();
        InterModResourcePacks.registerPacks();
    }
}

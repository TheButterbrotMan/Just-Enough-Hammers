package io.github.thebutterbrotman.awesome_plates;

import io.github.thebutterbrotman.awesome_plates.common.compatibilities.item.InterModItems;
import io.github.thebutterbrotman.awesome_plates.common.compatibilities.resourcePack.InterModResourcePacks;
import io.github.thebutterbrotman.awesome_plates.common.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class AwesomePlates implements ModInitializer {

    public static String MOD_ID = "awesome_plates";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        InterModItems.registerItems();
        InterModResourcePacks.registerPacks();
    }
}

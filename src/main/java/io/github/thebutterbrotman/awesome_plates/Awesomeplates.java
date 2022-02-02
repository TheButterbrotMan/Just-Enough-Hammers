package io.github.thebutterbrotman.awesome_plates;

import io.github.thebutterbrotman.awesome_plates.common.compatibilities.item.InterModItems;
import io.github.thebutterbrotman.awesome_plates.common.compatibilities.util.LoadedMod;
import io.github.thebutterbrotman.awesome_plates.common.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class Awesomeplates implements ModInitializer {

    public static String MOD_ID = "awesome_plates";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        InterModItems.registerItems();
        if (LoadedMod.DIRTMONDS_LOADED) {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("dirtmonds"), FabricLoader.getInstance().getModContainer(Awesomeplates.MOD_ID).orElseThrow(), ResourcePackActivationType.DEFAULT_ENABLED);
        }
    }
}

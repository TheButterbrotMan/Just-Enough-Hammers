package io.github.thebutterbrotman.awesomeplates;

import io.github.thebutterbrotman.awesomeplates.common.compatibilities.item.InterModItems;
import io.github.thebutterbrotman.awesomeplates.common.compatibilities.util.LoadedMod;
import io.github.thebutterbrotman.awesomeplates.common.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class Awesomeplates implements ModInitializer {

    public static String MOD_ID = "awesomeplates";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        InterModItems.registerItems();
        if (LoadedMod.DIRTMONDS_LOADED) {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("dirtmonds"), FabricLoader.getInstance().getModContainer(Awesomeplates.MOD_ID).orElseThrow(), ResourcePackActivationType.DEFAULT_ENABLED);
        }
    }
}

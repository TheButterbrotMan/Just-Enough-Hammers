package io.github.thebutterbrotman.awesome_plates.common.compatibilities.resourcePack;

import io.github.thebutterbrotman.awesome_plates.AwesomePlates;
import io.github.thebutterbrotman.awesome_plates.common.compatibilities.util.LoadedMod;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import static io.github.thebutterbrotman.awesome_plates.common.compatibilities.util.LoadedMod.awpPrefix;

public class InterModResourcePacks {
    public static void registerPacks() {
        if (LoadedMod.DIRTMONDS_LOADED) lazyRegisterBuiltIn(LoadedMod.DIRTMONDS_MODID);

    }

    public static void lazyRegisterBuiltIn(String modid) {
        ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(awpPrefix(modid)), FabricLoader.getInstance().getModContainer(AwesomePlates.MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
    }
}

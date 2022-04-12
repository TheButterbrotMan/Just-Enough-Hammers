package io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.resourcePack;

import io.github.thebutterbrotman.just_enough_hammers.JustEnoughHammers;
import io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.util.IMUtils;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import static io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.util.IMUtils.awpPrefix;

public class InterModResourcePacks {
    public static void registerPacks() {
        if (IMUtils.DIRTMONDS_LOADED) lazyRegisterBuiltIn(IMUtils.DIRTMONDS_MODID, IMUtils.DIRTMONDS_MODNAME);
    }

    public static void lazyRegisterBuiltIn(String modid, String modName) {
        IMUtils.logInterModRegStatus(modName, IMUtils.PACK, false);
        ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(awpPrefix(modid)), FabricLoader.getInstance().getModContainer(JustEnoughHammers.MOD_ID).orElseThrow(), ResourcePackActivationType.ALWAYS_ENABLED);
        IMUtils.logInterModRegStatus(modName, IMUtils.PACK, true);
    }
}

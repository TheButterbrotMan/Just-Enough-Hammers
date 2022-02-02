package io.github.thebutterbrotman.awesomeplates.common.compatibilities.item;

import io.github.thebutterbrotman.awesomeplates.common.compatibilities.util.LoadedMod;
import io.github.thebutterbrotman.awesomeplates.common.item.impl.HammerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.thebutterbrotman.awesomeplates.common.compatibilities.util.LoadedMod.DIRTMONDS_MODID;

public class InterModItems {

    private static Item registerItem(String modNameSpace, String itemName, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(modNameSpace, itemName), item);
    }

    public static void registerItems() {
        //Dirtmonds
        if (LoadedMod.DIRTMONDS_LOADED) {
            registerItem(DIRTMONDS_MODID, "dirtmond_plate"
                    , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
            registerItem(DIRTMONDS_MODID, "dirtmond_hammer"
                    , new HammerItem(1051));
        }
    }

}


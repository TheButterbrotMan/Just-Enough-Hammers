package io.github.thebutterbrotman.awesomeplates.common.compatibilities.item;

import io.github.thebutterbrotman.awesomeplates.Awesomeplates;
import io.github.thebutterbrotman.awesomeplates.common.compatibilities.util.LoadedMod;
import io.github.thebutterbrotman.awesomeplates.common.item.impl.HammerItem;
import io.github.thebutterbrotman.awesomeplates.common.item.impl.PlateItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;



public class InterModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Awesomeplates.MOD_ID, name), item);

    }

    public static void registerItems() {

        //Dirtmonds
        if (LoadedMod.DIRTMONDS_LOADED) {
            Item DIRTMOND_PLATE = registerItem("dirtmond_plate"
                    , new PlateItem());
            Item DIRTMOND_HAMMER = registerItem("dirtmond_hammer"
                   , new HammerItem(1051));

        }
    }
}


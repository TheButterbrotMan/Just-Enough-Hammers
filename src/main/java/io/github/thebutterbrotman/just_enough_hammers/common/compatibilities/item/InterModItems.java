package io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.item;

import io.github.thebutterbrotman.just_enough_hammers.JustEnoughHammers;
import io.github.thebutterbrotman.just_enough_hammers.common.compatibilities.util.IMUtils;
import io.github.thebutterbrotman.just_enough_hammers.common.item.impl.HammerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class InterModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(JustEnoughHammers.MOD_ID, name), item);

    }

    public static void registerItems() {

        //Dirtmonds
        if (IMUtils.DIRTMONDS_LOADED) {
            IMUtils.logInterModRegStatus(IMUtils.DIRTMONDS_MODNAME, IMUtils.REG, false);

            Item DIRTMOND_HAMMER = registerItem("dirtmond_hammer"
                    , new HammerItem(1051, ToolMaterials.DIAMOND, 6, -3.0F));

            IMUtils.logInterModRegStatus(IMUtils.DIRTMONDS_MODNAME, IMUtils.REG, true);
        }
    }
}


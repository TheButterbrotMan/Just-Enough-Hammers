package io.github.thebutterbrotman.awesome_plates.common.compatibilities.item;

import io.github.thebutterbrotman.awesome_plates.AwesomePlates;
import io.github.thebutterbrotman.awesome_plates.common.compatibilities.util.IMUtils;
import io.github.thebutterbrotman.awesome_plates.common.item.impl.HammerItem;
import io.github.thebutterbrotman.awesome_plates.common.item.impl.PlateItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class InterModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(AwesomePlates.MOD_ID, name), item);

    }

    public static void registerItems() {

        //Dirtmonds
        if (IMUtils.DIRTMONDS_LOADED) {
            IMUtils.logInterModRegStatus(IMUtils.DIRTMONDS_MODNAME, IMUtils.REG, false);

            Item DIRTMOND_PLATE = registerItem("dirtmond_plate"
                    , new PlateItem());
            Item DIRTMOND_HAMMER = registerItem("dirtmond_hammer"
                    , new HammerItem(1051, ToolMaterials.DIAMOND, 6, -3.0F));

            IMUtils.logInterModRegStatus(IMUtils.DIRTMONDS_MODNAME, IMUtils.REG, true);
        }
    }
}


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
                    , new HammerItem(116, ToolMaterials.DIAMOND, -1, -3.0F));

            IMUtils.logInterModRegStatus(IMUtils.DIRTMONDS_MODNAME, IMUtils.REG, true);
        }
        //Therrassium
        if (IMUtils.THERRASSIUM_LOADED) {
            IMUtils.logInterModRegStatus(IMUtils.THERRASSIUM_MODNAME, IMUtils.REG, false);

            Item THERRASSIUM_HAMMER = registerItem("therrassium_hammer"
                    , new HammerItem(451, ToolMaterials.DIAMOND, 17, -3.0F));
        }
        //Amethyst Equipment
        if (IMUtils.AMETHYSTEQUIPMENT_LOADED) {
            IMUtils.logInterModRegStatus(IMUtils.AMETHYSTEQUIPMENT_MODNAME, IMUtils.REG, false);

            Item AMETHYST_HAMMER = registerItem("amethyst_hammer"
                    , new HammerItem(4, ToolMaterials.GOLD, 1, -3.0F));
        }
        //AdventureZ
        if (IMUtils.ADVENTUREZ_LOADED) {
            IMUtils.logInterModRegStatus(IMUtils.ADVENTUREZ_MODNAME, IMUtils.REG, false);

            Item GILDED_NETHERITE_HAMMER = registerItem("gilded_netherite_hammer"
                    , new HammerItem(336, ToolMaterials.DIAMOND, 4, -3.0F));
        }
        IMUtils.logInterModRegStatus(IMUtils.ADVENTUREZ_MODNAME, IMUtils.REG, true);
    }
}

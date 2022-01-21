package io.github.thebutterbrotman.awesomeplates.common.item;

import io.github.thebutterbrotman.awesomeplates.Awesomeplates;
import io.github.thebutterbrotman.awesomeplates.common.item.impl.HammerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    //Wooden
    public static final Item WOODEN_PLATE = registerItem("wooden_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer"
            , new HammerItem(59));

    //Stone
    public static final Item STONE_PLATE = registerItem("stone_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item STONE_HAMMER = registerItem("stone_hammer"
            , new HammerItem(131));

    //Iron
    public static final Item IRON_PLATE = registerItem("iron_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer"
            , new HammerItem(250));

    //Golden
    public static final Item GOLDEN_PLATE = registerItem("golden_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer"
            , new HammerItem(59));

    //Diamond
    public static final Item DIAMOND_PLATE = registerItem("diamond_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer"
            , new HammerItem(1561));

    //Netherite
    public static final Item NETHERITE_PLATE = registerItem("netherite_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer"
            , new HammerItem(2031));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Awesomeplates.MOD_ID, name), item);
    }

    public static void registerItems() {

    }

}

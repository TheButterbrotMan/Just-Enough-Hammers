package io.github.thebutterbrotman.awesomeplates.common.item;

import io.github.thebutterbrotman.awesomeplates.Awesomeplates;
import io.github.thebutterbrotman.awesomeplates.common.item.impl.HammerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    //Tier 1
    public static final Item WOODEN_PLATE = registerItem("wooden_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer"
            , new HammerItem());

    //Tier 2
    public static final Item STONE_PLATE = registerItem("stone_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item STONE_HAMMER = registerItem("stone_hammer"
            , new HammerItem());
    public static final Item COAL_PLATE = registerItem("coal_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item COAL_HAMMER = registerItem("coal_hammer"
            , new HammerItem());

    //Tier 3
    public static final Item IRON_PLATE = registerItem("iron_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item IRON_HAMMER = registerItem("iron_hammer"
            , new HammerItem());
    public static final Item LAPIS_LAZULI_PLATE = registerItem("lapis_lazuli_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item LAPIS_LAZULI_HAMMER = registerItem("lapis_lazuli_hammer"
            , new HammerItem());
    public static final Item COPPER_PLATE = registerItem("copper_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item COPPER_HAMMER = registerItem("copper_hammer"
            , new HammerItem());

    //Tier 4
    public static final Item GOLDEN_PLATE = registerItem("golden_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer"
            , new HammerItem());
    public static final Item EMERALD_PLATE = registerItem("emerald_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item EMERALD_HAMMER = registerItem("emerald_hammer"
            , new HammerItem());
    public static final Item REDSTONE_PLATE = registerItem("redstone_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item REDSTONE_HAMMER = registerItem("redstone_hammer"
            , new HammerItem());

    //Tier 5
    public static final Item DIAMOND_PLATE = registerItem("diamond_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer"
            , new HammerItem());

    //Tier 6
    public static final Item NETHERITE_PLATE = registerItem("netherite_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer"
            , new HammerItem());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Awesomeplates.MOD_ID, name), item);
    }

    public static void registerItems() {

    }

}

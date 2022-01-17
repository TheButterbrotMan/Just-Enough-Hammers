package io.github.thebutterbrotman.awesomeplates.Mod;

import io.github.thebutterbrotman.awesomeplates.Awesomeplates;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {

    public static final Item IRON_PLATE = registerItem("iron_plate"
    , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item GOLD_PLATE = registerItem("gold_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item DIAMOND_PLATE = registerItem("diamond_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item NETHERITE_PLATE = registerItem("netherite_plate"
            , new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Awesomeplates.MOD_ID, name), item);
    }

    public static void registerItems(){

    }

}

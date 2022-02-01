package io.github.thebutterbrotman.awesomeplates.common.ModItems.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import io.github.thebutterbrotman.awesomeplates.Awesomeplates;
import io.github.thebutterbrotman.awesomeplates.common.ModItems.impl.HammerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PlateItem {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Awesomeplates.MOD_ID, name), item);
    }
PLEASE ADD ItemGroup MATERIALS @TAPIO
}
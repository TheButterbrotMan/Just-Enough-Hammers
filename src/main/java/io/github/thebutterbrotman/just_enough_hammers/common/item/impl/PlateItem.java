package io.github.thebutterbrotman.just_enough_hammers.common.item.impl;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class PlateItem extends Item {
    public PlateItem() {
        super(new FabricItemSettings().group(ItemGroup.MATERIALS));
    }

}
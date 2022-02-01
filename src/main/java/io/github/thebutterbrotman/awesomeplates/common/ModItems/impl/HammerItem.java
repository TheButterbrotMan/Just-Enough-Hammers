package io.github.thebutterbrotman.awesomeplates.common.ModItems.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HammerItem extends Item implements CustomRecipeRemainder {
    public HammerItem(int durability) {
        super(new Item.Settings().maxDamage(durability).group(ItemGroup.TOOLS));
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stackIn) {
        ItemStack stack = stackIn.copy();
        stack.setDamage(stack.getDamage() + 4);

        if (stack.getDamage() >= stack.getMaxDamage()) {
            stack.decrement(4);
        }

        return stack;
    }
}

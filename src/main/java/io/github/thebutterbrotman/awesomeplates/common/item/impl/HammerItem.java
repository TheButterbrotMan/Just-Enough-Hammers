package io.github.thebutterbrotman.awesomeplates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HammerItem extends Item implements CustomRecipeRemainder {
    public HammerItem() {
        super(new Item.Settings().maxDamage(300).group(ItemGroup.TOOLS));
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stackIn) {
        ItemStack stack = stackIn.copy();
        stack.setDamage(stack.getDamage() + 1);

        if (stack.getDamage() >= stack.getMaxDamage()) {
            stack.decrement(1);
        }

        return stack;
    }
}

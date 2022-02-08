package io.github.thebutterbrotman.awesome_plates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.item.*;

public class HammerItem extends SwordItem implements CustomRecipeRemainder {
    public HammerItem(int durability, ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Item.Settings().maxDamage(durability).group(ItemGroup.TOOLS));
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

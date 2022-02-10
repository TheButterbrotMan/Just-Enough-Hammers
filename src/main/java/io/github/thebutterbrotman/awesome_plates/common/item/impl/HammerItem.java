package io.github.thebutterbrotman.awesome_plates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class HammerItem extends SwordItem implements CustomRecipeRemainder {
    private final int miningLevel;
    public HammerItem(int durability, ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Item.Settings().maxDamage(durability).group(ItemGroup.TOOLS));
        miningLevel = material.getMiningLevel();
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stackIn) {
        final int instability = Math.max(0, 5 - miningLevel - (int) Math.log10(stackIn.getMaxDamage()));
        final ItemStack stack = stackIn.copy();
        final Random random = new Random();
        stack.setDamage(stack.getDamage() + 1 + random.nextInt(instability));

        if (stack.getDamage() >= stack.getMaxDamage()) {
            stack.decrement(1);
        }
        return stack;
    }

    //Add this to prevent player breaking block by left-clicking
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return false;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        final PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.PASS;
        }
        final ItemStack hammerStack = context.getStack();
        //todo:block break
        player.getItemCooldownManager().set(hammerStack.getItem(),
                //below is the cool-down tick
                20);
        return ActionResult.SUCCESS;
    }
}

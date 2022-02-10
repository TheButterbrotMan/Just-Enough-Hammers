package io.github.thebutterbrotman.awesome_plates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("this.is.a.localization.key").formatted(
                //the color of the tooltip
                Formatting.AQUA));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stackIn) {
        final int instability = Math.max(0, 10 - miningLevel - (int) Math.log10(stackIn.getMaxDamage()));
        final ItemStack stack = stackIn.copy();
        final Random random = new Random();
        final int damageToAdd = (random.nextInt(100) * instability > 400) ? random.nextInt(50, 101) : 1 + random.nextInt(instability);
        stack.setDamage(stack.getDamage() + damageToAdd);

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

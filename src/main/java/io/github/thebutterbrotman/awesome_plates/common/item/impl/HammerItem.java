package io.github.thebutterbrotman.awesome_plates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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
        //todo
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

    //Add this to prevent player breaking block by left-clicking when not sneaking
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return miner.isSneaking();
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        final PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.PASS;
        }
        final World world = player.world;
        if (world == null) {
            return ActionResult.PASS;
        }
        final ItemStack hammerStack = context.getStack();
        final Direction direction = context.getSide();
        final BlockPos pos = context.getBlockPos();
        if (player instanceof ServerPlayerEntity serverPlayer) {
            tryBreakNineBlocks(world, serverPlayer, directionToInt(direction), pos, hammerStack);
        }

        player.getItemCooldownManager().set(hammerStack.getItem(),
                //below is the cool-down tick
                20);
        return ActionResult.SUCCESS;
    }

    public int directionToInt(Direction direction) {
        return switch (direction) {
            case UP, DOWN -> 2;
            case EAST, WEST -> 1;
            case NORTH, SOUTH -> 3;
        };
    }

    public void tryBreakNineBlocks(World world, ServerPlayerEntity player, int direction, BlockPos center, ItemStack hammerStack) {
        final boolean calX = !(direction == 1);
        final boolean calY = !(direction == 2);
        final boolean calZ = !(direction == 3);
        final int xStart = center.getX() - (calX ? 1 : 0);
        final int yStart = center.getY() - (calY ? 1 : 0);
        final int zStart = center.getZ() - (calZ ? 1 : 0);
        boolean willContinue = true;
        for (int x = 0; x <= (calX ? 2 : 0) && willContinue; x++) {
            for (int y = 0; y <= (calY ? 2 : 0) && willContinue; y++) {
                for (int z = 0; z <= (calZ ? 2 : 0) && willContinue; z++) {
                    willContinue = checkAndTryBreakBlock(world, player, new BlockPos(xStart + x, yStart + y, zStart + z), hammerStack);
                }
            }
        }
    }

    public boolean checkAndTryBreakBlock(World world, ServerPlayerEntity player, BlockPos pos, ItemStack hammer) {
        final Block blockToCheck = world.getBlockState(pos).getBlock();
        if (blockToCheck instanceof BlockWithEntity) {
            return true;
        }
        if (blockToCheck.getHardness() == -1.0F) {
            //Skip bedrock
            return true;
        }
        world.breakBlock(pos, true, player);
        if (hammer.damage(1, world.random, player)) {
            hammer.decrement(1);
            hammer.setDamage(0);
            if (hammer.isEmpty()) {
                player.getInventory().remove(e -> e.getItem() == hammer.getItem(), 1, player.getInventory());
                return false;
            }
        }
        return true;
    }
}

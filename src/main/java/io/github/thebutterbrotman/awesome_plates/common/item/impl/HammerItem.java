package io.github.thebutterbrotman.awesome_plates.common.item.impl;

import com.kwpugh.pugh_lib.api.CustomRecipeRemainder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
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
        final String stabilityKey = switch (Math.min(10, Math.max(0, miningLevel + (int) Math.log10(stack.getMaxDamage())))) {
            case 0, 1, 2, 3 -> "low";
            case 4, 5, 6 -> "medium";
            case 7, 8, 9, 10 -> "high";
            default -> "";
        };
        //todo
        tooltip.add(new LiteralText(
                MessageFormat.format(
                        new TranslatableText("tooltip.awesome_plates.hammer_1").getString(),
                        new TranslatableText("tooltip.awesome_plates.stability." + stabilityKey).getString())) {
        });
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stackIn) {
        final int instability = Math.min(Math.max(0, 10 - miningLevel - (int) Math.log10(stackIn.getMaxDamage())), 10);
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
        final Hand hand = context.getHand();
        final World world = player.world;
        if (world == null) {
            return ActionResult.PASS;
        }
        final ItemStack hammerStack = context.getStack();
        final Direction direction = context.getSide();
        final BlockPos pos = context.getBlockPos();
        if (player instanceof ServerPlayerEntity serverPlayer) {
            tryBreakNineBlocks(world, serverPlayer, directionToInt(direction), pos, hammerStack, hand);
        }

        player.getItemCooldownManager().set(hammerStack.getItem(),
                //below is the cool-down tick
                Math.max(5, 50 - 10 * miningLevel));
        return ActionResult.success(world.isClient);
    }

    public int directionToInt(Direction direction) {
        return switch (direction) {
            case UP, DOWN -> 2;
            case EAST, WEST -> 1;
            case NORTH, SOUTH -> 3;
        };
    }

    public void tryBreakNineBlocks(World world, ServerPlayerEntity player, int direction, BlockPos center, ItemStack hammerStack, Hand hand) {
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
                    willContinue = checkAndTryBreakBlock(world, player, new BlockPos(xStart + x, yStart + y, zStart + z), hammerStack, hand);
                }
            }
        }
    }

    public boolean checkAndTryBreakBlock(World world, ServerPlayerEntity player, BlockPos pos, ItemStack hammer, Hand hand) {
        final Block blockToCheck = world.getBlockState(pos).getBlock();
        if (blockToCheck instanceof BlockWithEntity) {
            return true;
        }
        if (blockToCheck.getHardness() < 0F) {
            //Skip bedrock
            return true;
        }
        world.breakBlock(pos, true, player);
        if (hammer.damage(1, player.world.random, player)) {
            player.setStackInHand(hand, ItemStack.EMPTY);
            return false;
        }
        return true;
    }
}

package io.github.thebutterbrotman.just_enough_hammers.common.item.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Original Author:kwpugh
public class AreaToolUtil {
    public static byte attemptBreakNeighbors(World world, PlayerEntity player, int radius, boolean obsidian) {
        byte b = 0;
        if (world.isClient) return 0;
        final Hand hand = player.getActiveHand();
        final ItemStack stack = player.getStackInHand(hand);
        if (!(stack.getItem() instanceof PickaxeItem p)) return 0;
        final Map<Enchantment, Integer> enchantments = EnchantmentHelper.get(player.getMainHandStack());
        final boolean silkTouch = enchantments.containsKey(Enchantments.SILK_TOUCH);
        final List<BlockPos> targetBlocks = calcRay(world, player, radius);
        for (BlockPos pos : targetBlocks) {
            final BlockState state = world.getBlockState(pos);
            if (!state.isToolRequired() || !p.isSuitableFor(state)) {
                continue;
            }
            final Block block = state.getBlock();
            final float hardness = state.getHardness(world, pos);
            final boolean readyForBreaking = obsidian || (hardness < 50.0F && hardness >= 0F);
            if (readyForBreaking) {
                if (!(block instanceof BlockEntityProvider)) {
                    world.breakBlock(pos, false);
                    if (silkTouch) {
                        // drop blocks
                        world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(block.asItem(), 1)));
                    } else {
                        // drops stacks
                        Block.dropStacks(state, world, pos, null, player, stack);   // USe this version to account for enchantments on stack
                    }
                    b++;
                }
            }
        }
        return b;
    }

    public static List<BlockPos> calcRay(World world, PlayerEntity playerIn, int radius) {
        final ArrayList<BlockPos> blockResultList = new ArrayList<>();

        final Vec3d cameraPos = playerIn.getCameraPosVec(1);
        final Vec3d rotation = playerIn.getRotationVec(1);
        final Vec3d cameraPosWithRotation = cameraPos.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);

        final BlockHitResult blockHitResult = world.raycast(new RaycastContext(cameraPos, cameraPosWithRotation, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, playerIn));

        if (blockHitResult.getType() != HitResult.Type.BLOCK) return blockResultList;
        final Direction.Axis axis = blockHitResult.getSide().getAxis();
        final ArrayList<BlockPos> targetPos = new ArrayList<>();
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    if (x != 0 || y != 0 || z != 0) targetPos.add(new BlockPos(x, y, z));
                }
            }
        }
        final BlockPos origin = blockHitResult.getBlockPos();
        //Depending on the side and axis, add blockPos on same plane
        for (BlockPos pos : targetPos) {
            if (axis == Direction.Axis.Y) {
                if (pos.getY() == 0) {
                    blockResultList.add(origin.add(pos));
                }
            } else if (axis == Direction.Axis.X) {
                if (pos.getX() == 0) {
                    blockResultList.add(origin.add(pos));
                }
            } else if (axis == Direction.Axis.Z) {
                if (pos.getZ() == 0) {
                    blockResultList.add(origin.add(pos));
                }
            }
        }

        return blockResultList;
    }
}

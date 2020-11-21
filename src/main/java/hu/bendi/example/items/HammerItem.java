package hu.bendi.example.items;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerItem extends ToolItem {

    private ToolMaterial material;

    public HammerItem(ToolMaterial mat) {
        super(mat, new Item.Settings()
                .group(ItemGroup.TOOLS)
                .maxCount(1)
                .maxDamage(mat.getDurability() * 5));
        material = mat;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!super.canMine(state, world, pos, (PlayerEntity)miner)) return false;
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY()    , pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY()    , pos.getZ()), true);
        world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ()), true);
        stack.damage(9, new Random(), (ServerPlayerEntity)miner);
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return material.getMiningSpeed();
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}

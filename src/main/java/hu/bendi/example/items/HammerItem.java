package hu.bendi.example.items;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
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
    
    private static final Set<Block> EFFECTIVE_BLOCKS;

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
        if (!this.isEffectiveOn(state)) return true;
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX(),     pos.getY() - 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY()    , pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY()    , pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY()    , pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY()    , pos.getZ()), true);
        if (this.isEffectiveOn(world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ())))) world.breakBlock(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ()), true);
        stack.damage(9, new Random(), (ServerPlayerEntity)miner);
        if (stack.getDamage() > material.getDurability() * 5) {
            stack.decrement(0);
            return false;
        }
        return false;
    }


    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
       return true;
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        Block block = state.getBlock();
        int i = material.getMiningLevel();
        if (block == Blocks.OBSIDIAN) {
            return i == 3;
        } else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE && block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK && block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE && block != Blocks.REDSTONE_ORE) {
            if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE && block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE) {
                Material material = state.getMaterial();
                return material == Material.STONE || material == Material.METAL || material == Material.ANVIL;
            } else {
                return i >= 1;
            }
        } else {
            return i >= 2;
        }
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.METAL && material != Material.ANVIL && material != Material.STONE ? super.getMiningSpeed(stack, state) : this.material.getMiningSpeed();
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    static {
        EFFECTIVE_BLOCKS = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, new Block[]{Blocks.POWERED_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_STONE, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX});
     }
}

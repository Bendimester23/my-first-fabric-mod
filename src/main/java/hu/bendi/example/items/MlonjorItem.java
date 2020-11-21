package hu.bendi.example.items;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MlonjorItem extends ToolItem {

    public MlonjorItem(Settings settings) {
        super(ToolMaterials.DIAMOND, new Item.Settings()
            .maxCount(1)
            .maxDamage(1000)
            .rarity(Rarity.EPIC));

    }

    @Override
    public boolean hasEnchantmentGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Texts.joinOrdered(Collections.singleton("A very special item, for the ones that can afford it.")));
    }

}
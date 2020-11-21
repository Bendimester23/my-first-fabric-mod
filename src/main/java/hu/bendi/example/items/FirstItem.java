package hu.bendi.example.items;

import hu.bendi.example.dimensions.TutorialDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FirstItem extends Item {

    public FirstItem() {
        super(new Settings().group(ItemGroup.MISC).maxDamage(500));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0f, 1.0f);
        user.changeDimension(TutorialDimensions.MAGIC_MOON);
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

}
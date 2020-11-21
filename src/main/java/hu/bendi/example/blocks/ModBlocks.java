package hu.bendi.example.blocks;

import hu.bendi.example.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block FIRST_BLOCK = new FirstBlock();
    
    public static void register() {
		Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MODID, "first_block"), FIRST_BLOCK);
    }
}

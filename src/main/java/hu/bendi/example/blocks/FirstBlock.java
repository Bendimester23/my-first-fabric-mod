package hu.bendi.example.blocks;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class FirstBlock extends Block{

    public FirstBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE)
                .breakByTool(FabricToolTags.PICKAXES)
                .lightLevel(6)
                .build());
    }
}

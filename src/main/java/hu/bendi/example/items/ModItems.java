package hu.bendi.example.items;

import hu.bendi.example.TutorialMod;
import hu.bendi.example.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item FABRIC_ITEM = new FirstItem();
	public static final Item DIAMOND_HAMMER_ITEM = new HammerItem(ToolMaterials.DIAMOND);
	public static final Item IRON_HAMMER_ITEM = new HammerItem(ToolMaterials.IRON);
	public static final Item GOLD_HAMMER_ITEM = new HammerItem(ToolMaterials.GOLD);
    public static final Item STONE_HAMMER_ITEM = new HammerItem(ToolMaterials.STONE);
    public static final Item FIRST_BLOCK_ITEM = new BlockItem(ModBlocks.FIRST_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "first-item"), FABRIC_ITEM);
		Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "diamond-hammer"), DIAMOND_HAMMER_ITEM);
		Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "iron-hammer"), IRON_HAMMER_ITEM);
		Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "gold-hammer"), GOLD_HAMMER_ITEM);
		Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "stone-hammer"), STONE_HAMMER_ITEM);
		Registry.register(Registry.ITEM, new Identifier(TutorialMod.MODID, "first_block"), FIRST_BLOCK_ITEM);
    }
}

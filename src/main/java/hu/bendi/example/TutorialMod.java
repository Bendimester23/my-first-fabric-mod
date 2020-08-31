package hu.bendi.example;

import hu.bendi.example.items.FirstItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TutorialMod implements ModInitializer {

	public static final Item FABRIC_ITEM = new FirstItem();

	@Override
	public void onInitialize() {
		Registry.register( Registry.ITEM, new Identifier("test", "first-item"), FABRIC_ITEM);
	}
}

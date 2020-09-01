package hu.bendi.example.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;

import java.util.ArrayList;
import java.util.Collection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class ExampleMixin extends Screen {

	protected ExampleMixin(Text title) {
		super(title);
	}

	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Collection<String> strs = new ArrayList<>();
		strs.add("asfdsg");
		this.addButton(new ButtonWidget(100, 100, 100, 20, Texts.joinOrdered(strs), (asd) -> {
			System.out.println("fg9hfthoo");
		}));
	}
}

package hu.bendi.example.dimensions;

import hu.bendi.example.TutorialMod;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;

public class TutorialDimensions {
    public static final FabricDimensionType MAGIC_MOON = FabricDimensionType.builder()
            .defaultPlacer((oldEntity, destinationWorld, portalDir, horizontalOffset, verticalOffset) -> 
                    new BlockPattern.TeleportTarget(
                        new Vec3d(destinationWorld.getTopPosition(Heightmap.Type.WORLD_SURFACE, BlockPos.ORIGIN)), 
                        oldEntity.getVelocity(), 
                        (int) oldEntity.yaw))
            .factory(MagicMoonDimension::new)
            .skyLight(false)
            .buildAndRegister(new Identifier(TutorialMod.MODID, "magic_moon"));

    public static void register() {
        System.out.println("Loading dimension!");
    }
}

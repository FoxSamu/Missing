package net.shadew.missing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Missing implements ModInitializer {
    @Override
    public void onInitialize() {
        new Blocks();
        new Items();
    }

    public static class Blocks {
        public static final Block MISSING_BRICKS = Registry.register(Registry.BLOCK, new Identifier("missing:missing_bricks"), new Block(
            FabricBlockSettings.of(Material.STONE, MaterialColor.MAGENTA)
                               .requiresTool()
                               .breakByHand(false)
                               .breakByTool(FabricToolTags.PICKAXES)
                               .sounds(BlockSoundGroup.STONE)
        ));
        public static final Block MISSING_BRICK_SLAB = Registry.register(Registry.BLOCK, new Identifier("missing:missing_brick_slab"), new SlabBlock(
            FabricBlockSettings.copyOf(MISSING_BRICKS)
        ));
        public static final Block MISSING_BRICK_STAIRS = Registry.register(Registry.BLOCK, new Identifier("missing:missing_brick_stairs"), new StairsBlock(
            MISSING_BRICKS.getDefaultState(),
            FabricBlockSettings.copyOf(MISSING_BRICKS)
        ) {
        });
        public static final Block MISSING_BRICK_WALL = Registry.register(Registry.BLOCK, new Identifier("missing:missing_brick_wall"), new WallBlock(
            FabricBlockSettings.copyOf(MISSING_BRICKS)
        ));
    }

    public static class Items {
        public static final Item MISSING_BRICKS = Registry.register(Registry.ITEM, new Identifier("missing:missing_bricks"), new BlockItem(
            Blocks.MISSING_BRICKS,
            new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)
        ));
        public static final Item MISSING_BRICK_SLAB = Registry.register(Registry.ITEM, new Identifier("missing:missing_brick_slab"), new BlockItem(
            Blocks.MISSING_BRICK_SLAB,
            new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)
        ));
        public static final Item MISSING_BRICK_STAIRS = Registry.register(Registry.ITEM, new Identifier("missing:missing_brick_stairs"), new BlockItem(
            Blocks.MISSING_BRICK_STAIRS,
            new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)
        ));
        public static final Item MISSING_BRICK_WALL = Registry.register(Registry.ITEM, new Identifier("missing:missing_brick_wall"), new BlockItem(
            Blocks.MISSING_BRICK_WALL,
            new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)
        ));
    }
}

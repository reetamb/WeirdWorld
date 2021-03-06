package com.reetling.biomeseverywhere.registry;

import com.reetling.biomeseverywhere.BiomesEverywhere;
import com.reetling.biomeseverywhere.world.placers.BrushFoliagePlacer;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class BEWConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BiomesEverywhere.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_TREE_ASPEN = CONFIGURED_FEATURES.register("tree_aspen",
            () -> new ConfiguredFeature<>(Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(Blocks.BIRCH_LOG),
                            new StraightTrunkPlacer(6, 2, 0),
                            BlockStateProvider.simple(Blocks.HONEYCOMB_BLOCK),
                            new BrushFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), UniformInt.of(7, 9)),
                            new TwoLayersFeatureSize(1, 0, 1))
                            .decorators(List.of(new BeehiveDecorator(0.33F)))
                            .ignoreVines().build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_DANDELION = CONFIGURED_FEATURES.register("patch_dandelion",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DANDELION)),
                                    List.of(Blocks.GRASS_BLOCK, Blocks.DIRT), 64)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_SUNFLOWER = CONFIGURED_FEATURES.register("patch_sunflower",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SUNFLOWER)),
                            List.of(Blocks.GRASS_BLOCK, Blocks.DIRT), 64)));
}

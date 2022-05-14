// Thanks TerraBlender
package com.reetling.weirdworld.world;

import com.mojang.datafixers.util.Pair;
import com.reetling.weirdworld.biomes.AllBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class WeirdWorldRegion extends Region {

    public WeirdWorldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
//            builder.replaceBiome(Biomes.BIRCH_FOREST, AllBiomes.HONEYCOMB_FOREST);
//        });
        this.addBiomeSimilar(mapper, Biomes.BIRCH_FOREST, AllBiomes.HONEYCOMB_FOREST);
    }
}
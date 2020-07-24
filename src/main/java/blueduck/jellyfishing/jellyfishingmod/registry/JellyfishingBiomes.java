package blueduck.jellyfishing.jellyfishingmod.registry;

import blueduck.jellyfishing.jellyfishingmod.JellyfishingMod;
import blueduck.jellyfishing.jellyfishingmod.biomes.JellyfishFields;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class JellyfishingBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, JellyfishingMod.MODID);

    public static final RegistryObject<Biome> JELLYFISH_FIELDS = BIOMES.register("jellyfish_fields", () -> new JellyfishFields());


    public static void init() {
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static void registerBiomes() {
        registerBiome(JELLYFISH_FIELDS.get(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.OCEAN);
    }
    public static void registerBiome(Biome biome, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        //BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, 10));

    }

}


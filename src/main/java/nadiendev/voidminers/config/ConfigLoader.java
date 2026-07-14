package nadiendev.voidminers.config;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.util.MapUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.loading.FMLPaths;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static java.nio.file.Files.readAllBytes;

public class ConfigLoader {
    public static final String CONFIG_FILE = "voidminers.json5";
    private static ConfigLoader INSTANCE = new ConfigLoader();

    private ConfigLoader() {}

    public static ConfigLoader getInstance() {
        return INSTANCE != null ? INSTANCE : new ConfigLoader();
    }

    @Expose
    public boolean ALLOW_NO_ENERGY_MINERS = false;

    @Expose
    public boolean ALLOW_TICK_ACCELERATION_MINERS = true;

    @Expose
    public Map<String, MinerConfig> MINER_CONFIGS = MapUtil.of(
            MapUtil.createEntry("rubetine", new MinerConfig(10000000, 1000, 300,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.85f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.10f, 0.9f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.50f, 1.00f, 1.50f))
                    )
            )),
            MapUtil.createEntry("aurantium", new MinerConfig(25000000, 900, 350,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.83f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.12f, 0.88f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.55f, 1.00f, 1.60f))
                    )
            )),
            MapUtil.createEntry("citrinetine", new MinerConfig(50000000,800, 400,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.81f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.14f, 0.86f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.60f, 1.00f, 1.70f))
                    )
            )),
            MapUtil.createEntry("verdium", new MinerConfig(100000000,700, 450,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.79f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.16f, 0.84f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.65f, 1.00f, 1.80f))
                    )
            )),
            MapUtil.createEntry("azurine", new MinerConfig(250000000,600, 500,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.77f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.18f, 0.82f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.70f, 1.00f, 1.90f))
                    )
            )),
            MapUtil.createEntry("caerium", new MinerConfig(500000000,500, 550,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.75f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.20f, 0.8f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.75f, 1.00f, 2.00f))
                    )
            )),
            MapUtil.createEntry("amethystine", new MinerConfig(750000000,400, 600,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.73f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.22f, 0.78f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.80f, 1.00f, 2.10f))
                    )
            )),
            MapUtil.createEntry("rosarium", new MinerConfig(1000000000,300, 650,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.71f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.24f, 0.76f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(1.85f, 1.00f, 2.20f))
                    )
            )),
            MapUtil.createEntry("ultimate", new MinerConfig(2147483647,200, 700,
                    MapUtil.of(
                            MapUtil.createEntry("energy", new ModifierConfig(0.65f, 1.00f, 1.00f)),
                            MapUtil.createEntry("speed", new ModifierConfig(1.30f, 0.7f, 1.00f)),
                            MapUtil.createEntry("item", new ModifierConfig(2.00f, 1.00f, 2.50f))
                    )
            ))
    );

    public void load() {
        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

        Path configPath = FMLPaths.CONFIGDIR.get().resolve(CONFIG_FILE);
        File file = configPath.toFile();

        try {
            if (!file.exists()) {
                VoidMiners.LOGGER.info("Configuration file does not exist. Creating a new one.");
                saveDefaultConfig(file, gson);
            } else {
                VoidMiners.LOGGER.info("Configuration file is missing keys. Merging the current file with a new one to preserve changed settings.");
                mergeDefaultConfig(file, gson);
            }
        } catch (JsonSyntaxException e) {
            VoidMiners.LOGGER.error("Invalid configuration file. Regenerating default config.");
            saveDefaultConfig(file, gson);
        }
    }

    private void saveDefaultConfig(File file, Gson gson) {
        try (FileWriter writer = new FileWriter(file)) {
            if(INSTANCE == null) INSTANCE = new ConfigLoader();

            gson.toJson(INSTANCE, ConfigLoader.class, writer);
            VoidMiners.LOGGER.info("Default configuration file created successfully.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to create default configuration file.", e);
        }
    }

    private void mergeDefaultConfig(File file, Gson gson) {
        try {
            String existingContent = new String(readAllBytes(file.toPath()));

            JsonObject existingConfig = gson.fromJson(existingContent, JsonObject.class);

            // Create default config JSON from a fresh ConfigLoader instance
            StringWriter defaultConfigWriter = new StringWriter();
            gson.toJson(new ConfigLoader(), defaultConfigWriter);
            JsonObject defaultConfig = gson.fromJson(defaultConfigWriter.toString(), JsonObject.class);

            // Merge default config into existing config, only adding missing keys
            mergeJsonObjects(existingConfig, defaultConfig);

            // Convert merged config back to JSON string
            String mergedJson = gson.toJson(existingConfig);

            INSTANCE = gson.fromJson(mergedJson, ConfigLoader.class);

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(mergedJson);
            }

            VoidMiners.LOGGER.info("Merged configuration file successfully.");
        } catch (IOException | JsonSyntaxException e) {
            VoidMiners.LOGGER.error("Failed to merge, regenerating default config.");
            saveDefaultConfig(file, gson);
        }
    }

    private void mergeJsonObjects(JsonObject target, JsonObject source) {
        for (Map.Entry<String, JsonElement> entry : source.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (value.isJsonObject()) {
                // If the value is a nested object, recursively merge
                JsonObject nestedTarget = target.has(key) && target.get(key).isJsonObject()
                        ? target.getAsJsonObject(key)
                        : null;
                if (nestedTarget == null) {
                    nestedTarget = new JsonObject();
                    target.add(key, nestedTarget);
                }
                mergeJsonObjects(nestedTarget, value.getAsJsonObject());
            } else {
                // For non-object values, only add the value if it's missing in the target
                if (!target.has(key)) {
                    target.add(key, value);
                }
            }
        }
    }

    public MinerConfig getMinerConfig(String name) {
        return MINER_CONFIGS.getOrDefault(name, new MinerConfig(0,0, 0, Map.of()));
    }

    public ModifierConfig getModifierConfig(String name, String type) {
        return getMinerConfig(name).modifiers.getOrDefault(type, new ModifierConfig(1, 1, 1));
    }

    public ModifierConfig getModifierConfig(Block block) {
        String blockName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String minerTier = blockName.split("_")[0];
        String modifierType = blockName.split("_")[1];

        return getModifierConfig(minerTier, modifierType);
    }

    public record MinerConfig(@Expose int energyStorage, @Expose int duration, @Expose int energyTick, @Expose Map<String, ModifierConfig> modifiers) {

        public static final StreamCodec<ByteBuf, MinerConfig> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            MinerConfig::energyStorage,
            ByteBufCodecs.INT,
            MinerConfig::duration,
            ByteBufCodecs.INT,
            MinerConfig::energyTick,
            ByteBufCodecs.map(
                HashMap::new,
                ByteBufCodecs.STRING_UTF8,
                ModifierConfig.STREAM_CODEC
            ),
            MinerConfig::modifiers,
            MinerConfig::new
        );
    }

    public record ModifierConfig(@Expose float energy, @Expose float speed, @Expose float item) {
        public static final StreamCodec<ByteBuf, ModifierConfig> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT,
            ModifierConfig::energy,
            ByteBufCodecs.FLOAT,
            ModifierConfig::speed,
            ByteBufCodecs.FLOAT,
            ModifierConfig::item,
            ModifierConfig::new
        );
    }
}
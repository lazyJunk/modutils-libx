
# LibX && ModUtils Example Mod

This is a template that setups an simple LibX+ModUtils project for Minecraft.

### Links:

* **LibX:** https://github.com/noeppi-noeppi/LibX
* **ModUtils:** https://github.com/noeppi-noeppi/ModUtils
* **ModGradle:** https://github.com/noeppi-noeppi/ModGradle

### LibX Docs: https://github.com/noeppi-noeppi/LibX/wiki

## Current props:

Currently this template was done with the current versions of at the time:
* Forge, Libx, SugarCane Mappings.

```properties
# Gradle
org.gradle.jvmargs=-Xmx3G
org.gradle.daemon=false

# Mod properties
modid=example_libx_modutils
group=mod.example
base_version=1.0

# Dependencies
libx_version=1.17.1-2.1.9
forge_version=1.17.1-37.0.84
mappings=sugarcane_2021.09.05-1.17.1

#Misc
license_name=MIT
license_url=https://opensource.org/licenses/MIT
```

## What is done in this repo:

* Basic __build.gradle__ with ModUtils.
* Basic CurseMaven dependency with ModGradle. (You can remove it)

```groovy
buildscript {
    apply from: 'https://raw.githubusercontent.com/noeppi-noeppi/ModUtils/v2/buildscript.gradle', to: buildscript
}

apply from: 'https://raw.githubusercontent.com/noeppi-noeppi/ModUtils/v2/mod.gradle'
apply plugin: 'io.github.noeppi_noeppi.tools.modgradle.cursedep'

repositories {
    maven { url "https://maven.melanx.de/" }
}

dependencies {
    annotationProcessor fg.deobf("io.github.noeppi_noeppi.mods:LibX:${libx_version}")

    implementation fg.deobf("io.github.noeppi_noeppi.mods:LibX:${libx_version}")

    //Example curse maven implementation using modgradle cursedep
    implementation curse.mod(324717, 3468298) // Jade
}
```

* Basic __ModXRegistration__ implementation with LibX.

```java
@Mod(ExampleMod.MOD_ID)
public final class ExampleMod extends ModXRegistration {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "example_libx_modutils";

    public static LazyValue<ExampleMod> INSTANCE;

    public ExampleMod() {
        super(MOD_ID, new CreativeModeTab("exampleModTab") {
            @Nonnull
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(Items.DIAMOND);
            }
        });
        INSTANCE = new LazyValue<>(() -> this);
    }

    public static ExampleMod get() {
        return INSTANCE.get();
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.setVersion(1);
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }
}
```
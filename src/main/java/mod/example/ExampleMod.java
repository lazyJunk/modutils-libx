package mod.example;

import io.github.noeppi_noeppi.libx.mod.registration.ModXRegistration;
import io.github.noeppi_noeppi.libx.mod.registration.RegistrationBuilder;
import io.github.noeppi_noeppi.libx.util.LazyValue;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

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

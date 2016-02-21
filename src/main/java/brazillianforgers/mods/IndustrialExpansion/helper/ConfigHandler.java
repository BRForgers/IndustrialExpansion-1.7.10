package brazillianforgers.mods.IndustrialExpansion.helper;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import brazillianforgers.mods.IndustrialExpansion.Lib;

import java.io.File;

public class ConfigHandler {

    public static Configuration configuration;

    public static int energyCoalBall = 0;
    public static int energyCoalChunk = 0;
    public static int energyBurnedCoalBall = 0;
    public static int energyDiamond = 0;
    public static int energyMultiToolBases = 0;

    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Lib.MODID))
        {
            loadConfiguration();
        }
    }
    private static void loadConfiguration()
    {
        energyCoalBall  = configuration.getInt("energyCoalBall", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the production of Coal Ball.");
        energyCoalChunk = configuration.getInt("energyCoalChunk", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the production of Coal Chunk.");
        energyBurnedCoalBall = configuration.getInt("energyBurnedCoalBall", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the production of Burned Coal Ball.");
        energyDiamond = configuration.getInt("energyDiamond", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the production of Diamond.");
        energyMultiToolBases = configuration.getInt("energyMultiToolBases", "Energy Consumption", 2500, 1, 100000, "Sets the energy consumption for the production of MultiToolBases.");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}

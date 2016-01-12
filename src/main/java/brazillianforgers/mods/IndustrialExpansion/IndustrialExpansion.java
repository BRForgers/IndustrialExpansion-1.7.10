package brazillianforgers.mods.IndustrialExpansion;

import brazillianforgers.mods.IndustrialExpansion.helper.ConfigHandler;
import brazillianforgers.mods.IndustrialExpansion.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import brazillianforgers.core.UpdateManager;
import brazillianforgers.lib.ObjectStorage;

@Mod(modid = Lib.MODID, useMetadata = true, dependencies = Lib.DEPS, version = Lib.VERSION)
public class IndustrialExpansion {
    @Instance(Lib.MODID)
    public static IndustrialExpansion instance;

    @SidedProxy(clientSide = Lib.CLIENT, serverSide = Lib.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs tabIndustrialExpansion = new CreativeTabs("tabIndustrialExpansion") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.diamond;
        }
    };

    static Logger logger;
    //static Configuration config;
    //private static ObjectStorage configLib = new ObjectStorage();

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        ConfigHandler.init(e.getSuggestedConfigurationFile());
        proxy.preInit();
    }

    @EventHandler
    public static void Init(FMLInitializationEvent e)
    {

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e)
    {
        logger.info("Checking for Updates...");
        UpdateManager.check(Lib.UPDATEURL, logger, Lib.VERSION, Lib.MODNAME);
    }
}

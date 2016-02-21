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
import brforgers.core.UpdateManager;
import brforgers.core.lib.SilentLogger;

@Mod(modid = Lib.MODID, useMetadata = true, dependencies = Lib.DEPS, version = Lib.VERSION)
public class IndustrialExpansion {
    @Instance(Lib.MODID)
    public static IndustrialExpansion instance;
    
    public static Logger logger = new SilentLogger(); //This is a Temp Logger until proper init.

    @SidedProxy(clientSide = Lib.CLIENT, serverSide = Lib.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs tabIndustrialExpansion = new CreativeTabs("tabIndustrialExpansion")
    {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Items.diamond;
        }
    };


    //static Configuration config;
    //private static ObjectStorage configLib = new ObjectStorage();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        logger = e.getModLog();
        ConfigHandler.init(e.getSuggestedConfigurationFile());
        proxy.preInit();
        UpdateManager.addToUpdateChecker(Lib.MODID, Lib.MODNAME, Lib.UPDATEURL, Lib.VERSION, logger);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
    	
    }
}

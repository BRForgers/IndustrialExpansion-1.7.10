package brazillianforgers.mods.IndustrialExpansion.proxy;

import brazillianforgers.mods.IndustrialExpansion.manager.MachineManager;

public class CommonProxy
{

    public void preInit() {
        MachineManager.init();
    }

}
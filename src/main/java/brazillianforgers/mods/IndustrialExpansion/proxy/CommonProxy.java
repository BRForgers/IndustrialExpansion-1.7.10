package brazillianforgers.mods.IndustrialExpansion.proxy;

import brazillianforgers.mods.IndustrialExpansion.manager.ItemManager;
import brazillianforgers.mods.IndustrialExpansion.manager.MachineManager;
import brazillianforgers.mods.IndustrialExpansion.manager.RecipeManager;
import brazillianforgers.mods.IndustrialExpansion.manager.SmelterRecipeManager;

public class CommonProxy
{

    public void preInit() {
        MachineManager.init();
        ItemManager.init();
        RecipeManager.init();
        SmelterRecipeManager.init();
    }

}
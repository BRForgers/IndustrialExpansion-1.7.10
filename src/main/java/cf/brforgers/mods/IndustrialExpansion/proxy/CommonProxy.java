package cf.brforgers.mods.IndustrialExpansion.proxy;

import cf.brforgers.mods.IndustrialExpansion.manager.ItemManager;
import cf.brforgers.mods.IndustrialExpansion.manager.MachineManager;
import cf.brforgers.mods.IndustrialExpansion.manager.RecipeManager;
import cf.brforgers.mods.IndustrialExpansion.manager.BlockManager;
import cf.brforgers.mods.IndustrialExpansion.world.WorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{

    public void preInit() {
        MachineManager.init();
        ItemManager.init();
        BlockManager.init();

    }
    public void postInit() {
        GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
        RecipeManager.init();

    }

}
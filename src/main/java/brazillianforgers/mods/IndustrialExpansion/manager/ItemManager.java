package brazillianforgers.mods.IndustrialExpansion.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import brazillianforgers.mods.IndustrialExpansion.items.*;
import brazillianforgers.mods.IndustrialExpansion.proxy.CommonProxy;

public class ItemManager
{
    //Item List
    public static Item TestItem;

    //Init Method
    public static void init()
    {
        TestItem = new TestItem();
        GameRegistry.registerItem(TestItem, "Test");
    }
}

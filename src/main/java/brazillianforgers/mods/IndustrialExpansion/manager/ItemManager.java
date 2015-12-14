package brazillianforgers.mods.IndustrialExpansion.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import brazillianforgers.mods.IndustrialExpansion.items.*;
import brazillianforgers.mods.IndustrialExpansion.proxy.CommonProxy;
import net.minecraftforge.common.util.EnumHelper;

public class ItemManager
{
    //Item List
    public static Item.ToolMaterial TEST = EnumHelper.addToolMaterial("TEST", 3, 1000, 15.0F, 4.0F, 30);
    public static Item TestItem;

    //Init Method
    public static final void init()
    {
        GameRegistry.registerItem(TestItem = new TestItem("Test", TEST), "Test");
    }
}

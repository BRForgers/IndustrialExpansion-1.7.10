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

    //BASE: public static Item NomeDoItem = new ClasseDoItem();
    public static Item.ToolMaterial TEST = EnumHelper.addToolMaterial("TEST", 3, -1, 40.0F, 98.0F, 30);
    public static Item TestItem = new TestItem("Test", TEST);
    public static Item CoalBall = new CoalBall();
    public static Item BurnedCoalBall = new BurnedCoalBall();
    public static Item CoalChunk = new CoalChunk();


    //Init Method
    public static final void init()
    {
        //BASE: GameRegistry.registerItem(NomeDoItem, "NomeDoItem");
        GameRegistry.registerItem(TestItem, "Test");
        GameRegistry.registerItem(CoalBall,"CoalBall");
        GameRegistry.registerItem(BurnedCoalBall,"BurnedCoalBall");
        GameRegistry.registerItem(CoalChunk,"CoalChunk");
    }
}

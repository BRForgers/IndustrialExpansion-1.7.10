package brazillianforgers.mods.IndustrialExpansion.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.Lib;

public class TestItem extends Item
{
    public TestItem()
    {
        setUnlocalizedName("Test");
        setTextureName(Lib.MODID + ":" + "TestItem");
        setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }

}

package brazillianforgers.mods.IndustrialExpansion.items;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class MultiToolBase extends Item{
    public MultiToolBase() {
        this.setUnlocalizedName("MultiToolBase");
        this.setTextureName(Lib.RESOURCE_PATH + "MultiToolBase");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

package brazillianforgers.mods.IndustrialExpansion.items;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class CoalChunk extends Item {
    public CoalChunk()
    {
        this.setUnlocalizedName("CoalChunk");
        this.setTextureName(Lib.RESOURCE_PATH + "CoalChunk");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

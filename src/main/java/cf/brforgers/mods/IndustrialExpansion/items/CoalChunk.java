package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class CoalChunk extends Item {
    public CoalChunk()
    {
        this.setUnlocalizedName("CoalChunk");
        this.setTextureName(Lib.RESOURCE_PATH + "CoalChunk");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

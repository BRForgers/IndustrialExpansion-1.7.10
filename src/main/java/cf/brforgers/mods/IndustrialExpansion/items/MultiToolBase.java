package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class MultiToolBase extends Item{
    public MultiToolBase() {
        this.setUnlocalizedName("MultiToolBase");
        this.setTextureName(Lib.RESOURCE_PATH + "MultiToolBase");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

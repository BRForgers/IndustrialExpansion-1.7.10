package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class Iridium extends Item {
    public Iridium()
    {
        this.setUnlocalizedName("Iridium");
        this.setTextureName(Lib.RESOURCE_PATH + "Iridium");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

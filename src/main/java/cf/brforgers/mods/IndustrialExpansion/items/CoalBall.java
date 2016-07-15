package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class CoalBall extends Item {
    public CoalBall()
    {
        this.setUnlocalizedName("CoalBall");
        this.setTextureName(Lib.RESOURCE_PATH + "CoalBall");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

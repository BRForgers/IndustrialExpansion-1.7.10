package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class BurnedCoalBall extends Item {
    public BurnedCoalBall()
    {
        this.setUnlocalizedName("BurnedCoalBall");
        this.setTextureName(Lib.RESOURCE_PATH + "BurnedCoalBall");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

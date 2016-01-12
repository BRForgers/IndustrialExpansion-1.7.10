package brazillianforgers.mods.IndustrialExpansion.items;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class CoalBall extends Item {
    public CoalBall()
    {
        this.setUnlocalizedName("CoalBall");
        this.setTextureName(Lib.RESOURCE_PATH + "CoalBall");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

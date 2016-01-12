package brazillianforgers.mods.IndustrialExpansion.items;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.Lib;
import net.minecraft.item.Item;

public class BurnedCoalBall extends Item {
    public BurnedCoalBall()
    {
        this.setUnlocalizedName("BurnedCoalBall");
        this.setTextureName(Lib.MODID + ":" + "BurnedCoalBall");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    }
}

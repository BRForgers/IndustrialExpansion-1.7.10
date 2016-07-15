package cf.brforgers.mods.IndustrialExpansion.manager;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cf.brforgers.mods.IndustrialExpansion.blocks.*;

public class BlockManager {

    public static Block IridiumOre = new IridiumOreBlock();

    public static void init()
    {
        GameRegistry.registerBlock(IridiumOre, "IridiumOre");
    }
}

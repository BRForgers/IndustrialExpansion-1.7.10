package cf.brforgers.mods.IndustrialExpansion.blocks;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import cf.brforgers.mods.IndustrialExpansion.manager.ItemManager;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import java.util.Random;

public class IridiumOreBlock extends BlockOre {

    public IridiumOreBlock() {
        super();
        this.setBlockName("IridiumOre");
        this.setBlockTextureName(Lib.RESOURCE_PATH + "IridiumOre");
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(5.0F);
        this.setResistance(6000.0F);
    }
    public Item getItemDropped(int ignored1, Random ignored2, int ignored3)
    {
        return ItemManager.Iridium;
    }

    public int quantityDropped(Random rand)
    {
        return 1;
    }
    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess ignored1, int ignored2, int ignored3)
    {
        return MathHelper.getRandomIntegerInRange(rand, 3, 7);
    }
}

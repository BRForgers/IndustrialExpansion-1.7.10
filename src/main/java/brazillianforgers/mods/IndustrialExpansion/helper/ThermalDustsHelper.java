package brazillianforgers.mods.IndustrialExpansion.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static net.minecraftforge.oredict.OreDictionary.itemMatches;

import java.util.ArrayList;

public class ThermalDustsHelper {
    public static final int coalMeta = 2;
    public static Item dustItem;
    
    
    public static void init()
    {
        dustItem = GameRegistry.findItem("ThermalFoundation", "material");
    }
}

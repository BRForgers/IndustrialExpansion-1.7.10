package brazillianforgers.mods.IndustrialExpansion.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static net.minecraftforge.oredict.OreDictionary.itemMatches;

import java.util.ArrayList;

public class dustCoalHelper {

    public static ItemStack dustCoal;
    
    public static void init()
    {
        Item dustItem = GameRegistry.findItem("ThermalFoundation", "material");
        dustCoal = new ItemStack(dustItem, 1, 2);
    }
}

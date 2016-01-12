package brazillianforgers.mods.IndustrialExpansion.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmelterRecipeManager {
    public static void init(){
        // Note not only Block -> Blocks but stoneBrick -> stonebrick
        GameRegistry.addSmelting(ItemManager.CoalBall, new ItemStack(ItemManager.BurnedCoalBall), 0.1f);
        GameRegistry.addSmelting(ItemManager.CoalChunk, new ItemStack(Items.diamond), 0.1f);
    }

}

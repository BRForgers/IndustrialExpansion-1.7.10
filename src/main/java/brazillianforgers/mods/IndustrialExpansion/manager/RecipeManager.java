package brazillianforgers.mods.IndustrialExpansion.manager;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.helper.ConfigHandler;
import brazillianforgers.mods.IndustrialExpansion.items.MultiToolBase;
import brazillianforgers.mods.IndustrialExpansion.manager.ItemManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import brazillianforgers.mods.IndustrialExpansion.helper.ThermalExpansionHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeManager {
    public static void init() {
        //Base: addInductionSmelterRecipe(CustoDeEnergia, Input1, Input2, Output1);
        //Um Input/Output seria algo tipo: new ItemStack(ItemManager.NomeDoItem, quantidade)
        ThermalExpansionHelper.addSmelterRecipe(ConfigHandler.energyCoalBall, ThermalExpansionHelper.getDustItem(ThermalExpansionHelper.coalDustMeta, 8), new ItemStack(Items.flint), new ItemStack(ItemManager.CoalBall));
        ThermalExpansionHelper.addSmelterRecipe(ConfigHandler.energyCoalChunk, new ItemStack(ItemManager.BurnedCoalBall, 8), new ItemStack(Blocks.obsidian), new ItemStack(ItemManager.CoalChunk));
        ThermalExpansionHelper.addFurnaceRecipe(ConfigHandler.energyBurnedCoalBall, new ItemStack(ItemManager.CoalBall),new ItemStack(ItemManager.BurnedCoalBall));
        ThermalExpansionHelper.addFurnaceRecipe(ConfigHandler.energyDiamond,new ItemStack(ItemManager.CoalChunk),new ItemStack(Items.diamond));
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.MultiToolBase,1),
                                        " A ","BCD","EFG",
                                        'A',new ItemStack(Items.diamond_sword),
                                        'B',new ItemStack(Items.diamond_pickaxe),
                                        'C',new ItemStack(Items.diamond),
                                        'D',new ItemStack(Items.diamond_shovel),
                                        'E',new ItemStack(Items.diamond_axe),
                                        'F',new ItemStack(Items.ender_pearl),
                                        'G',new ItemStack(Items.diamond_hoe));
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase),new ItemStack(ItemManager.MultiToolBase2),new FluidStack(FluidRegistry.getFluid("ender"), 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase2),new ItemStack(ItemManager.MultiToolBase3),new FluidStack(FluidRegistry.getFluid("ender"), 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase3),new ItemStack(ItemManager.MultiToolBase4),new FluidStack(FluidRegistry.getFluid("ender"), 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase4),new ItemStack(ItemManager.MultiTool),new FluidStack(FluidRegistry.getFluid("ender"), 250), false);
    }
}
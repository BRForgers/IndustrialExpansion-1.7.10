package cf.brforgers.mods.IndustrialExpansion.manager;

import cf.brforgers.mods.IndustrialExpansion.helper.ConfigHandler;
import cofh.api.modhelpers.ThermalExpansionHelper;
import cofh.thermalexpansion.block.TEBlocks;
import cofh.thermalexpansion.item.TEItems;
import cofh.thermalfoundation.fluid.TFFluids;
import cofh.thermalfoundation.item.TFItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeManager {
    private static final String TE = "ThermalExpansion";
    private static final String TF = "ThermalFoundation";
    public static void init() {
        //Base: addInductionSmelterRecipe(CustoDeEnergia, Input1, Input2, Output1);
        //Um Input/Output seria algo tipo: new ItemStack(ItemManager.NomeDoItem, quantidade)
        ThermalExpansionHelper.addSmelterRecipe(ConfigHandler.energyCoalBall, TFItems.dustCoal.copy(), new ItemStack(Items.flint), new ItemStack(ItemManager.CoalBall));
        ThermalExpansionHelper.addSmelterRecipe(ConfigHandler.energyCoalChunk, new ItemStack(ItemManager.BurnedCoalBall, 8), new ItemStack(Blocks.obsidian), new ItemStack(ItemManager.CoalChunk));
        ThermalExpansionHelper.addFurnaceRecipe(ConfigHandler.energyBurnedCoalBall, new ItemStack(ItemManager.CoalBall),new ItemStack(ItemManager.BurnedCoalBall));
        ThermalExpansionHelper.addFurnaceRecipe(ConfigHandler.energyDiamond,new ItemStack(ItemManager.CoalChunk),new ItemStack(Items.diamond));
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.MultiToolBase,1),
                                        " A ","BCD","EFG",
                                        'A',Items.diamond_sword,
                                        'B',Items.diamond_pickaxe,
                                        'C',Items.diamond,
                                        'D',Items.diamond_shovel,
                                        'E',Items.diamond_axe,
                                        'F',Items.ender_pearl,
                                        'G',Items.diamond_hoe);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase),new ItemStack(ItemManager.MultiToolBase2),new FluidStack(TFFluids.fluidEnder, 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase2),new ItemStack(ItemManager.MultiToolBase3),new FluidStack(TFFluids.fluidEnder, 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase3),new ItemStack(ItemManager.MultiToolBase4),new FluidStack(TFFluids.fluidEnder, 250), false);
        ThermalExpansionHelper.addTransposerFill(ConfigHandler.energyMultiToolBases,new ItemStack(ItemManager.MultiToolBase4),new ItemStack(ItemManager.MultiTool),new FluidStack(TFFluids.fluidEnder, 250), false);
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemHelmetQuantum,1),
                                        " A ","BCB","DED",
                                        'A', Items.diamond_helmet,
                                        'B', ItemManager.Iridium,
                                        'C', TEItems.capacitorResonant.copy(),
                                        'D', TFItems.gearLumium.copy(),
                                        'E', new ItemStack(TEBlocks.blockGlass,1,0));
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemPlateQuantum,1),
                                        "ABA","CDC","CAC",
                                        'A', TFItems.ingotEnderium.copy(),
                                        'B', Items.diamond_chestplate,
                                        'C', ItemManager.Iridium,
                                        'D', TEItems.capacitorResonant.copy());
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemLegsQuantum,1),
                                        "ABA","CDC","E E",
                                        'A', new ItemStack(TEBlocks.blockFrame,1,0),
                                        'B', TEItems.capacitorResonant.copy(),
                                        'C', ItemManager.Iridium,
                                        'D', Items.diamond_leggings,
                                        'E', new ItemStack(TEBlocks.blockLight,1,0));
        GameRegistry.addShapedRecipe(new ItemStack(ItemManager.itemBootsQuantum,1),
                                        "ABA","CDC","   ",
                                        'A', ItemManager.Iridium,
                                        'B', Items.diamond_boots,
                                        'C', GameRegistry.findItemStack(TF,"armor.bootsTin",1),
                                        'D', TEItems.capacitorResonant.copy());

    }
}
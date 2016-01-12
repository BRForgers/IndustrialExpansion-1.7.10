package brazillianforgers.mods.IndustrialExpansion.manager;

import brazillianforgers.mods.IndustrialExpansion.IndustrialExpansion;
import brazillianforgers.mods.IndustrialExpansion.helper.ConfigHandler;
import brazillianforgers.mods.IndustrialExpansion.manager.ItemManager;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import brazillianforgers.mods.IndustrialExpansion.helper.ThermalDustsHelper;

public class RecipeManager {
    public static void init() {
        //Base: addInductionSmelterRecipe(CustoDeEnergia, Input1, Input2, Output1);
        //Um Input/Output seria algo tipo: new ItemStack(ItemManager.NomeDoItem, quantidade)
        addInductionSmelterRecipe(ConfigHandler.energyCoalBall, new ItemStack(ThermalDustsHelper.dustItem, 8, 2), new ItemStack(Items.flint), new ItemStack(ItemManager.CoalBall));
        addInductionSmelterRecipe(ConfigHandler.energyCoalChunk, new ItemStack(ItemManager.BurnedCoalBall, 8), new ItemStack(Blocks.obsidian), new ItemStack(ItemManager.CoalChunk));
    }

    public static void addInductionSmelterRecipe(int energyCost, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput)
    {
        NBTTagCompound recipeToSend = new NBTTagCompound();

        recipeToSend.setInteger("energy", energyCost);
        recipeToSend.setTag("primaryInput", new NBTTagCompound());
        recipeToSend.setTag("secondaryInput", new NBTTagCompound());
        recipeToSend.setTag("primaryOutput", new NBTTagCompound());

        primaryInput.writeToNBT(recipeToSend.getCompoundTag("primaryInput"));
        secondaryInput.writeToNBT(recipeToSend.getCompoundTag("secondaryInput"));
        primaryOutput.writeToNBT(recipeToSend.getCompoundTag("primaryOutput"));

        //Esse é o Comando que Envia coisas pro Thermal. Tem vários exemplos desse pelos repositórios do CoFH
        FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", recipeToSend);
    }
}
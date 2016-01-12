package brazillianforgers.mods.IndustrialExpansion.manager;

import brazillianforgers.mods.IndustrialExpansion.helper.ConfigHandler;
import brazillianforgers.mods.IndustrialExpansion.items.*;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cofh.api.item.

public class RecipeManager {
    public static void init() {
        addSmelterRecipe(ConfigHandler.energyCoalBall, new ItemStack(Items.coal), new ItemStack(Items.flint), MetaItemGetter.conductiveIron);
        addSmelterRecipe(ConfigHandler.energyPhasedIron, new ItemStack(Items.iron_ingot), new ItemStack(Items.ender_pearl), MetaItemGetter.phasedIron);
    }

    public static void addSmelterRecipe(int paramInt, ItemStack paramItemStack1, ItemStack paramItemStack2, ItemStack paramItemStack3)
    {
        NBTTagCompound toSend = new NBTTagCompound();

        toSend.setInteger("energy", paramInt);
        toSend.setTag("primaryInput", new NBTTagCompound());
        toSend.setTag("secondaryInput", new NBTTagCompound());
        toSend.setTag("primaryOutput", new NBTTagCompound());

        paramItemStack1.writeToNBT(toSend.getCompoundTag("primaryInput"));
        paramItemStack2.writeToNBT(toSend.getCompoundTag("secondaryInput"));
        paramItemStack3.writeToNBT(toSend.getCompoundTag("primaryOutput"));

        FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", toSend);
    }
}

package cf.brforgers.mods.IndustrialExpansion.manager;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.items.QuantumArmor;
import cf.brforgers.mods.IndustrialExpansion.Lib;
import cf.brforgers.mods.IndustrialExpansion.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemManager
{
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_QUANTUM = EnumHelper.addArmorMaterial("IE:QUANTUM", 100, new int[] { 3, 8, 6, 3 }, 20);
    public static final String[] TEXTURE_QUANTUM = { "industrialexpansion:textures/armor/" + "Quantum_1.png", "industrialexpansion:textures/armor/" + "Quantum_2.png" };
    //Item List

    //BASE: public static Item NomeDoItem = new ClasseDoItem();
    public static Item.ToolMaterial TEST = EnumHelper.addToolMaterial("TEST", 3, -1, 40.0F, 98.0F, 30);
    public static Item.ToolMaterial MULTITOOL = EnumHelper.addToolMaterial("MULTITOOL",3, 5000, 18.0F, 12.0F, 30);
    public static Item TestItem = new TestItem(TEST);
    public static Item CoalBall = new CoalBall();
    public static Item BurnedCoalBall = new BurnedCoalBall();
    public static Item CoalChunk = new CoalChunk();
    public static Item MultiTool = new MultiTool(MULTITOOL);
    public static Item MultiToolBase = new MultiToolBase();
    public static Item MultiToolBase2 = new MultiToolBase2();
    public static Item MultiToolBase3 = new MultiToolBase3();
    public static Item MultiToolBase4 = new MultiToolBase4();
    public static Item itemHelmetQuantum = (QuantumArmor) new QuantumArmor(ARMOR_MATERIAL_QUANTUM, 0).setEnergyParams(20000000, 32000).setArmorTextures(TEXTURE_QUANTUM)
            .setUnlocalizedName("quantumHelmet").setTextureName(Lib.RESOURCE_PATH +  "QHelmet").setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    public static Item itemPlateQuantum = (QuantumArmor) new QuantumArmor(ARMOR_MATERIAL_QUANTUM, 1).setEnergyParams(20000000, 32000).setArmorTextures(TEXTURE_QUANTUM)
    .setUnlocalizedName("quantumPlate").setTextureName(Lib.RESOURCE_PATH +  "QChestplate").setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    public static Item itemLegsQuantum = (QuantumArmor) new QuantumArmor(ARMOR_MATERIAL_QUANTUM, 2).setEnergyParams(20000000, 32000).setArmorTextures(TEXTURE_QUANTUM)
    .setUnlocalizedName("quantumLegs").setTextureName(Lib.RESOURCE_PATH +  "QLegs").setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    public static Item itemBootsQuantum = (QuantumArmor) new QuantumArmor(ARMOR_MATERIAL_QUANTUM, 3).setEnergyParams(20000000, 32000).setArmorTextures(TEXTURE_QUANTUM)
    .setUnlocalizedName("quantumBoots").setTextureName(Lib.RESOURCE_PATH +  "QBoots").setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
    public static Item Iridium = new Iridium();


    //Init Method
    public static final void init()
    {
        //BASE: GameRegistry.registerItem(NomeDoItem, "NomeDoItem");
        GameRegistry.registerItem(TestItem, "Test");
        GameRegistry.registerItem(CoalBall,"CoalBall");
        GameRegistry.registerItem(BurnedCoalBall,"BurnedCoalBall");
        GameRegistry.registerItem(CoalChunk,"CoalChunk");
        GameRegistry.registerItem(MultiTool,"MultiTool");
        GameRegistry.registerItem(MultiToolBase,"MultiToolBase");
        GameRegistry.registerItem(MultiToolBase2,"MultiToolBase2");
        GameRegistry.registerItem(MultiToolBase3,"MultiToolBase3");
        GameRegistry.registerItem(MultiToolBase4,"MultiToolBase4");
        GameRegistry.registerItem(itemHelmetQuantum, "armor.helmetQuantum");
        GameRegistry.registerItem(itemPlateQuantum, "armor.plateQuantum");
        GameRegistry.registerItem(itemLegsQuantum, "armor.legsQuantum");
        GameRegistry.registerItem(itemBootsQuantum, "armor.bootsQuantum");
        GameRegistry.registerItem(Iridium, "Iridium");
    }
}

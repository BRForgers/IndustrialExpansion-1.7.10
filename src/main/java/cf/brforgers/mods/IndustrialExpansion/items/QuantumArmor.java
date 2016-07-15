package cf.brforgers.mods.IndustrialExpansion.items;

import cf.brforgers.mods.IndustrialExpansion.manager.ItemManager;
import cofh.api.energy.IEnergyContainerItem;
import cofh.core.item.ItemArmorAdv;
import cofh.lib.util.helpers.EnergyHelper;
import cofh.lib.util.helpers.MathHelper;
import cofh.lib.util.helpers.StringHelper;
import cf.brforgers.mods.IndustrialExpansion.helper.DurabillityHelper;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.potion.Potion;

public class QuantumArmor  extends ItemArmorAdv implements ISpecialArmor, IEnergyContainerItem {

    public static final ArmorProperties QUANTUM = new ArmorProperties(0, 0.20D, Integer.MAX_VALUE);

    public int maxEnergy = 20000000;
    public int maxTransfer = 32000;

    public double absorbRatio = 1.0E7D; //0.9D
    public int energyPerDamage = 20000;

    public String[] textures = new String[2];

    public QuantumArmor(ArmorMaterial material, int type) {

        super(material, type);
    }

    public QuantumArmor setEnergyParams(int maxEnergy, int maxTransfer) {

        this.maxEnergy = maxEnergy;
        this.maxTransfer = maxTransfer;

        return this;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {

        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.uncommon;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {

        if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
            list.add(StringHelper.shiftForDetails());
        }
        if (!StringHelper.isShiftKeyDown()) {
            return;
        }
        if (stack.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        list.add(StringHelper.localize("info.cofh.charge") + ": " + stack.stackTagCompound.getInteger("Energy") + " / " + maxEnergy + " RF");
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {

        super.setDamage(stack, 0);
    }

    @Override
    public int getDisplayDamage(ItemStack stack) {

        if (stack.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(stack, 0);
        }
        return maxEnergy - stack.stackTagCompound.getInteger("Energy");
    }

    @Override
    public int getMaxDamage(ItemStack stack) {

        return maxEnergy;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {

        return !DurabillityHelper.showArmorCharge ? false : stack.stackTagCompound == null || !stack.stackTagCompound.getBoolean("CreativeTab");
    }

    @Override
    public boolean isDamaged(ItemStack stack) {

        return true;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {

        list.add(EnergyHelper.setDefaultEnergyTag(new ItemStack(item, 1, 0), 0));
        list.add(EnergyHelper.setDefaultEnergyTag(new ItemStack(item, 1, 0), maxEnergy));
    }

    protected int getBaseAbsorption() {

        return 20;
    }

    /**
     * Returns a % that each piece absorbs, set sums to 100.
     */
    protected int getAbsorptionRatio() {

        switch (armorType) {
            case 0:
                return 15;
            case 1:
                return 40;
            case 2:
                return 30;
            case 3:
                return 15;
        }
        return 0;
    }

    protected int getEnergyPerDamage(ItemStack stack) {

        int unbreakingLevel = MathHelper.clamp(EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack), 0, 4);
        return energyPerDamage * (5 - unbreakingLevel) / 5;
    }

    /* ISpecialArmor */
    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {

        if (source.damageType.equals("quantum")) {
            return QUANTUM;
        } else if (source.isUnblockable()) {
            int absorbMax = getEnergyPerDamage(armor) > 0 ? 25 * getEnergyStored(armor) / getEnergyPerDamage(armor) : 0;
            return new ArmorProperties(0, absorbRatio * getArmorMaterial().getDamageReductionAmount(armorType) * 0.025, absorbMax);
        }
        int absorbMax = getEnergyPerDamage(armor) > 0 ? 25 * getEnergyStored(armor) / getEnergyPerDamage(armor) : 0;
        return new ArmorProperties(0, absorbRatio * getArmorMaterial().getDamageReductionAmount(armorType) * 0.05, absorbMax);
        // 0.05 = 1 / 20 (max armor)
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {

        if (getEnergyStored(armor) >= getEnergyPerDamage(armor)) {
            return Math.min(getBaseAbsorption(), 20) * getAbsorptionRatio() / 100;
        }
        return 0;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        if(world.isRemote) return;
        if (getEnergyStored(armor) >= getEnergyPerDamage(armor)) {
            if (armor.getItem() == ItemManager.itemLegsQuantum) {
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 260, 4, true));
            }
            if (armor.getItem() == ItemManager.itemPlateQuantum) {
                player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 260, 4, true));
            }
            if (armor.getItem() == ItemManager.itemHelmetQuantum) {
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 260, 0, true));
            }
        }
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack armor, DamageSource source, int damage, int slot) {

        if (source.damageType.equals("quantum")) {
            boolean p = source.getEntity() == null;
            receiveEnergy(armor, damage * (p ? energyPerDamage / 2 : getEnergyPerDamage(armor)), false);
        } else {
            extractEnergy(armor, damage * getEnergyPerDamage(armor), false);
        }
    }

    /* IEnergyContainerItem */
    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("Energy");
        int receive = Math.min(maxReceive, Math.min(maxEnergy - stored, maxTransfer));

        if (!simulate) {
            stored += receive;
            container.stackTagCompound.setInteger("Energy", stored);
        }
        return receive;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        int stored = container.stackTagCompound.getInteger("Energy");
        int extract = Math.min(maxExtract, stored);

        if (!simulate) {
            stored -= extract;
            container.stackTagCompound.setInteger("Energy", stored);
        }
        return extract;
    }

    @Override
    public int getEnergyStored(ItemStack container) {

        if (container.stackTagCompound == null) {
            EnergyHelper.setDefaultEnergyTag(container, 0);
        }
        return container.stackTagCompound.getInteger("Energy");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {

        return maxEnergy;
    }
}

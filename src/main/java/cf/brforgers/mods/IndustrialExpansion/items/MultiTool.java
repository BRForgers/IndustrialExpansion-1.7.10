package cf.brforgers.mods.IndustrialExpansion.items;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import cf.brforgers.mods.IndustrialExpansion.IndustrialExpansion;
import cf.brforgers.mods.IndustrialExpansion.Lib;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import com.google.common.collect.ImmutableSet;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class MultiTool extends ItemPickaxe {
    private Item pickaxe, axe, shovel;

    private class InternalMultiToolPickaxe extends ItemPickaxe {public InternalMultiToolPickaxe(ToolMaterial material) {super(material);}}
    private class InternalMultiToolShovel extends ItemSpade {public InternalMultiToolShovel(ToolMaterial material) {super(material);}}
    private class InternalMultiToolAxe extends ItemAxe {public InternalMultiToolAxe(ToolMaterial material) {super(material);}}

    public MultiTool(ToolMaterial material) {
        super (material);
        pickaxe = new InternalMultiToolPickaxe(material);
        shovel = new InternalMultiToolShovel(material);
        axe = new InternalMultiToolAxe(material);
        this.setCreativeTab(IndustrialExpansion.tabIndustrialExpansion);
        this.setUnlocalizedName("MultiTool");
        this.setTextureName(Lib.RESOURCE_PATH + "MultiTool");
    }

    @Override
    public boolean func_150897_b(Block block) {
        return pickaxe.func_150897_b(block) || axe.func_150897_b(block) || shovel.func_150897_b(block);
    }

    @Override
    public float func_150893_a(ItemStack stack, Block block) {
        //Maior, mais rápido
        return Collections.max(
                Arrays.asList(
                        new Float[]{
                                Float.valueOf(pickaxe.func_150893_a(stack, block)),
                                Float.valueOf(axe.func_150893_a(stack, block)),
                                Float.valueOf(shovel.func_150893_a(stack, block))
                        }
                )
        ).floatValue();
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe", "spade");
    }

    @Override

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        //Kibado do ItemHoe
        if (!player.canPlayerEdit(x, y, z, side, stack)) {
            return false;
        } else {
            UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return false;
            }

            if (event.getResult() == Result.ALLOW) {
                stack.damageItem(1, player);
                return true;
            }

            Block block = world.getBlock(x, y, z);

            if (side != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt)) {
                Block block1 = Blocks.farmland;
                world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (world.isRemote) {
                    return true;
                }
                else {
                    world.setBlock(x, y, z, block1);
                    stack.damageItem(1, player);
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}


package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.component.ModDataComponentTypes;
import net.lowis.tutorialmod.particle.ModParticles;
import net.lowis.tutorialmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.particle.BlockDustParticle;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.PositionSource;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;

public class GoldTransmuterItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.of(

            Blocks.COAL_BLOCK, Blocks.GOLD_BLOCK,
            Blocks.COAL_ORE, Blocks.GOLD_ORE,
            Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_GOLD_ORE
    );


    public GoldTransmuterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(!world.isClient()) {

            ((ServerWorld) world).spawnParticles(ParticleTypes.ASH,
                    context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 0.5, context.getBlockPos().getZ() + 0.5,
                    1024, 0.5, 0.5, 0.5, 0);

        ((ServerWorld) world).spawnParticles(ModParticles.MAGIC_CIRCLE_PARTICLE,
                    context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 0.5, context.getBlockPos().getZ() + 0.5,
                    10, 0.5, 0.5, 0.5, 0);

            if(CHISEL_MAP.containsKey(clickedBlock)) {
                        //needs to be on a server to work, that's "!world.isClient"

                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());     //change the block

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));


                world.playSound(null, context.getBlockPos(), ModSounds.TRANSMUTATOR_USE, SoundCategory.BLOCKS);

                ((ServerWorld) world).spawnParticles(ParticleTypes.ASH,
                        context.getBlockPos().getX() + 0.5, context.getBlockPos().getY() + 0.5, context.getBlockPos().getZ() + 0.5,
                        1024, 0.5, 0.5, 0.5, 0);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());

            }
        }


        return ActionResult.SUCCESS;
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.gold_transmuter.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.tutorialmod.gold_transmuter"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {

            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }


}

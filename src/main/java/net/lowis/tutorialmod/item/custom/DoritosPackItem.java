package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class DoritosPackItem extends Item {


    public DoritosPackItem(Settings settings) {
        super(settings);
    }




    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.giveItemStack(ModItems.DORITOS.getDefaultStack());

        user.getStackInHand(hand).damage(1, user, user.getSlotForHand(hand));           // CIT FISHING ROD. THX



        return super.use(world, user, hand);
    }




    /*
    @Override
    onStackClicked

    QUESTO SUCCEDE QUANDO CLICCHI SULL'ITEM NELL'INVENTARIO
 */






}

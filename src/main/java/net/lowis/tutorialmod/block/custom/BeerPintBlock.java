package net.lowis.tutorialmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BeerPintBlock extends HorizontalFacingBlock {

    private static final VoxelShape SHAPE =
            Block.createCuboidShape(3, 3, 0, 13, 11, 13);
    public static final MapCodec<BeerPintBlock> CODEC = createCodec(BeerPintBlock::new);
    public BeerPintBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
            player.setStackInHand(Hand.MAIN_HAND, ModItems.BEER_PINT.getDefaultStack());
            world.removeBlock(pos, false);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}

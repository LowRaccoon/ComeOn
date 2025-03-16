package net.lowis.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class UraniumLampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");




    public UraniumLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CLICKED, false));
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient) {
            world.setBlockState(pos, state.cycle(CLICKED));
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int l = 0; l < 14; ++l) {
            mutable.set(i + MathHelper.nextInt(random, -5, 5), j + MathHelper.nextInt(random, -5, 5), k + MathHelper.nextInt(random, -5, 5));
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.isFullCube(world, mutable)) {
                world.addParticle(ParticleTypes.FALLING_WATER, (double)mutable.getX() + random.nextDouble(), (double)mutable.getY() + random.nextDouble(), (double)mutable.getZ() + random.nextDouble(), 0.0 , 0.0, 0.0);
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}

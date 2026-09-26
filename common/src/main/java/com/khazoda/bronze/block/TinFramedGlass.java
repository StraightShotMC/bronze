package com.khazoda.bronze.block;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class TinFramedGlass extends TransparentBlock {
  public TinFramedGlass(ResourceKey<Block> id) {
    super(Properties.of().noOcclusion()
        .instrument(NoteBlockInstrument.HAT)
        .strength(0.7F)
        .sound(SoundType.GLASS)
        .isValidSpawn((_, _, _, _) -> false)
        .isRedstoneConductor((_, _, _) -> false)
        .isSuffocating((_, _, _) -> false)
        .isViewBlocking((_,_,_,_) -> false)
        .setId(id));
  }
}

package com.khazoda.bronze.datagen;

import com.khazoda.bronze.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class BronzeModBlockLootTableProvider extends FabricBlockLootSubProvider {
  protected BronzeModBlockLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  public void generate() {
    dropSelf(MainRegistry.BRONZE_BLEND_BLOCK.get());
    dropSelf(MainRegistry.BRONZE_BLOCK.get());
    dropSelf(MainRegistry.BRONZE_TRAPDOOR.get());
    dropSelf(MainRegistry.CHISELED_TIN.get());
    dropSelf(MainRegistry.CUT_TIN.get());
    dropSelf(MainRegistry.CUT_TIN_STAIRS.get());
    dropSelf(MainRegistry.RAW_TIN_BLOCK.get());
    dropSelf(MainRegistry.TIN_BLOCK.get());
    dropSelf(MainRegistry.TIN_TILES.get());

    add(MainRegistry.BRONZE_DOOR.get(), createDoorTable(MainRegistry.BRONZE_DOOR.get()));
    add(MainRegistry.CUT_TIN_SLAB.get(), createSlabItemTable(MainRegistry.CUT_TIN_SLAB.get()));
    dropWhenSilkTouch(MainRegistry.TIN_FRAMED_GLASS.get());
    add(MainRegistry.TIN_ORE.get(), createOreDrop(MainRegistry.TIN_ORE.get(), MainRegistry.RAW_TIN.get()));
    add(MainRegistry.DEEPSLATE_TIN_ORE.get(), createOreDrop(MainRegistry.DEEPSLATE_TIN_ORE.get(), MainRegistry.RAW_TIN.get()));
  }
}

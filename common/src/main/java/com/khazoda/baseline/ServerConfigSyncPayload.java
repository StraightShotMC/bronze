package com.khazoda.baseline;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public record ServerConfigSyncPayload(KhazConfigSync sync, Map<String, String> serverValues) implements CustomPacketPayload {
  public ServerConfigSyncPayload {
    sync = Objects.requireNonNull(sync, "sync");
    serverValues = Collections.unmodifiableMap(new LinkedHashMap<>(serverValues));
  }

  private static StreamCodec<RegistryFriendlyByteBuf, ServerConfigSyncPayload> codec(KhazConfigSync sync) {
    return ByteBufCodecs.<RegistryFriendlyByteBuf, String, String, Map<String, String>>map(LinkedHashMap::new, ByteBufCodecs.STRING_UTF8, ByteBufCodecs.STRING_UTF8).map(
            m -> new ServerConfigSyncPayload(sync, m),
            ServerConfigSyncPayload::serverValues
    );
  }

  static ServerConfigSyncPayload read(KhazConfigSync sync, RegistryFriendlyByteBuf buffer) {
    return codec(sync).decode(buffer);
  }

  void write(RegistryFriendlyByteBuf buffer) {
    codec(sync).encode(buffer, this);
  }

  @Override
  public Type<? extends CustomPacketPayload> type() {
    return sync.type();
  }
}

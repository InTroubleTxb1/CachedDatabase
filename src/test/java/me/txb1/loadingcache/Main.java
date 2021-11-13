package me.txb1.loadingcache;

import dev.steerup.cacheddatabase.LoadingCache;

import java.util.UUID;

public class Main {

    private static final LoadingCache<String, UUID> nameUUIDLoadingCache = new LoadingCache<>() {
        @Override
        public UUID load(String s) {
            return UUID.randomUUID();
        }
    };

    public static void main(String[] args) {

    }
}
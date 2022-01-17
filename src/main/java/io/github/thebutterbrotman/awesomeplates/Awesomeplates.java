package io.github.thebutterbrotman.awesomeplates;

import io.github.thebutterbrotman.awesomeplates.Mod.Items;
import net.fabricmc.api.ModInitializer;

public class Awesomeplates implements ModInitializer {

    public static String MOD_ID = "awesomeplates";

    @Override
    public void onInitialize() {
        Items.registerItems();
    }
}

package me.petterim1.bossbartext;

import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

public class Main extends PluginBase implements Listener {

    private String text;
    private int length;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.text = this.getConfig().getString("text").replace("%n", "\n");
        this.length = this.getConfig().getInt("length", 100);
    }

    @EventHandler
    public void onJoin(PlayerLocallyInitializedEvent e) {
        e.getPlayer().createBossBar(this.text, this.length);
    }
}

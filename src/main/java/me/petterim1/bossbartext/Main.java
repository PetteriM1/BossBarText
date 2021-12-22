package me.petterim1.bossbartext;

import cn.nukkit.event.player.PlayerLocallyInitializedEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.utils.BossBarColor;
import cn.nukkit.utils.DummyBossBar;

public class Main extends PluginBase implements Listener {

    private String text;
    private int length;
    private BossBarColor color;

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.text = this.getConfig().getString("text").replace("%n", "\n");
        this.length = this.getConfig().getInt("length", 100);
        try {
            this.color = BossBarColor.valueOf(this.getConfig().getString("color"));
        } catch (IllegalArgumentException ignore) {
        }
    }

    @EventHandler
    public void onJoin(PlayerLocallyInitializedEvent e) {
        DummyBossBar.Builder builder = new DummyBossBar.Builder(e.getPlayer());
        if (color != null) {
            builder.color(color);
        }
        e.getPlayer().createBossBar(builder.text(text).length((float) length).build());
    }
}

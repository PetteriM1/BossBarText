package idk.plugin.bossbartext;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class BossBarText extends PluginBase implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String text = this.getConfig().getString("text").replace("§", "\u00A7").replace("%n", "\n");
        int length = this.getConfig().getInt("length", 100);
        p.createBossBar(text, length);
    }
}

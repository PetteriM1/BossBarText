package idk.plugin.bossbartext;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.utils.DummyBossBar;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class BossBarText extends PluginBase implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getLogger().info(TextFormat.GREEN + "BossBarText enabled!");
        this.saveDefaultConfig();
        this.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
	      String text = "\u00A7l" + this.getConfig().getString("text");
        p.createBossBar(text, 100);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.RED + "BossBarText disabled!");
    }
}

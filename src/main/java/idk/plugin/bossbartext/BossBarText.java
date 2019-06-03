package idk.plugin.bossbartext;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class BossBarText extends PluginBase implements Listener {

    private List<String> players = new ArrayList<>();

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.getConfig();
    }

    @EventHandler
    public void onJoin(DataPacketReceiveEvent e) {
        if (e.getPacket() instanceof SetLocalPlayerAsInitializedPacket) {
            Player p = e.getPlayer();
            if (!players.contains(p.getName())) {
                players.add(p.getName());
                p.createBossBar(this.getConfig().getString("text").replace("%n", "\n"), this.getConfig().getInt("length", 100));
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        players.remove(e.getPlayer().getName());
    }
}

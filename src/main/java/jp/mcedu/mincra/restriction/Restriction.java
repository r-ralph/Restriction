/*
 * Copyright 2015 TENTO, Mincra, Ralph
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.mcedu.mincra.restriction;

import jp.mcedu.mincra.restriction.listener.RestrictionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Restriction extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new RestrictionListener(), this);
        startKeepDay();
        getLogger().info("Enabled plugin successfully.");
    }

    private void startKeepDay() {
        getLogger().info("Scheduled task to keep day in world.");
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.getWorld("world").setTime(8000), 0L, 600L);
    }
}

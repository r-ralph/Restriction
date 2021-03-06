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

package jp.mcedu.mincra.restriction.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class RestrictionListener implements Listener {
    /**
     * Redstone信号を無効化
     */
    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        switch (event.getBlock().getType()) {
            case REDSTONE_TORCH_OFF:
            case REDSTONE_TORCH_ON:
                event.setNewCurrent(1);
                break;
            default:
                event.setNewCurrent(0);
                break;
        }
    }

    /**
     * 天気の変化をなくす(晴れのみに)
     */
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

    /**
     * ピストンのイベントを無効化
     */
    @EventHandler
    public void onPiston(BlockPistonExtendEvent event) {
        event.setCancelled(true);
    }

    /**
     * 爆発イベントを無効化
     */
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        event.setCancelled(true);
    }

    /**
     * 炎によるブロック消滅を防止
     */
    @EventHandler
    public void onBurn(BlockBurnEvent event) {
        event.setCancelled(true);
    }

    /**
     * 炎の延焼を防止
     */
    @EventHandler
    public void onFireSpread(BlockSpreadEvent event) {
        event.setCancelled(true);
    }

    /**
     * 炎の消滅・氷の融解を防止
     */
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        event.setCancelled(true);
    }
}

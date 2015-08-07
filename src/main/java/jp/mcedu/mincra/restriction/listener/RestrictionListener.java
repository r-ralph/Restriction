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

import net.minecraft.server.v1_8_R3.BlockRedstoneTorch;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class RestrictionListener implements Listener {
    /**
     * Redstone信号を無効化
     */
    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        switch (event.getBlock().getType()){
            case REDSTONE_TORCH_OFF:
            case REDSTONE_TORCH_ON:
                event.setNewCurrent(1);
                break;
            default:
                event.setNewCurrent(0);
                break;
        }
    }
}
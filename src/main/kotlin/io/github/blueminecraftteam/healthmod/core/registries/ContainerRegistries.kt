/*
 * Copyright (c) 2020 Blue Minecraft Team.
 *
 * This file is part of HealthMod.
 *
 * HealthMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HealthMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with HealthMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.blueminecraftteam.healthmod.core.registries

import io.github.blueminecraftteam.healthmod.common.container.BandageBoxContainer
import io.github.blueminecraftteam.healthmod.core.HealthMod
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.container.ContainerType
import net.minecraft.network.PacketBuffer
import net.minecraftforge.common.extensions.IForgeContainerType
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ContainerRegistries {
    val CONTAINERS = KDeferredRegister(ForgeRegistries.CONTAINERS, HealthMod.MOD_ID)

    val BANDAGE_BOX: ContainerType<BandageBoxContainer> by CONTAINERS.register(
            "bandage_box"
    ) {
        IForgeContainerType.create { windowId: Int, playerInventory: PlayerInventory, data: PacketBuffer ->
            BandageBoxContainer(windowId, playerInventory, data)
        }
    }


}
/*
 * Copyright (c) 2021 Team Blue.
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

package io.github.teambluemods.healthmod.core.registries

import io.github.teambluemods.healthmod.common.container.BandageBoxContainer
import io.github.teambluemods.healthmod.core.HealthMod
import net.minecraft.inventory.container.ContainerType
import net.minecraftforge.common.extensions.IForgeContainerType
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ContainerTypeRegistries {
    val CONTAINER_TYPES = KDeferredRegister(ForgeRegistries.CONTAINERS, HealthMod.MOD_ID)

    val BANDAGE_BOX: ContainerType<BandageBoxContainer> by CONTAINER_TYPES.registerObject("bandage_box") {
        IForgeContainerType.create(::BandageBoxContainer)
    }
}
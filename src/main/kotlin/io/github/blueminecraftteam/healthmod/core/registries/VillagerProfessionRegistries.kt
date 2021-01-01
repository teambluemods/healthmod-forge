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

import com.google.common.collect.ImmutableSet
import io.github.blueminecraftteam.healthmod.core.HealthMod
import net.minecraft.block.BlockState
import net.minecraft.entity.merchant.villager.VillagerProfession
import net.minecraft.util.SoundEvents
import net.minecraft.village.PointOfInterestType
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import java.util.*

// dont work maybe cus no trades? -ag6
object VillagerProfessionRegistries {
    val PROFESSIONS = KDeferredRegister(ForgeRegistries.PROFESSIONS, HealthMod.MOD_ID)
    val POI_TYPES = KDeferredRegister(ForgeRegistries.POI_TYPES, HealthMod.MOD_ID)

    private val DOCTOR_POINT_OF_INTEREST_STATES: MutableSet<BlockState> = HashSet()

    val DOCTOR_POINT_OF_INTEREST by POI_TYPES.register(
            "doctor_point_of_interest"
    ) {
        PointOfInterestType(
                "doctor_point_of_interest",
                ImmutableSet.copyOf(DOCTOR_POINT_OF_INTEREST_STATES),
                1,
                1
        )
    }

    val DOCTOR by PROFESSIONS.register(
            "doctor"
    ) {
        VillagerProfession(
                "doctor_point_of_interest",
                DOCTOR_POINT_OF_INTEREST,
                ImmutableSet.of(ItemRegistries.FIRST_AID_KIT),
                ImmutableSet.of(BlockRegistries.BANDAGE_BOX),
                SoundEvents.BLOCK_BREWING_STAND_BREW
        )
    }

    init {
        DOCTOR_POINT_OF_INTEREST_STATES.addAll(PointOfInterestType.getAllStates(BlockRegistries.BANDAGE_BOX))
        DOCTOR_POINT_OF_INTEREST_STATES.addAll(PointOfInterestType.getAllStates(BlockRegistries.BANDAGE_BOX))
    }
}
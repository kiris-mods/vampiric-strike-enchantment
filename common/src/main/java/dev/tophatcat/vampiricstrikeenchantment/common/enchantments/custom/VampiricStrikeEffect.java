/*
 * Absorb the health of you enemies when you attack, become the never dying foe!
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/vampiric-strike-enchantment/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package dev.tophatcat.vampiricstrikeenchantment.common.enchantments.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public record VampiricStrikeEffect(LevelBasedValue healAmount) implements EnchantmentEntityEffect {

    public static final MapCodec<VampiricStrikeEffect> CODEC = RecordCodecBuilder.mapCodec(
        healingEffectInstance -> healingEffectInstance.group(
            LevelBasedValue.CODEC.fieldOf("healAmount").forGetter(VampiricStrikeEffect::healAmount))
            .apply(healingEffectInstance, VampiricStrikeEffect::new));

    @Override
    public void apply(@NotNull ServerLevel level, int enchantmentLevel, @NotNull EnchantedItemInUse context,
                      @NotNull Entity user, @NotNull Vec3 pos) {
        if (user instanceof LivingEntity player) {
            player.heal(healAmount().calculate(enchantmentLevel));
        }
    }

    @NotNull
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}

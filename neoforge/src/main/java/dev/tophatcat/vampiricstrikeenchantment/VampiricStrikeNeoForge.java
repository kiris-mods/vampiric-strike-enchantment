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
package dev.tophatcat.vampiricstrikeenchantment;

import com.mojang.serialization.MapCodec;
import dev.tophatcat.vampiricstrikeenchantment.common.enchantments.VampiricEnchantments;
import dev.tophatcat.vampiricstrikeenchantment.common.enchantments.custom.VampiricStrikeEffect;
import dev.tophatcat.vampiricstrikeenchantment.data.VampiricDataGenerator;
import dev.tophatcat.vampiricstrikeenchantment.data.VampiricLanguageProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(VampiricStrikeCommon.MOD_ID)
public class VampiricStrikeNeoForge {

    public VampiricStrikeNeoForge(IEventBus bus) {
        VampiricStrikeCommon.init();
        DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS
            = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, VampiricStrikeCommon.MOD_ID);
        Supplier<MapCodec<? extends EnchantmentEntityEffect>> VAMPIRIC_STRIKE
            = ENTITY_ENCHANTMENT_EFFECTS.register("vampiric_strike", () -> VampiricStrikeEffect.CODEC);
        ENTITY_ENCHANTMENT_EFFECTS.register(bus);
        bus.addListener(this::gatherData);
    }

    public void gatherData(GatherDataEvent event) {
        RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, VampiricEnchantments::bootstrap);
        var generator = event.getGenerator();
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        var packOutput = event.getGenerator().getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new VampiricLanguageProvider(packOutput));
        generator.addProvider(includeServer, new VampiricDataGenerator(packOutput, lookupProvider, BUILDER));
    }
}

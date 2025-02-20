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
package dev.tophatcat.vampiricstrikeenchantment.data;

import dev.tophatcat.vampiricstrikeenchantment.VampiricStrikeCommon;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class VampiricLanguageProvider extends LanguageProvider {

    public VampiricLanguageProvider(PackOutput output) {
        super(output, VampiricStrikeCommon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("enchantment.vampiricstrikeenchantment.vampiric_strike", "Vampiric Strike");
        add("enchantment.vampiricstrikeenchantment.vampiric_strike.desc",
            "Strike like a vampire and leach some of your foes health with every hit.");
        add("config.vampiricstrikeenchantment.level_one_heal_value", "Level 1 Enchantment heal amount.");
        add("config.vampiricstrikeenchantment.level_two_heal_value", "Level 2 Enchantment heal amount.");
        add("config.vampiricstrikeenchantment.level_three_heal_value", "Level 3 Enchantment heal amount.");
        add("config.vampiricstrikeenchantment.level_four_heal_value", "Level 4 Enchantment heal amount.");
    }
}

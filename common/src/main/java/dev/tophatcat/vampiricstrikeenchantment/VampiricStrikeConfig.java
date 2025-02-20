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

import com.teamresourceful.resourcefulconfig.api.annotations.Config;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption;

@ConfigInfo(
    title = VampiricStrikeCommon.MOD_NAME,
    description = "Absorb the health of you enemies when you attack, become the never dying foe!",
    links = {
        @ConfigInfo.Link(
            value = "https://modrinth.com/mod/vampiric-strike-enchantment",
            icon = "modrinth",
            text = "Modrinth"
        ),
        @ConfigInfo.Link(
            value = "https://curseforge.com/minecraft/mc-mods/vampiric-strike-enchantment",
            icon = "curseforge",
            text = "CurseForge"
        ),
        @ConfigInfo.Link(
            value = "https://github.com/kiris-mods/vampiric-strike-enchantment",
            icon = "github",
            text = "Github"
        ),
        @ConfigInfo.Link(
            value = "https://discord.tophatcat.dev/",
            icon = "message-square",
            text = "Discord"
        )
    }
)
@Config(value = "vampiric_strike_enchantment", version = 1)
public class VampiricStrikeConfig {

    @ConfigOption.Range(min = 1, max = 10)
    @ConfigEntry(id = "levelOneEnchantmentHealValue", translation = "config.vampiricstrikeenchantment.level_one_heal_value")
    public static float levelOneEnchantmentHealValue = 2F;

    @ConfigOption.Range(min = 1, max = 10)
    @ConfigEntry(id = "levelTwoEnchantmentHealValue", translation = "config.vampiricstrikeenchantment.level_two_heal_value")
    public static float levelTwoEnchantmentHealValue = 3F;

    @ConfigOption.Range(min = 1, max = 10)
    @ConfigEntry(id = "levelThreeEnchantmentHealValue", translation = "config.vampiricstrikeenchantment.level_three_heal_value")
    public static float levelThreeEnchantmentHealValue = 4F;

    @ConfigOption.Range(min = 1, max = 10)
    @ConfigEntry(id = "levelFourEnchantmentHealValue", translation = "config.vampiricstrikeenchantment.level_four_heal_value")
    public static float levelFourEnchantmentHealValue = 6F;
}

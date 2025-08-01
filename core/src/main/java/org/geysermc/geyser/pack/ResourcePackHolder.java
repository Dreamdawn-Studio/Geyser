/*
 * Copyright (c) 2024 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.pack;

import lombok.With;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.geyser.api.pack.PackCodec;
import org.geysermc.geyser.api.pack.ResourcePack;
import org.geysermc.geyser.api.pack.ResourcePackManifest;
import org.geysermc.geyser.api.pack.option.PriorityOption;
import org.geysermc.geyser.pack.option.OptionHolder;

import java.util.UUID;

@With
public record ResourcePackHolder(
    @NonNull GeyserResourcePack pack,
    @NonNull OptionHolder optionHolder
) {

    public static ResourcePackHolder of(GeyserResourcePack pack) {
        return new ResourcePackHolder(pack, new OptionHolder(PriorityOption.NORMAL));
    }

    public ResourcePack resourcePack() {
        return this.pack;
    }

    public PackCodec codec() {
        return this.pack.codec();
    }

    public UUID uuid() {
        return this.pack.uuid();
    }

    public ResourcePackManifest.Version version() {
        return pack.manifest().header().version();
    }
}

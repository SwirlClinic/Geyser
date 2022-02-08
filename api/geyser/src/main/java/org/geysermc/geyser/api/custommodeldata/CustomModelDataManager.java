/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
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

package org.geysermc.geyser.api.custommodeldata;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * This class is used to manage custom item data.
 */
public abstract class CustomModelDataManager {
    /**
     * Registers a custom item.
     *
     * @param baseItem the base (java) item
     * @param customItemData the custom item data to register
     */
    public abstract void registerCustomItem(String baseItem, CustomItemData customItemData);

    /**
     * Registers multiple custom items.
     *
     * @param baseItem the base (java) item
     * @param customItemData the custom item data to register
     */
    public final void registerCustomItems(String baseItem, CustomItemData... customItemData) {
        for (CustomItemData data : customItemData) {
            this.registerCustomItem(baseItem, data);
        }
    }

    /**
     * Loads mappings from a json file.
     *
     * @param file the file to load from
     */
    public abstract void loadMappingsFromJson(File file);

    /**
     * Loads mappings from a json file.
     *
     * @param file the file path for the file to load from
     */
    public final void loadMappingsFromJson(String file) {
        this.loadMappingsFromJson(new File(file));
    }

    /**
     * Gets the custom item data for the given base item.
     *
     * @param baseItem the base item
     * @return the custom item data
     */
    public abstract List<CustomItemData> getCustomItemData(String baseItem);

    /**
     * Gets all the custom item data.
     *
     * @return all the custom item data
     */
    public abstract Map<String, List<CustomItemData>> getCustomMappings();
}

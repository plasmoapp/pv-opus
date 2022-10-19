/*
 *     Copyright 2015-2018 discord-java
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
package su.plo.voice.opus;

import com.sun.jna.Platform;

/**
 * Interface for opus binaries
 */
public final class OpusLibrary {
    private static String initialized = "";

    private OpusLibrary() {}

    private static String getExtension(String platform) {
        switch (platform) {
            case "darwin":
                return "dylib";
            case "win32-x86":
            case "win32-x86-64":
                return "dll";
            default:
                return "so";
        }
    }

    public static String loadFromJar() {
        if (!initialized.isEmpty())
            return initialized;
        String platform = Platform.RESOURCE_PREFIX;

        initialized = String.format("/natives/opus/%s/libopus.%s", platform, getExtension(platform));
        return initialized;
    }
}

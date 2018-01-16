/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.http.internal.util;

import static java.lang.Character.toUpperCase;

public final class HttpUtil
{

    public static final int HTTP_STATUS_OK = 200;
    public static final int HTTP_STATUS_BAD_REQUEST = 400;
    public static final int HTTP_STATUS_NOT_FOUND = 404;
    public static final int HTTP_STATUS_NOT_IMPLEMENTED = 501;
    public static final int HTTP_STATUS_BAD_GATEWAY = 502;
    public static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    public static final int HTTP_STATUS_VERSION_NOT_SUPPORTED = 505;

    public static void appendHeader(StringBuilder payload, String name, String value)
    {
        int pos = name.indexOf('-');
        if (pos > -1 && pos+1 < name.length())
        {
            payload.append(toUpperCase(name.charAt(0))).append(name.substring(1, pos+1))
            .append(toUpperCase(name.charAt(pos+1)))
            .append(name.substring(pos+2))
            .append(": ").append(value).append("\r\n");
        }
        else
        {
            payload.append(toUpperCase(name.charAt(0))).append(name.substring(1))
            .append(": ").append(value).append("\r\n");
        }
    }

    private HttpUtil()
    {
        // utility class, no instances
    }
}

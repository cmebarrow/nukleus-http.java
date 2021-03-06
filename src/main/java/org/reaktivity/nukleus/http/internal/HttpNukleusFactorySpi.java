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
package org.reaktivity.nukleus.http.internal;

import static org.reaktivity.nukleus.route.RouteKind.CLIENT;
import static org.reaktivity.nukleus.route.RouteKind.SERVER;

import org.reaktivity.nukleus.Configuration;
import org.reaktivity.nukleus.Nukleus;
import org.reaktivity.nukleus.NukleusBuilder;
import org.reaktivity.nukleus.NukleusFactorySpi;
import org.reaktivity.nukleus.http.internal.stream.ClientStreamFactoryBuilder;
import org.reaktivity.nukleus.http.internal.stream.ServerStreamFactoryBuilder;

public final class HttpNukleusFactorySpi implements NukleusFactorySpi
{
    public static final String NAME = "http";

    @Override
    public String name()
    {
        return NAME;
    }

    @Override
    public Nukleus create(
        Configuration config,
        NukleusBuilder builder)
    {
        HttpConfiguration httpConfig = new HttpConfiguration(config);

        return builder.streamFactory(CLIENT, new ClientStreamFactoryBuilder(httpConfig))
                      .streamFactory(SERVER, new ServerStreamFactoryBuilder(httpConfig))
                      .build();
    }
}

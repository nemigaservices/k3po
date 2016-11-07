/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.k3po.driver.internal.resolver;

import java.net.URI;
import java.util.Map;

import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.kaazing.k3po.driver.internal.behavior.Barrier;
import org.kaazing.k3po.driver.internal.netty.bootstrap.BootstrapFactory;
import org.kaazing.k3po.driver.internal.netty.bootstrap.ClientBootstrap;
import org.kaazing.k3po.driver.internal.netty.bootstrap.ServerBootstrap;
import org.kaazing.k3po.driver.internal.netty.channel.ChannelAddress;
import org.kaazing.k3po.driver.internal.netty.channel.ChannelAddressFactory;
import org.kaazing.k3po.lang.internal.RegionInfo;

/**
 * The class is used to defer the initialization of {@link ServerBootstrap}.
 */
public class ClientBootstrapResolver {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(ClientBootstrapResolver.class);

    private final BootstrapFactory bootstrapFactory;
    private final ChannelAddressFactory addressFactory;
    private final ChannelPipelineFactory pipelineFactory;
    private final LocationResolver locationResolver;
    private final Barrier awaitBarrier;
    private final RegionInfo regionInfo;
    private final OptionsResolver optionsResolver;

    private ClientBootstrap bootstrap;

    public ClientBootstrapResolver(BootstrapFactory bootstrapFactory, ChannelAddressFactory addressFactory,
            ChannelPipelineFactory pipelineFactory, LocationResolver locationResolver,
            OptionsResolver optionsResolver, Barrier awaitBarrier,
            RegionInfo regionInfo) {
        this.bootstrapFactory = bootstrapFactory;
        this.addressFactory = addressFactory;
        this.pipelineFactory = pipelineFactory;
        this.locationResolver = locationResolver;
        this.optionsResolver = optionsResolver;
        this.awaitBarrier = awaitBarrier;
        this.regionInfo = regionInfo;
    }

    public ClientBootstrap resolve() throws Exception {
        if (bootstrap == null) {
            URI connectURI = locationResolver.resolve();
            Map<String, Object> connectOptions = optionsResolver.resolve();
            ChannelAddress remoteAddress = addressFactory.newChannelAddress(connectURI, connectOptions);
            LOGGER.debug("Initializing client Bootstrap connecting to remoteAddress " + remoteAddress);
            ClientBootstrap clientBootstrapCandidate = bootstrapFactory.newClientBootstrap(connectURI.getScheme());
            clientBootstrapCandidate.setPipelineFactory(pipelineFactory);
            clientBootstrapCandidate.setOption("remoteAddress", remoteAddress);
            bootstrap = clientBootstrapCandidate;
        }
        return bootstrap;
    }

    public Barrier getAwaitBarrier() {
        return this.awaitBarrier;
    }

    public RegionInfo getRegionInfo() {
        return this.regionInfo;
    }
}

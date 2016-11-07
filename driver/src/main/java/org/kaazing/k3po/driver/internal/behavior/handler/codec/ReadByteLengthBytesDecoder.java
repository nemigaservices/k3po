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
package org.kaazing.k3po.driver.internal.behavior.handler.codec;

import static org.kaazing.k3po.lang.internal.RegionInfo.newSequential;

import org.jboss.netty.buffer.ChannelBuffer;
import org.kaazing.k3po.lang.internal.RegionInfo;
import org.kaazing.k3po.lang.internal.el.ExpressionContext;

public class ReadByteLengthBytesDecoder extends ReadFixedLengthBytesDecoder<Byte> {

    public ReadByteLengthBytesDecoder(RegionInfo regionInfo, ExpressionContext environment, String captureName) {
        super(regionInfo, Byte.SIZE / Byte.SIZE, environment, captureName);
    }

    // Read the data into a Byte
    @Override
    public Byte readBuffer(ChannelBuffer buffer) {
        return buffer.readByte();
    }

    // unit tests
    ReadByteLengthBytesDecoder(ExpressionContext environment, String captureName) {
        this(newSequential(0, 0), environment, captureName);
    }
}

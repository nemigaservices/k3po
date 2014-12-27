/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.k3po.driver.behavior.handler.codec.http;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.US_ASCII;

import org.jboss.netty.channel.Channel;
import org.kaazing.k3po.driver.behavior.handler.codec.ConfigEncoder;
import org.kaazing.k3po.driver.behavior.handler.codec.MessageEncoder;
import org.kaazing.k3po.driver.netty.bootstrap.http.HttpChannelConfig;
import org.kaazing.k3po.driver.netty.bootstrap.http.HttpRequestForm;

public class HttpRequestFormEncoder implements ConfigEncoder {

    private MessageEncoder formEncoder;

    public HttpRequestFormEncoder(MessageEncoder formEncoder) {
        this.formEncoder = formEncoder;
    }

    @Override
    public void encode(Channel channel) throws Exception {
        HttpChannelConfig httpConfig = (HttpChannelConfig) channel.getConfig();
        String formName = formEncoder.encode().toString(US_ASCII);
        HttpRequestForm form = HttpRequestForm.valueOf(formName);
        httpConfig.setRequestForm(form);
    }

    @Override
    public String toString() {
        return format("http:request %s", formEncoder);
    }

}

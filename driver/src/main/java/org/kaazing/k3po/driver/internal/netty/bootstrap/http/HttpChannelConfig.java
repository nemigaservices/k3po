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
package org.kaazing.k3po.driver.internal.netty.bootstrap.http;

import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.kaazing.k3po.driver.internal.behavior.handler.codec.http.QueryStringEncoder;

public interface HttpChannelConfig extends ChannelConfig {

    void setMethod(HttpMethod method);

    HttpMethod getMethod();

    void setVersion(HttpVersion version);

    HttpVersion getVersion();

    void setStatus(HttpResponseStatus status);

    HttpResponseStatus getStatus();

    boolean hasReadHeaders();

    HttpHeaders getReadHeaders();

    boolean hasWriteHeaders();

    HttpHeaders getWriteHeaders();

    void setMaximumBufferedContentLength(int maxValue);

    int getMaximumBufferedContentLength();

    void setReadQuery(QueryStringDecoder readQuery);

    QueryStringDecoder getReadQuery();

    void setWriteQuery(QueryStringEncoder writeQuery);

    QueryStringEncoder getWriteQuery();

    void setRequestForm(HttpRequestForm requestForm);

    HttpRequestForm getRequestForm();

    HttpHeaders getWriteTrailers();

    HttpHeaders getReadTrailers();
}

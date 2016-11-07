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
package org.kaazing.k3po.lang.internal.ast.matcher;

import org.kaazing.k3po.lang.internal.ast.AstRegion;

public abstract class AstValueMatcher extends AstRegion {

    public abstract <R, P> R accept(Visitor<R, P> visitor, P parameter) throws Exception;

    public interface Visitor<R, P> {

        R visit(AstExpressionMatcher matcher, P parameter) throws Exception;

        R visit(AstFixedLengthBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstRegexMatcher matcher, P parameter) throws Exception;

        R visit(AstExactTextMatcher matcher, P parameter) throws Exception;

        R visit(AstExactBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstVariableLengthBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstByteLengthBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstShortLengthBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstIntLengthBytesMatcher matcher, P parameter) throws Exception;

        R visit(AstLongLengthBytesMatcher matcher, P parameter) throws Exception;

    }
}

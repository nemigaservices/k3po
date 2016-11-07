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
package org.kaazing.k3po.lang.internal.ast.builder;

import org.kaazing.k3po.lang.internal.ast.AstScriptNode;

public class AstScriptNodeBuilder extends AbstractAstNodeBuilder<AstScriptNode, AstScriptNode> {

    public AstScriptNodeBuilder() {
        this(new AstScriptNode());
    }

    private AstScriptNodeBuilder(AstScriptNode node) {
        super(node, node);
    }

    public AstPropertyNodeBuilder.ScriptNested<AstScriptNodeBuilder> addProperty() {
        return new AstPropertyNodeBuilder.ScriptNested<>(this);
    }

    public AstAcceptNodeBuilder.ScriptNested<AstScriptNodeBuilder> addAcceptStream() {
        return new AstAcceptNodeBuilder.ScriptNested<>(this);
    }

    public AstAcceptableNodeBuilder.ScriptNested<AstScriptNodeBuilder> addAcceptedStream() {
        return new AstAcceptableNodeBuilder.ScriptNested<>(this);
    }

    public AstConnectNodeBuilder.ScriptNested<AstScriptNodeBuilder> addConnectStream() {
        return new AstConnectNodeBuilder.ScriptNested<>(this);
    }

    @Override
    public AstScriptNode done() {
        return node;
    }

}

/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.overlord.sramp.query.xpath.ast;

import org.overlord.sramp.query.xpath.visitors.XPathVisitor;

/**
 * An X-Path AND expression.
 * 
 * <pre>
 *   OrExpr ::= EqualityExpr
 *            | EqualityExpr 'or' OrExpr 
 * </pre>
 *
 * @author eric.wittmann@redhat.com
 */
public class OrExpr extends AbstractBinaryExpr<EqualityExpr, OrExpr> {
	
	/**
	 * Default constructor.
	 */
	public OrExpr() {
	}
	
	/**
	 * @see org.overlord.sramp.query.xpath.ast.AbstractXPathNode#accept(org.overlord.sramp.query.xpath.visitors.XPathVisitor)
	 */
	@Override
	public void accept(XPathVisitor visitor) {
		visitor.visit(this);
	}

}

/********************************************************************************
 * Copyright (c) 2015-2020 Riverside Software
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU Lesser General Public License v3.0
 * which is available at https://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * SPDX-License-Identifier: EPL-2.0 OR LGPL-3.0
 ********************************************************************************/
package org.prorefactor.proparse.antlr4;

import org.prorefactor.core.ABLNodeType;

/**
 * ANTLR4 version of antlr.AST, where only the interesting methods are kept. 
 */
public interface AST {

  /**
   * @return First child of this node; null if no children
   */
  public AST getFirstChild();

  /**
   * @return Next sibling in line after this one
   */
  public AST getNextSibling();

  /**
   * @return Token text for this node
   */
  public String getText();

  /**
   * @return Get the token type for this node
   */
  public ABLNodeType getNodeType();

  /**
   * @return Get the token type for this node
   */
  public int getType();

  /**
   * @return Line number of this node
   */
  public int getLine();

  /**
   * @return Column number of this node
   */
  public int getColumn();

  /**
   * @return Number of children of this node; if leaf, returns 0
   */
  public int getNumberOfChildren();

}

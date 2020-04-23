/********************************************************************************
 * Copyright (c) 2003-2015 John Green
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
package org.prorefactor.core;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.prorefactor.core.util.UnitTestModule;
import org.prorefactor.refactor.RefactorSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import eu.rssw.pct.elements.ITypeInfo;

/**
 * Test Progress built-in classes presence in the session
 */
public class RefactorSessionTest {
  private RefactorSession session;

  @BeforeTest
  public void setUp() {
    Injector injector = Guice.createInjector(new UnitTestModule());
    session = injector.getInstance(RefactorSession.class);
  }

  @Test
  public void testProgressLangObject() {
    ITypeInfo info = session.getTypeInfo("Progress.Lang.Object");
    assertNotNull(info);
    assertEquals(info.getMethods().size(), 4);
    assertEquals(info.getProperties().size(), 2);
    assertNull(info.getParentTypeName());
    assertEquals(info.getInterfaces().size(), 0);
  }

  @Test
  public void testProgressJsonJsonParser() {
    ITypeInfo info = session.getTypeInfo("Progress.Json.JsonParser");
    assertNotNull(info);
    assertEquals(info.getMethods().size(), 0);
    assertEquals(info.getProperties().size(), 1);
    assertEquals(info.getParentTypeName(), "Progress.Lang.Object");
    assertEquals(info.getInterfaces().size(), 0);
  }

  @Test
  public void testProgressJsonObjectModelJsonArray() {
    ITypeInfo info = session.getTypeInfo("Progress.Json.ObjectModel.JsonArray");
    assertNotNull(info);
    assertEquals(info.getMethods().size(), 32);
    assertEquals(info.getProperties().size(), 2);
    assertEquals(info.getParentTypeName(), "Progress.Json.ObjectModel.JsonConstruct");
    assertEquals(info.getInterfaces().size(), 0);

    assertNotNull(info.getProperty("Length"));
    assertFalse(info.getProperty("Length").isStatic());
    assertTrue(info.getProperty("END_OF_ARRAY").isStatic());
  }

}

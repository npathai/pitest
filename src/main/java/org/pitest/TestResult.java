/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */
package org.pitest;

import java.io.Serializable;

import org.pitest.extension.TestUnit;
import org.pitest.testunit.TestUnitState;

/**
 * @author henry
 * 
 */
public class TestResult implements Serializable {

  private static final long   serialVersionUID = 1L;

  private final Description   description;

  private final Throwable     throwable;
  private final TestUnitState state;

  public TestResult(final TestUnit tu, final Throwable t) {
    this(tu.description(), t);
  }

  public TestResult(final TestUnit tu, final Throwable t,
      final TestUnitState state) {
    this(tu.description(), t, state);
  }

  public TestResult(final Description description, final Throwable t) {
    this(description, t, TestUnitState.FINISHED);
  }

  public TestResult(final Description description, final Throwable t,
      final TestUnitState state) {
    this.description = description;
    this.throwable = t;
    this.state = state;
  }

  public Throwable getThrowable() {
    return this.throwable;
  }

  public TestUnitState getState() {
    return this.state;
  }

  public Description getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    return "TestResult [description=" + this.description + ", state="
        + this.state + ", throwable=" + this.throwable + "]";
  }

}
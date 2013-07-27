/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.client.shell;

import org.apache.commons.cli.CommandLine;
import org.apache.sqoop.client.core.Constants;
import org.apache.sqoop.model.MFramework;

import java.util.ResourceBundle;

import static org.apache.sqoop.client.shell.ShellEnvironment.*;
import static org.apache.sqoop.client.utils.FormDisplayer.*;

/**
 *
 */
public class ShowFrameworkFunction extends SqoopFunction {
  @SuppressWarnings("static-access")
  protected ShowFrameworkFunction() {
  }

  public Object executeFunction(CommandLine line) {
    if (line.getArgs().length != 0) {
      printlnResource(Constants.RES_SHOW_FRAMEWORK_USAGE);
      return null;
    }

    showFramework();

    return null;
  }

  private void showFramework() {
    MFramework framework = client.getFramework();
    ResourceBundle bundle = client.getFrameworkResourceBundle();

    printlnResource(Constants.RES_SHOW_PROMPT_FRAMEWORK_OPTS, framework.getPersistenceId());
    displayFormMetadataDetails(framework, bundle);
  }
}
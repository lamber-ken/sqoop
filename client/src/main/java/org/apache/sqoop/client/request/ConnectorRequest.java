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
package org.apache.sqoop.client.request;

import org.apache.sqoop.json.ConnectorBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ConnectorRequest extends Request
{
  public ConnectorBean doGet(String serverUrl, String cid) {
    String response = null;
    if (cid == null) {
      response = super.get(serverUrl + "v1/connector/all");
    } else {
      response = super.get(serverUrl + "v1/connector/" + cid);
    }
    JSONObject jsonObject = (JSONObject)JSONValue.parse(response);

    ConnectorBean connectorBean = new ConnectorBean();
    connectorBean.restore(jsonObject);

    return connectorBean;
  }
}
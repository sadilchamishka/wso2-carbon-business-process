/**
 *  Copyright (c) 2015 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.bpmn.rest.service.query;

import io.netty.handler.codec.http.QueryStringDecoder;
import org.wso2.carbon.bpmn.rest.model.common.DataResponse;
import org.wso2.carbon.bpmn.rest.model.runtime.TaskQueryRequest;
import org.wso2.carbon.bpmn.rest.service.base.BaseTaskService;
import org.wso2.msf4j.Request;

import java.util.List;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/tasks")
public class QueryTaskService extends BaseTaskService {

    @POST
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getTasks(TaskQueryRequest request, @Context Request currentRequest) {
        QueryStringDecoder decoder = new QueryStringDecoder(currentRequest.getUri());
        Map<String, List<String>> queryParams = decoder.parameters();
        DataResponse dataResponse =
                getTasksFromQueryRequest(request, queryParams, null, currentRequest.getUri());
        return Response.ok().entity(dataResponse).build();
    }
}

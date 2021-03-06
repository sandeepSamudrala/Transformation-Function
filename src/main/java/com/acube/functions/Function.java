package com.acube.functions;

import java.util.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/hello". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/hello
     * 2. curl {your host}/api/hello?name=HTTP%20Query
     */
    @FunctionName("hello")
    public HttpResponseMessage<String> hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return request.createResponse(400, "Please pass a name on the query string or in the request body");
        } else {
            return request.createResponse(200, "Hello, " + name);
        }
    }
}

//@BlobTrigger(name = "blob", dataType ="blobTrigger", path = "acube/data/meta/HandsetDeviceMetadataM3/handset_device_metadata_m3.csv.gz", connection = "DefaultEndpointsProtocol=https;AccountName=acube;AccountKey=d3ogxHhcfajnM6GmTGRrbvoSujAF686e5OjqxtcJDnTHCQnlIP4VnYe1UrOmzFBaAuzIJsoFi5oPPXj3otdTZw==;TableEndpoint=https://acube.table.cosmosdb.azure.com:443/;") {
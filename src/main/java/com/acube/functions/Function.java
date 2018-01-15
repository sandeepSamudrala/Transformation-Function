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
    public String hello(
            @HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) String request,
            ExecutionContext context) {
//        context.getLogger().info("Java HTTP trigger processed a request.");
        System.out.println("hjfbejbfnhjedbnvkdnvjndfjvn");
        return String.format("Hello. %s!",request);

        // Parse query parameter
//        String query = request.getQueryParameters().get("name");
//        String name = request.getBody().orElse(query);
//
//        if (name == null) {
//            System.out.println("Hiiiiiii");
//            return request.createResponse(400, "Please pass a name on the query string or in the request body");
//        } else {
//            System.out.println("Hello");
//            return request.createResponse(200, "Hello, " + name);
//        }
    }
}
package org.rest.api.handlers;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.rest.api.utils.apiDBUtils;

public class apiHandler {

    public static void getAPIs(RoutingContext ctx) {
        JsonObject response = apiDBUtils.getAPIData();
        ctx.response().putHeader("Content-Type","application/json").end(response.toString());
    }

    public static void postAPI(RoutingContext ctx) {
        JsonObject request = ctx.body().asJsonObject();
        apiDBUtils.addAPIData(request);
        ctx.response().putHeader("content-type","application/json").end(request.toString());
    }

    public static void deleteAPI(RoutingContext ctx) {
        ctx.end("Delete request has been called on "+ctx.pathParam("id"));
    }

    public static void getAPI(RoutingContext ctx) {
        ctx.end("Get request has been called on "+ctx.pathParam("id"));
    }

}

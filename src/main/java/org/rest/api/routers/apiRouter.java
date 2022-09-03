package org.rest.api.routers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.rest.api.handlers.apiHandler;

public class apiRouter {

    static Router restAPI;

    public static void setRouter(Vertx vertx, Router router, String routeURL) {
        router.route(routeURL).subRouter(buildRestApiRouter(vertx));
    }

    public static Router buildRestApiRouter (Vertx vertx) {
        restAPI = Router.router(vertx);
        restAPI.route().handler(BodyHandler.create());
        restAPI.get("/").handler(apiHandler::getAPIs);
        restAPI.post("/").consumes("application/json").handler(apiHandler::postAPI);
        restAPI.delete("/:apiName").handler(apiHandler::deleteAPI);
        restAPI.get("/:apiName").handler(apiHandler::getAPI);
        return restAPI;
    }

}

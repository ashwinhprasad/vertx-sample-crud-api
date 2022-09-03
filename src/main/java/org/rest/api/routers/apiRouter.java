package org.rest.api.routers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.rest.api.handlers.apiHandler;

public class apiRouter {

    static Router restAPI;

    public static void setRouter(Vertx vertx, Router router, String routeURL) {
        router.route(routeURL).subRouter(buildRestApiRouter(vertx));
    }

    public static Router buildRestApiRouter (Vertx vertx) {
        restAPI = Router.router(vertx);
        restAPI.get("/").handler(apiHandler::getAPIs);
        restAPI.post("/").handler(apiHandler::postAPI);
        restAPI.delete("/:id").handler(apiHandler::deleteAPI);
        restAPI.get("/:id").handler(apiHandler::getAPI);
        return restAPI;
    }

}

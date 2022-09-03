package org.rest.api;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.rest.api.creds.dbCreds;
import org.rest.api.dao.masterDao;
import org.rest.api.routers.apiRouter;

public class App
{
    public static void main( String[] args )
    {
        Vertx vertx = Vertx.vertx();

        // register routers
        Router router = Router.router(vertx);
        apiRouter.setRouter(vertx,router,"/api/*");

        // database connection
        masterDao.connectToDatabase("jdbc:postgresql://localhost:5432/","vertxapi","ashwinhprasad", dbCreds.getPass());

        // start server
        vertx.createHttpServer().requestHandler(router).listen(8080).onSuccess(server -> {
            System.out.println("Server Started at 8080");
        });

    }
}

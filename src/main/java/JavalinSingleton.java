
import org.eclipse.jetty.server.Authentication.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

/**
 * Background: A json string representing a song will be sent in this POST
 * request with the following fields:
 * songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance() {
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();

        /**
         * problem1: retrieve the song object from the request body...
         * 1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {

            String songName = ctx.body();
            Song user = om.readValue(songName, Song.class);

            ctx.json(user);

        });

        /**
         * problem2: retrieve the song object from the request body...
         * 1. update the artist in the song object to "Beatles"
         * 2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            String artistName = ctx.body();
            Song user = om.readValue(artistName, Song.class);

            user.setArtistName("Beatles");

            ctx.json(user);

        });

        return app;
    }

}

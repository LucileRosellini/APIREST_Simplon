import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Controllers {
    static Dao<User> dao = new userDao();
    static class userController implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Bad request";
            Headers responseHeaders = t.getResponseHeaders();
            System.out.println("URL : " + t.getRequestURI().getPath());
            User user = new User();
            System.out.println("Method : " + t.getRequestMethod());
            InputStream request = t.getRequestBody();
            Scanner s = new Scanner(request).useDelimiter("\\A");
            String payload = s.hasNext() ? s.next() : "";
            s.close();
            System.out.println("Payload : " + payload);
            responseHeaders.add("content-type", "application/json");
            int httpCode = 500;
            int id = getIdFromPath(t);
            switch (t.getRequestMethod()) {
                case "GET":
                    if (id >= 0) {
                        System.out.println("ID : " + id);
                        try {
                            user = dao.get(id);
                            response = dao.serialize(user);
                            httpCode = 200;
                        } catch (Exception e) {
                            System.out.println("User id : " + id + " not found");
                            response = "{}";
                            httpCode = 404;
                        }
                    } else {
                        response = dao.serializeAll();
                        httpCode = 200;
                    }
                    break;
                case "POST":
                    User newUser = new User(payload);
                    dao.save(newUser);
                    response = dao.serialize(newUser);
                    httpCode = 200;
                    break;
                case "PUT":
                    User putUser = new User(payload);
                    try {
                        user = dao.get(putUser.getId());
                        user.setEmail(putUser.getEmail());
                        user.setPassword(putUser.getPassword());
                        user.setTopics(putUser.getTopics());
                        response = dao.serialize(user);
                        httpCode = 200;
                    } catch (Exception e) {
                        System.out.println("User id : " + putUser.getId() + " not found");
                        response = "{}";
                        httpCode = 404;
                    }
                    break;
                case "DELETE":
                    System.out.println("ID : " + id);
                    try {
                        user = dao.get(id);
                        response = dao.serialize(user);
                        dao.delete(user);
                        httpCode = 200;
                    } catch (Exception e) {
                        System.out.println("User id : " + id + " not found");
                        response = "{}";
                        httpCode = 404;
                    }
                    break;
                default:
                    response = "Unknown request method";
                    t.sendResponseHeaders(403, response.length());
                    break;
            }
            t.sendResponseHeaders(httpCode, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static private int getIdFromPath(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        String IdStr = path.substring(path.lastIndexOf('/') + 1);
        if(IdStr.length() > 0) {
            return(Integer.parseInt(IdStr));
        } else {
            return -1;
        }
    } 
}

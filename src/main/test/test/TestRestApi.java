package test;

import org.igniterealtime.restclient.RestApiClient;
import org.igniterealtime.restclient.entity.AuthenticationToken;
import org.igniterealtime.restclient.enums.SupportedMediaType;

import javax.json.*;
import java.io.StringReader;
import java.util.HashMap;

public class TestRestApi {
    public static void main(String[] args) {
        AuthenticationToken authenticationToken = new AuthenticationToken("admin","admin");
        RestApiClient restApiClient = new RestApiClient("192.168.200.245", 9090,authenticationToken, SupportedMediaType.JSON);
        HashMap<String, String> querys = new HashMap<String, String>();
        querys.put("search", "wan");
        String users_json = restApiClient.getUsers_json(querys);
        System.out.println(users_json);
        JsonReader reader = Json.createReader(new StringReader(users_json));
        JsonObject jsonObject = reader.readObject();

    }
}

package ContractTests;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DefaultActionShould {
    @Test
    public void respond_with_200_when_all_query_parameters_are_provided() throws IOException {
        URL endpoint = new URL("http://localhost:8080/?name=dan");

        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        assertThat(responseCode, is(200));
    }

    @Test
    public void respond_with_400_when_name_is_missing() throws IOException {
        URL endpoint = new URL("http://localhost:8080/");

        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();

        assertThat(responseCode, is(400));
    }
}

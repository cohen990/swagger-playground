package ContractTests;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import swaggerapi.HomeController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.atlassian.oai.validator.mockmvc.SwaggerValidatorMatchers.swagger;


public class DefaultActionShould {
    @Test
    public void respond_with_200_when_all_query_parameters_are_provided() throws Exception {
        String swaggerJsonUrl = System.getProperty("user.dir") + "/swagger.yaml";
        final HomeController petController = new HomeController();
        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

        swagger();
        mockMvc
                .perform(get("/?name=dan"))
                .andExpect(status().isOk())
                .andExpect(swagger().isValid(swaggerJsonUrl));
    }

    @Test
    public void respond_with_400_when_name_is_missing() throws Exception {
        String swaggerJsonUrl = System.getProperty("user.dir") + "/swagger.yaml";
        final HomeController petController = new HomeController();
        final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(petController).build();

        swagger();
        mockMvc
                .perform(get("/"))
                .andExpect(status().isBadRequest())
                .andExpect(swagger().isValid(swaggerJsonUrl));
    }
}

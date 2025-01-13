package demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import demo.domain.Item;

@ExtendWith(SpringExtension.class)
@Category(IntegrationTest.class)
public class ItemServiceITTest {

    private static RestTemplate restTemplate;
    private static String baseUrl;

    @BeforeAll
    public static void setup() {
        restTemplate = new RestTemplate();

        if (System.getProperty("baseUrl") != null) {
            baseUrl = System.getProperty("baseUrl");
        } else {
            baseUrl = "http://localhost:8080/";
        }
    }

    @Test
    public void getSuccess() throws Exception {
        ParameterizedTypeReference<List<Item>> typeRef = new ParameterizedTypeReference<List<Item>>() {};

        ResponseEntity<List<Item>> response = restTemplate.exchange(baseUrl + "/api/item/", HttpMethod.GET, null, typeRef);

        List<Item> returnedItems = response.getBody();

        assertTrue(returnedItems.size() == 2);
    }
}
package bisnesslighthouse.tech.location.manager;

import bisnesslighthouse.tech.location.model.Town;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TownManager {

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public TownManager() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    public List<Town> getAll() throws Exception {

        String response = restTemplate.getForObject("", String.class);
        response = response.substring(1, response.length()-1);

        Town[] towns = objectMapper.readValue(response, Town[].class);

        if(towns == null)
            throw new Exception("Not Found");

        return Arrays.asList(towns);
    }

    public Town getByName(String townName) throws Exception {
        String response = restTemplate.getForObject("", String.class);
        Town town = null;

        try {
            town = objectMapper.readValue(response, Town.class);
        } catch (IOException e) {
        }

        if(town == null)
            throw new Exception("Not found");

        return town;
    }

}

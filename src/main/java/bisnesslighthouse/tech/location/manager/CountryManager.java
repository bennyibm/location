package bisnesslighthouse.tech.location.manager;

import bisnesslighthouse.tech.location.model.Country;
import bisnesslighthouse.tech.location.model.Town;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class CountryManager {

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public CountryManager() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    public List<Country> getAll() throws Exception {
        List<Country> countries = null;

        String response = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", String.class);

        countries = objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Country.class));

        return countries;
    }

    public Country getByName(String countryName) throws Exception {
        String response = restTemplate.getForObject("", String.class);
        Country country = null;

        try {
            country = objectMapper.readValue(response, Country.class);
        } catch (IOException e) {
        }

        if(country == null)
             throw new Exception("Not found");

        return country;
    }

    public List<Country> getByPopulationGreaterThan(long polationMin)
    {
        return null;
    }

    public List<Country> getByPopulationLessThan(long populationMax)
    {
        return null;
    }

    public List<Country> getByPopulationBetween(long populationMin, long populationMax)
    {
        return null;
    }

    public Country getByCapital(String capital) throws Exception {
        String url = "https://restcountries.eu/rest/v2/capital/" + capital;

        String response = restTemplate.getForObject(url, String.class);

        Country country = null;
        try {
            country = objectMapper.readValue(response, Country.class);
        } catch (IOException e) {
        }finally {
            if(country == null)
                throw  new Exception("Not Found");
        }

        return country;
    }

    public Country getByCode(String countryCode) throws Exception {


        String url = String.format("https://restcountries.eu/rest/v2/alpha/%s", countryCode);

        String response = restTemplate.getForObject(url, String.class);

        Country country = null;
        try {
            country = objectMapper.readValue(response, Country.class);
        } catch (IOException e) {
        }finally {
            if(country == null)
                throw  new Exception("Not Found");
        }

        return country;
    }

    public List<Town> getAllTowns()
    {
        return null;
    }
}

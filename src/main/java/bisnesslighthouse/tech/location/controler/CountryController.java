package bisnesslighthouse.tech.location.controler;

import bisnesslighthouse.tech.location.manager.CountryManager;
import bisnesslighthouse.tech.location.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    CountryManager countryManager;

    public CountryController() {
        countryManager = new CountryManager();
    }

    @GetMapping(value = "/countries/")
    public List<Country> getAll() throws Exception {
        return countryManager.getAll();
    }

    @GetMapping(value = "/countries/search/{countryName}")
    public Country getByName(@PathVariable String countryName) throws Exception {
        return countryManager.getByName(countryName);
    }

    @GetMapping(value = "/countries/search/capital/{capital}")
    public Country getByCapital(@PathVariable String capital) throws Exception {
        Country country = new  Country();
        country.setName("lobi :-)");

        return country;

        //return countryManager.getByCapital(capital);
    }

    @GetMapping(value = "/countries/search/code/{countryCode}")
    public Country getByCode(@PathVariable String countryCode) throws Exception {
        return countryManager.getByCode(countryCode);
    }

    @GetMapping(value = "countries/search/population/greather/{populationMin}")
    public List<Country> getByPopulationGreaterThan(@PathVariable long populationMin)
    {
        return countryManager.getByPopulationGreaterThan(populationMin);
    }

    @GetMapping(value = "countries/search/population/less/{populationMax}")
    public List<Country> getByPopulationLessThan(@PathVariable long populationMax)
    {
        return countryManager.getByPopulationLessThan(populationMax);
    }

    @GetMapping(value = "countries/search/population/between/{populationMin}&{populationMax}")
    public List<Country> getByPopulationBetween(@PathVariable long populationMin,@PathVariable long populationMax)
    {
        return countryManager.getByPopulationBetween(populationMin, populationMax);
    }


}

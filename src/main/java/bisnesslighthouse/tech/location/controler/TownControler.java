package bisnesslighthouse.tech.location.controler;


import bisnesslighthouse.tech.location.manager.TownManager;
import bisnesslighthouse.tech.location.model.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TownControler {

    private TownManager townManager;

    public TownControler() {
        townManager = new TownManager();
    }

    @GetMapping(value = "towns/")
    public List<Town> getAll() throws Exception {
        return townManager.getAll();
    }

    @GetMapping(value = "towns/search/{townName}")
    public Town getByName(@PathVariable String townName) throws Exception {
        return townManager.getByName(townName);
    }

    @GetMapping(value = "towns/search/countries/{countryName}")
    public List<Town> getByCountry(@PathVariable String countryName) throws Exception {
        throw new Exception("Not implemented yet");
    }

}

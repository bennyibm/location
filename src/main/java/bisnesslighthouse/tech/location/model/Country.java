package bisnesslighthouse.tech.location.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String name;
    private String capitale;
    private String alpha2Code;
    private String alpha3Code;

    private long population;

    public Country() {
    }

    public Country(String name, String capitale, String alpha2Code, String alpha3Code, long population) {
        this.name = name;
        this.capitale = capitale;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitale() {
        return capitale;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }
}


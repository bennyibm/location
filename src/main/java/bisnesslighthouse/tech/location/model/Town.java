package bisnesslighthouse.tech.location.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Town {
    private String name;
}

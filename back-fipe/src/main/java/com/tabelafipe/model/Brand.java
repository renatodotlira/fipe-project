package com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Brand {

    private Long id;

    private String key;

    private int order;

    private String name;

    @JsonProperty(value = "fipe_name")
    private String fipeName;
}

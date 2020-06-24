package com.example.ParcialRestIntegration.Domains;

import lombok.*;

import java.util.Objects;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class City {

    public City(String name) {
        this.name = name;
    }

    private Integer id;

    private String name;

    private String prefix;

    private Province province;

    public boolean hasNullAttribute(){
        return Stream.of(name, prefix, province).anyMatch(Objects::isNull);
    }
}

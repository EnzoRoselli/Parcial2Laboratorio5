package com.example.ParcialRestIntegration.Domains;

import lombok.*;

import java.util.Objects;
import java.util.stream.Stream;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Rate {

    private Integer id;

    private City originCity;

    private City destinationCity;

    private Double costPerMinute;

    private Double pricePerMinute;

    public boolean hasNullAttribute(){
        return Stream.of(originCity, destinationCity, costPerMinute, pricePerMinute).anyMatch(Objects::isNull);
    }

}

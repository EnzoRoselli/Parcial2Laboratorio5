package com.example.ParcialRestIntegration.Domains;

import lombok.*;

import java.util.Objects;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Province {

    private Integer id;

    private String name;

    public boolean hasNullAttribute(){

        return Stream.of(name).anyMatch(Objects::isNull);
    }
}

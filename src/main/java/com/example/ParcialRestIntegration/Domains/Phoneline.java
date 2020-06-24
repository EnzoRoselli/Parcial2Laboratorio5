package com.example.ParcialRestIntegration.Domains;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Phoneline {

    private Integer id;

    private String number;

    private String type;

    private Boolean status;

    private User user;

    private City city;
}

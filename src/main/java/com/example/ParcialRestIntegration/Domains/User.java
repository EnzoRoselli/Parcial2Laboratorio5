package com.example.ParcialRestIntegration.Domains;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class User {

    private Integer id;

    private String name;

    private String lastname;

    private Boolean status;

    private String type;

    private String identification;

    private String password;

    private City city;
}


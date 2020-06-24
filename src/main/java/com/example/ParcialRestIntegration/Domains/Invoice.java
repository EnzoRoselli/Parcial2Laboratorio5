package com.example.ParcialRestIntegration.Domains;

import lombok.*;

import java.util.Date;
import java.util.stream.Stream;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Invoice {

    private Integer id;

    private Phoneline phoneline;

    private Integer callsQuantity;

    private Double totalPrice;

    private Double totalCost;

    private Date date;

    private Boolean isPaid;

    private Date expirationDate;

    public boolean hasNullAttribute() {
        return Stream.of(phoneline, callsQuantity, totalPrice, isPaid, date, expirationDate, totalCost).anyMatch(x -> x == null);
    }
}

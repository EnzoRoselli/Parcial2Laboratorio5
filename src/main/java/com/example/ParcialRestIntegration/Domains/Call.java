package com.example.ParcialRestIntegration.Domains;

import lombok.*;

import java.util.Date;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class Call {

    private Integer id;

    private Phoneline originPhoneline;

    private String originPhone;

    private Phoneline destinationPhoneline;

    private String destinationPhone;

    private Rate rate;

    private Invoice invoice;

    private Date date;

    private Double total_price;

    private Double totalCost;

    private Integer duration;

    public boolean hasNullAttribute() {
        return Stream.of(originPhoneline, destinationPhoneline, rate, date, total_price, duration, invoice, totalCost).anyMatch(x -> x == null);
    }


}

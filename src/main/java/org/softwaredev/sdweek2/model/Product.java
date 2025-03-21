package org.softwaredev.sdweek2.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(of = {"id","name"})
@EqualsAndHashCode(of = {"id"})
public class Product {

    private String id;
    private String name;
    private double price;
}

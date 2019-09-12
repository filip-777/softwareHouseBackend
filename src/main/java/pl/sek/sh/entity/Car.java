package pl.sek.sh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String model;
    @NotNull
    private String mark;
    @NotNull
    private String color;
    @NotNull
    private String bodyType;
    @NotNull
    private Float price;
    @NotNull
    private Integer yearOfProduction;
}

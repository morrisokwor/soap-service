package com.okworo.soapservice.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String roomNumber;
    private String roomType;
    private BigDecimal price;
    private Integer capacity;
    private String description;

    @Builder.Default
    @Column(columnDefinition = "integer default 0")
    private Integer isBooked = 0;

}

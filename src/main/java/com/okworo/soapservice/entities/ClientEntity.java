package com.okworo.soapservice.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author Morris.Okworo on 04/05/2023
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String physicalAddress;

}


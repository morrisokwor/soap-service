package com.okworo.soapservice.entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author Morris.Okworo on 11/04/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String staffId;
    private String email;
    private String phone;
    private String physicalAddress;


}

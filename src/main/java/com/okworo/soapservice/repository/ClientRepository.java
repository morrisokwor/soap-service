package com.okworo.soapservice.repository;

import com.okworo.soapservice.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Morris.Okworo on 05/05/2023
 */

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}

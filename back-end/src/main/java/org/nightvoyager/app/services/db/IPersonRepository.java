package org.nightvoyager.app.services.db;

import org.nightvoyager.app.entities.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<PersonInfo, String> {
}

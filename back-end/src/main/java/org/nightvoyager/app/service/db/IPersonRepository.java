package org.nightvoyager.app.service.db;

import org.nightvoyager.app.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<PersonInfo, String> {
}

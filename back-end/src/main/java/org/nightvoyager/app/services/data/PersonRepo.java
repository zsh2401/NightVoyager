package org.nightvoyager.app.services.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonInfo, String> {
}

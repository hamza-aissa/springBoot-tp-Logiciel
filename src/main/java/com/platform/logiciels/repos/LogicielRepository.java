package com.platform.logiciels.repos;

import com.platform.logiciels.entities.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogicielRepository extends JpaRepository<Logiciel, Long> {

}

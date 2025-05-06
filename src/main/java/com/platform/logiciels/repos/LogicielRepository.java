package com.platform.logiciels.repos;

import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.entities.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogicielRepository extends JpaRepository<Logiciel, Long> {
    List<Logiciel> findByNomLogiciel(String nomLogiciel);
    List<Logiciel> findByNomLogicielContains(String nomLogiciel);
    List<Logiciel> findByDevloppeur(Devloppeur devloppeur);

    List<Logiciel> findByDevloppeurIdDevloppeur(Long id);
    List<Logiciel> findByOrderByNomLogicielAsc();

    @Query("select l from Logiciel l order by l.nomLogiciel ASC, l.prixLogiciel DESC")
    List<Logiciel> trierLogicielsNomsPrix();
    @Query("select l from Logiciel l where l.nomLogiciel like %?1 and l.prixLogiciel > ?2")
    List<Logiciel> findByNomPrix (String nom, Double prix);
    @Query("select l from Logiciel l where l.devloppeur= ?1")
    List<Logiciel> findByCategorie (Devloppeur devloppeur);

}

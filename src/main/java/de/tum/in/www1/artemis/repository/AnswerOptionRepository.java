package de.tum.in.www1.artemis.repository;

import de.tum.in.www1.artemis.domain.AnswerOption;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AnswerOption entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {

}
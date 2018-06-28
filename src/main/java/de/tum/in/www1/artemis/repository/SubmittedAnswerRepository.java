package de.tum.in.www1.artemis.repository;

import de.tum.in.www1.artemis.domain.SubmittedAnswer;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SubmittedAnswer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubmittedAnswerRepository extends JpaRepository<SubmittedAnswer, Long> {

}
package com.pidev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.models.Advertising;
import com.pidev.models.Collaboration;

@Repository
public interface CollaborationRepository extends CrudRepository<Collaboration,Long>{
//	@Query("SELECT c.rate FROM Collaboration c GROUP BY c.rate ORDER BY c.rate DESC", nativeQuery=false)
//	List<Collaboration> countTotalRateByYear();

	@Query(value="SELECT collab FROM Collaboration collab WHERE collab.CollaboratedWith= :collaboratedWith", nativeQuery=false)
	List<Collaboration> retrieveCollaborationByTitle(@Param("collaboratedWith") String collaboratedWith);
}

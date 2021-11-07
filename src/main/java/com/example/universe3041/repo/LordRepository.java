package com.example.universe3041.repo;

import com.example.universe3041.model.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LordRepository extends JpaRepository<Lord,Long> {

    List<Lord> findAllByPlanetsIsNull();

    @Query(nativeQuery = true, value = "select * from lords order by(age) limit 10")
    List<Lord> getAllOrderByAgeLimit10();

}

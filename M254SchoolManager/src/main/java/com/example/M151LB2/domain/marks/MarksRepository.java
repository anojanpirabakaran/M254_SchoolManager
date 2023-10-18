package com.example.M151LB2.domain.marks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks, String> {

    boolean existsByMarkNumber(String markNumber);
}

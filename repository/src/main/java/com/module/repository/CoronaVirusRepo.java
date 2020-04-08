package com.module.repository;

import com.module.model.CoronaVirus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaVirusRepo extends JpaRepository<CoronaVirus,Long> {
}

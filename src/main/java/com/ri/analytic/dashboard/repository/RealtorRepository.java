package com.ri.analytic.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ri.analytic.dashboard.entity.Realtor;

@Repository("realtorRepository")
public interface RealtorRepository extends JpaRepository<Realtor, Long>{

}

package com.example.masterwork.repositories;

import com.example.masterwork.entities.PrintPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrintPlanRepository extends CrudRepository<PrintPlan, Long> {
    List<PrintPlan> findAll();
}

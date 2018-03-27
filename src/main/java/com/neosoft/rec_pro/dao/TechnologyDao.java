package com.neosoft.rec_pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.rec_pro.model.Department;
import com.neosoft.rec_pro.model.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> 
{

}

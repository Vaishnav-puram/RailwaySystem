package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.RailType;
import com.app.pojos.Railway;

@Repository
public interface RailwayDao extends JpaRepository<Railway, Long> {
	List<Railway> findByRailType(RailType railType);
}

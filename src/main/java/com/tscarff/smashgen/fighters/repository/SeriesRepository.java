package com.tscarff.smashgen.fighters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tscarff.smashgen.fighters.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Long>{

}

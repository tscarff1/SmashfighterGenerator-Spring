package com.tscarff.smashgen.fighters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tscarff.smashgen.fighters.model.Fighter;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long>{
	public List<Fighter> findAllByOrderByCharacterNumberAsc();
	public List<Fighter> findByIdIn(long[] ids);
}

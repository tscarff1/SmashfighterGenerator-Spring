package com.tscarff.smashgen.fighters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tscarff.smashgen.fighters.model.Fighter;
import com.tscarff.smashgen.fighters.repository.FighterRepository;

@Service
public class FighterService {
	
	@Autowired
	private FighterRepository fighterRepo;
	
	public Fighter getRandomFighter() {
		List<Fighter> allFighters = fighterRepo.findAll();
		int randomInd = (int) (Math.random() * allFighters.size());
		return allFighters.get(randomInd);
	}
	
	public Fighter getRandomFighterIn(long[] ids) {
		 List<Fighter> fighters = fighterRepo.findByIdIn(ids);
		 int randomInd = (int) (Math.random() * fighters.size());
		 return fighters.get(randomInd);
	}
}

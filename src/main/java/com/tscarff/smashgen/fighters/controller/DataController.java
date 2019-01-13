package com.tscarff.smashgen.fighters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tscarff.smashgen.fighters.model.Fighter;
import com.tscarff.smashgen.fighters.repository.FighterRepository;
import com.tscarff.smashgen.fighters.repository.SeriesRepository;

@RestController
@RequestMapping("/api/data")
public class DataController {
//	@Autowired
//	private FighterService fighterService;
//	@Autowired
//	private SeriesService seriesService;
	@Autowired
	private FighterRepository fighterRepo;
	@Autowired
	private SeriesRepository seriesRepo;
	
	@GetMapping("/fighters")
	public List<Fighter> listAllFighters() {
		return fighterRepo.findAllByOrderByCharacterNumberAsc();
	}
}

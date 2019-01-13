package com.tscarff.smashgen.fighters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tscarff.smashgen.fighters.model.Fighter;
import com.tscarff.smashgen.fighters.service.FighterService;

@RestController
@RequestMapping("/api/random")
public class RandomizerController {
	
	@Autowired
	private FighterService fighterService;
	
	@GetMapping("/single")
	public Fighter getSingleRandomFighter() {
		return fighterService.getRandomFighter();
	}
	
	@PostMapping("/single/in")
	public Fighter getSingleRandomFighterIn(@RequestBody long[] fighterIds) {
		return fighterService.getRandomFighterIn(fighterIds);
	}
}

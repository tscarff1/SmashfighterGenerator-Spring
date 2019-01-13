package com.tscarff.smashgen.fighters.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="fighter")
public class Fighter {
	@Id @GeneratedValue 
	private long id;
	
	@Column
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="series_id")
	@NotNull
	@JsonIgnore
	private Series series;
	
	@OneToOne
	@JoinColumn(name="echo_id")
	private Fighter echo;
	
	@Column
	private int characterNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Fighter getEcho() {
		return echo;
	}

	public void setEcho(Fighter echo) {
		this.echo = echo;
	}

	public int getCharacterNumber() {
		return characterNumber;
	}

	public void setCharacterNumber(int characterNumber) {
		this.characterNumber = characterNumber;
	}
	
	@JsonGetter("series")
	public String getSeriesName() {
		return series.getName();
	}
}

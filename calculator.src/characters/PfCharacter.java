/* This Program calculates the DPR (Damage per Round) of a Character from the fantasy role-playing game Pathfinder.
 * Copyright (C) 2017  Konrad Sch�n
 * This file is subject to the terms and conditions defined in file 'COPYING.txt', which is part of this source code package. 
 */

package characters;

import java.util.ArrayList;

import attacks.Attack;
import attacks.FullRound;
import weapons.Weapon;

// TODO: Auto-generated Javadoc
/**
 * The Class PfCharacter.
 */
public class PfCharacter {
	private String name;
	private int bab;
	private int str;
	private int dex;
	private ArrayList<FullRound> fullRounds = new ArrayList<>();
	private ArrayList<Weapon> weapons = new ArrayList<>();
	private ArrayList<String> feats = new ArrayList<>();

	/**
	 * Instantiates a new pf character.
	 *
	 * @param name the name
	 * @param bab the bab
	 * @param str the str
	 * @param dex the dex
	 */
	public PfCharacter(String name, int bab, int str, int dex) {
		this.name = name;
		this.bab = bab;
		this.str = str;
		this.dex = dex;
	}

	/**
	 * Adds the full round.
	 *
	 * @param name the name
	 * @param usedWeapons the used weapons
	 * @param fullRound the full round
	 */
	public void addFullRound(String name, ArrayList<Weapon> usedWeapons, boolean fullRound) {
		FullRound newFullRound = new FullRound(name);
		int hitmod;
		int dmgmod = (str - 10) / 2;
		if (feats.contains("Weapon Finesse"))
			hitmod = (dex - 10) / 2;
		else
			hitmod = (str - 10) / 2;

		for (Weapon weapon : usedWeapons) {
			Attack attack = new Attack(hitmod, dmgmod, bab, weapon, fullRound);
			newFullRound.addAttack(attack);
		}

		fullRounds.add(newFullRound);
	}

	/**
	 * Adds the buff.
	 *
	 * @param buffname the buffname
	 */
	public void addBuff(String buffname) {
		switch (buffname) {
		case ("Haste"): {
			for (FullRound fullround : fullRounds) {
				for (Attack attack : fullround.getAttacks()) {
					if (attack.isFullRound())
						attack.addFullBabAttack();
				}
			}

		}
		}
	}
	
	/**
	 * Adds the weapon.
	 *
	 * @param weapon the weapon
	 */
	public void addWeapon(Weapon weapon){
		determineFeatInfluence(weapon);
	}

	/*
	 * 
	 */
	private void determineFeatInfluence(Weapon weapon) {
		// TODO Auto-generated method stub
		switch(weapon.getType()){
		case(0):{
			for(String feat:feats){
				switch(feat){
				case(""):;
				}
			}
		}
		}
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the bab.
	 *
	 * @return the bab
	 */
	public int getBab() {
		return bab;
	}

	/**
	 * Gets the str.
	 *
	 * @return the str
	 */
	public int getStr() {
		return str;
	}

	/**
	 * Gets the dex.
	 *
	 * @return the dex
	 */
	public int getDex() {
		return dex;
	}

	/**
	 * Gets the full rounds.
	 *
	 * @return the full rounds
	 */
	public ArrayList<FullRound> getFullRounds() {
		return fullRounds;
	}

	/**
	 * Gets the feats.
	 *
	 * @return the feats
	 */
	public ArrayList<String> getFeats() {
		return feats;
	}

}

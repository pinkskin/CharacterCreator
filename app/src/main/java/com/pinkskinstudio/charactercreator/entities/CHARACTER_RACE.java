package com.pinkskinstudio.charactercreator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "CHARACTER_RACE",
        indices = {@Index(value = {"race_name"},
        unique = true)}) // @Entity(primaryKeys = {"firstName", "lastName"})
public class CHARACTER_RACE {
    // You can autogenerate unique keys by annotating the primary key as follows:
    /*@PrimaryKey(autoGenerate = true)
    private int id;*/
    // use @ColumnInfo(name = "word") for a different column name
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int race_ID; // alt + insert for getters and setters

    @NonNull
    private String race_name;

    @NonNull
    private String race_description;

    private String race_bonus;

    private int strength_bonus;
    private int dexterity_bonus;
    private int constitution_bonus;
    private int intelligence_bonus;
    private int wisdom_bonus;
    private int charisma_bonus;
    private String proficiency_bonus;
    private String weapon_proficiency;
    private String armor_proficiency;
    private String known_spells;
    private int speed;

    public CHARACTER_RACE(@NonNull String race_name, @NonNull String race_description) {
        this.race_name = race_name;
        this.race_description = race_description;
    }


    public int getRace_ID() {
        return race_ID;
    }

    public void setRace_ID(int race_ID) {
        this.race_ID = race_ID;
    }

    @NonNull
    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(@NonNull String race_name) {
        this.race_name = race_name;
    }

    @NonNull
    public String getRace_description() {
        return race_description;
    }

    public void setRace_description(@NonNull String race_description) {
        this.race_description = race_description;
    }

    public String getRace_bonus() {
        return race_bonus;
    }

    public void setRace_bonus(String race_bonus) {
        this.race_bonus = race_bonus;
    }

    public int getStrength_bonus() {
        return strength_bonus;
    }

    public void setStrength_bonus(int strength_bonus) {
        this.strength_bonus = strength_bonus;
    }

    public int getDexterity_bonus() {
        return dexterity_bonus;
    }

    public void setDexterity_bonus(int dexterity_bonus) {
        this.dexterity_bonus = dexterity_bonus;
    }

    public int getConstitution_bonus() {
        return constitution_bonus;
    }

    public void setConstitution_bonus(int constitution_bonus) {
        this.constitution_bonus = constitution_bonus;
    }

    public int getIntelligence_bonus() {
        return intelligence_bonus;
    }

    public void setIntelligence_bonus(int intelligence_bonus) {
        this.intelligence_bonus = intelligence_bonus;
    }

    public int getWisdom_bonus() {
        return wisdom_bonus;
    }

    public void setWisdom_bonus(int wisdom_bonus) {
        this.wisdom_bonus = wisdom_bonus;
    }

    public int getCharisma_bonus() {
        return charisma_bonus;
    }

    public void setCharisma_bonus(int charisma_bonus) {
        this.charisma_bonus = charisma_bonus;
    }

    public String getProficiency_bonus() {
        return proficiency_bonus;
    }

    public void setProficiency_bonus(String proficiency_bonus) {
        this.proficiency_bonus = proficiency_bonus;
    }

    public String getWeapon_proficiency() {
        return weapon_proficiency;
    }

    public void setWeapon_proficiency(String weapon_proficiency) {
        this.weapon_proficiency = weapon_proficiency;
    }

    public String getArmor_proficiency() {
        return armor_proficiency;
    }

    public void setArmor_proficiency(String armor_proficiency) {
        this.armor_proficiency = armor_proficiency;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getKnown_spells() {
        return known_spells;
    }

    public void setKnown_spells(String known_spells) {
        this.known_spells = known_spells;
    }
}

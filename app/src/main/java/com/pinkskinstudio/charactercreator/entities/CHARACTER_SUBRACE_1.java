package com.pinkskinstudio.charactercreator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

// @Entity(primaryKeys = {"firstName", "lastName"})
@Entity(tableName = "CHARACTER_SUBRACE_1",
        indices = {@Index(value = {"subrace_name"},
                unique = true)},
        foreignKeys = {
                @ForeignKey(entity = CHARACTER_RACE.class,
                        parentColumns = "race_name",
                        childColumns = "subrace_parent",
                        onDelete = ForeignKey.CASCADE)}
) // @Entity(primaryKeys = {"firstName", "lastName"})
public class CHARACTER_SUBRACE_1 {
    // You can autogenerate unique keys by annotating the primary key as follows:
    /*@PrimaryKey(autoGenerate = true)
    private int id;*/
    // use @ColumnInfo(name = "word") for a different column name
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int subrace_1_ID; // alt + insert for getters and setters
    @NonNull
    private String subrace_name;
    @NonNull
    private String subrace_parent;
    @NonNull
    private String subrace_description;
    private String subrace_bonus;
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

    public CHARACTER_SUBRACE_1(@NonNull String subrace_name, @NonNull String subrace_description,
                               @NonNull String subrace_parent) {
        this.subrace_name = subrace_name;
        this.subrace_description = subrace_description;
        this.subrace_parent = subrace_parent;
    }

    public int getSubrace_1_ID() {
        return subrace_1_ID;
    }

    public void setSubrace_1_ID(int subrace_1_ID) {
        this.subrace_1_ID = subrace_1_ID;
    }

    @NonNull
    public String getSubrace_name() {
        return subrace_name;
    }

    public void setSubrace_name(@NonNull String subrace_name) {
        this.subrace_name = subrace_name;
    }

    public String getSubrace_parent() {
        return subrace_parent;
    }

    public void setSubrace_parent(String subrace_parent) {
        this.subrace_parent = subrace_parent;
    }

    @NonNull
    public String getSubrace_description() {
        return subrace_description;
    }

    public void setSubrace_description(@NonNull String subrace_description) {
        this.subrace_description = subrace_description;
    }

    public String getSubrace_bonus() {
        return subrace_bonus;
    }

    public void setSubrace_bonus(String subrace_bonus) {
        this.subrace_bonus = subrace_bonus;
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

    public String getKnown_spells() {
        return known_spells;
    }

    public void setKnown_spells(String known_spells) {
        this.known_spells = known_spells;
    }
}

package com.pinkskinstudio.charactercreator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table"/*,
        foreignKeys = {
            @ForeignKey(entity = CHARACTER_RACE.class,
                        parentColumns = "race_name",
                        childColumns = "character_race_name",
                        onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = Class_RPG.class,
                        parentColumns = "class_name",
                        childColumns = "character_class_name",
                        onDelete = ForeignKey.CASCADE)}
        */) // @Entity(primaryKeys = {"firstName", "lastName"})
public class Character_RPG {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "character_ID")
    private int characterID;

    @ColumnInfo(name = "character_level")
    private int characterLevel;

    @ColumnInfo(name = "character_name")
    private String characterName;

    @ColumnInfo(name = "character_race_name")
    private String raceName;

    @ColumnInfo(name = "character_class_name")
    private String className;

    @ColumnInfo(name = "character_strength_score")
    private int strengthScore;
    @ColumnInfo(name = "character_dexterity_score")
    private int dexterityScore;
    @ColumnInfo(name = "character_constitution_score")
    private int constitutionScore;
    @ColumnInfo(name = "character_intelligence_score")
    private int intelligenceScore;
    @ColumnInfo(name = "character_wisdom_score")
    private int wisdomScore;
    @ColumnInfo(name = "character_charisma_score")
    private int charismaScore;
    @ColumnInfo(name = "character_strength_modifier")
    private int strengthModifier;
    @ColumnInfo(name = "character_dexterity_modifier")
    private int dexterityModifier;
    @ColumnInfo(name = "character_constitution_modifier")
    private int constitutionModifier;
    @ColumnInfo(name = "character_intelligence_modifier")
    private int intelligenceModifier;
    @ColumnInfo(name = "character_wisdom_modifier")
    private int wisdomModifier;
    @ColumnInfo(name = "character_charisma_modifier")
    private int charismaModifier;

    private int hitPointMaximum;
    private int armorClass;
    private int initiative;
    private int speed;
    private int passivePerception;
    private int proficiencyBonus;
    private String proficiencies;
    private String spells;
    private String equipment;
    private String background;
    private String notes;

    // Constructor
    public Character_RPG(String characterName) {
        this.characterName = characterName;
    }

    // Getters
    public int getCharacterLevel() { return characterLevel; }
    public int getCharacterID() {
        return characterID;
    }
    public String getCharacterName() {
        return characterName;
    }
    public String getRaceName() {
        return raceName;
    }
    public String getClassName() {
        return className;
    }
    public int getStrengthScore() { return strengthScore; }
    public int getDexterityScore() { return dexterityScore; }
    public int getConstitutionScore() { return constitutionScore; }
    public int getIntelligenceScore() { return intelligenceScore; }
    public int getWisdomScore() { return wisdomScore; }
    public int getCharismaScore() { return charismaScore; }
    public int getStrengthModifier() { return strengthModifier; }
    public int getDexterityModifier() { return dexterityModifier; }
    public int getConstitutionModifier() { return constitutionModifier; }
    public int getIntelligenceModifier() { return intelligenceModifier; }
    public int getWisdomModifier() { return wisdomModifier; }
    public int getCharismaModifier() { return charismaModifier; }
    public int getHitPointMaximum() { return hitPointMaximum; }
    public int getArmorClass() { return armorClass; }
    public int getInitiative() { return initiative; }
    public int getSpeed() { return speed; }
    public int getPassivePerception() { return passivePerception; }
    public int getProficiencyBonus() { return proficiencyBonus; }
    public String getProficiencies() { return proficiencies; }
    public String getSpells() { return spells; }
    public String getEquipment() { return equipment; }
    public String getBackground() { return background; }
    public String getNotes() { return notes; }

    // Setters
    public void setCharacterLevel(int characterLevel) { this.characterLevel = characterLevel; }
    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public void setStrengthScore(int strengthScore) { this.strengthScore = strengthScore; }
    public void setDexterityScore(int dexterityScore) { this.dexterityScore = dexterityScore; }
    public void setConstitutionScore(int constitutionScore) { this.constitutionScore = constitutionScore; }
    public void setIntelligenceScore(int intelligenceScore) { this.intelligenceScore = intelligenceScore; }
    public void setWisdomScore(int wisdomScore) { this.wisdomScore = wisdomScore; }
    public void setCharismaScore(int charismaScore) { this.charismaScore = charismaScore; }
    public void setStrengthModifier(int strengthModifier) { this.strengthModifier = strengthModifier; }
    public void setDexterityModifier(int dexterityModifier) { this.dexterityModifier = dexterityModifier; }
    public void setConstitutionModifier(int constitutionModifier) { this.constitutionModifier = constitutionModifier; }
    public void setIntelligenceModifier(int intelligenceModifier) { this.intelligenceModifier = intelligenceModifier; }
    public void setWisdomModifier(int wisdomModifier) { this.wisdomModifier = wisdomModifier; }
    public void setCharismaModifier(int charismaModifier) { this.charismaModifier = charismaModifier; }
    public void setHitPointMaximum(int hitPointMaximum) { this.hitPointMaximum = hitPointMaximum; }
    public void setArmorClass(int armorClass) { this.armorClass = armorClass; }
    public void setInitiative(int initiative) { this.initiative = initiative; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setPassivePerception(int passivePerception) { this.passivePerception = passivePerception; }
    public void setProficiencyBonus(int proficiencyBonus) { this.proficiencyBonus = proficiencyBonus; }
    public void setProficiencies(String proficiencies) { this.proficiencies = proficiencies; }
    public void setSpells(String spells) { this.spells = spells; }
    public void setEquipment(String equipment) { this.equipment = equipment; }
    public void setBackground(String background) { this.background = background; }
    public void setNotes(String notes) { this.notes = notes; }
}
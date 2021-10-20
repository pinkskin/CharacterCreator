package com.pinkskinstudio.charactercreator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "class_table")
public class Class_RPG {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "class_name")
    private String className;

    @ColumnInfo(name = "class_bonus")
    private String classBonus;

    public Class_RPG(@NonNull String className, @NonNull String classBonus) {
        this.className = className;
        this.classBonus = classBonus;
    }


    public String getClassName() {
        return className;
    }

    public String getClassBonus() {
        return classBonus;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassBonus(String classBonus) {
        this.classBonus = classBonus;
    }
}

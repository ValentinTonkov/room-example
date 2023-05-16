package com.example.databaseexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity (tableName = "word_table")
public class Word {
    @PrimaryKey
    @NotNull
    @ColumnInfo (name = "word")
    private final String word;

    public Word(@NonNull String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}

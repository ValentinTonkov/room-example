package com.example.databaseexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word... words);

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Delete
    void deleteWord(Word word);
}

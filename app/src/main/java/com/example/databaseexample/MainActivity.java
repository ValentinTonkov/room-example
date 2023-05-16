package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.databaseexample.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WordViewModel viewModel = new ViewModelProvider(this).get(WordViewModel.class);

        LiveData<List<Word>> allWords = viewModel.getAllWords();

        allWords.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder builder = new StringBuilder();
                for (Word word : words){
                    builder.append(word.getWord()).append(" \n");
                }
                binding.textView.setText(builder.toString());
            }
        });

        binding.button.setOnClickListener(v -> {
            String newWord = binding.textInput.getText().toString();
            Word word = new Word(newWord);
            viewModel.insert(word);
        });
    }
}
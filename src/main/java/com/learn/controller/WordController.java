package com.learn.controller;

import com.learn.model.Word;
import com.learn.service.WordService;
import com.learn.service.impl.WordServiceImpl;
import com.learn.util.Response;
import com.learn.util.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    private WordService wordService;

    @Autowired
    public WordController(WordServiceImpl wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public Response<List<Word>> getWords() {
        List<Word> words = wordService.getWords();
        Response<List<Word>> response = new Response<>();
        if (words.size() > 0) {
            response.setData(words);
            response.setCode(RetCode.SUCCESS);
        } else {
            response.setCode(RetCode.NOT_FOUND);
            response.setMsg("there are no words");
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response<Word> getWord(@PathVariable("id") long id) {
        Word word = wordService.getWord(id);
        Response<Word> response = new Response<>();
        if (word != null) {
            response.setCode(RetCode.SUCCESS);
            response.setData(word);
        } else {
            response.setCode(RetCode.NOT_FOUND);
            response.setMsg("word not exists");
        }
        return response;
    }

    @PostMapping
    public Response<Long> addWord(@RequestBody Word word) {
        long wordId = wordService.addWord(word);
        Response<Long> response = new Response<>();
        if (wordId > 0) {
            response.setData(wordId);
            response.setCode(RetCode.SUCCESS);
        } else {
            response.setData(-1L);
            response.setCode(RetCode.ERROR);
            response.setMsg("add word fail");
        }
        return response;
    }
}

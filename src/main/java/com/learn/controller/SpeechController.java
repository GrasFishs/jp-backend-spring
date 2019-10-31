package com.learn.controller;

import com.learn.model.Speech;
import com.learn.service.SpeechService;
import com.learn.service.impl.SpeechServiceImpl;
import com.learn.util.Response;
import com.learn.util.RetCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/speech")
public class SpeechController {

    private SpeechService speechService;


    @Autowired
    public SpeechController(SpeechServiceImpl speechService) {
        this.speechService = speechService;
    }

    @PostMapping
    public Response<Integer> addSpeech(@RequestBody Speech speech) {
        speechService.addSpeech(speech);
        int id = speech.getId();
        Response<Integer> response = new Response<>();
        if (id > 0) {
            response.setData(id);
            response.setCode(RetCode.SUCCESS);
        } else {
            response.setCode(RetCode.ERROR);
            response.setMsg("add speech fail");
        }
        return response;
    }
}

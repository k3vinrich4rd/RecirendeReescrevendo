package com.example.miniProjetoRecirende.controller;

import com.example.miniProjetoRecirende.service.EmbalagemSalgadinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(path = "/embalagens")

public class EmbalagemSalgadinhoController {

    @Autowired
    private EmbalagemSalgadinhoService embalagemSalgadinhoService;
}

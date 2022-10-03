package com.example.miniProjetoRecirende.service;

import com.example.miniProjetoRecirende.repository.IEmbalagemSalgadinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmbalagemSalgadinhoService {

    @Autowired
    private IEmbalagemSalgadinhoRepository iEmbalagemSalgadinhoRepository;
}

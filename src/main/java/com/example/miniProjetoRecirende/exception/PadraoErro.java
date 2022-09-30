package com.example.miniProjetoRecirende.exception;

import java.io.Serializable;
import java.time.Instant;

public class PadraoErro implements Serializable {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}

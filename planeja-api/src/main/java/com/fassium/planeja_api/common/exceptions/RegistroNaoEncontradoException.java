package com.fassium.planeja_api.common.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException {
    public RegistroNaoEncontradoException() {
        super("Registro não encontrado.");
    }
}
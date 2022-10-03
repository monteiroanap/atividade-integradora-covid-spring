package br.com.covid.spring03.exceptions;

public class NomeSintomaNaoEncontradoException extends Exception{
    public NomeSintomaNaoEncontradoException(String message) {
        super(message);
    }
}

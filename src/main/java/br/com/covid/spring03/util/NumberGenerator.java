package br.com.covid.spring03.util;

public class NumberGenerator {
    private int sintoma;
    private int pessoa;
    private final static NumberGenerator instance = new NumberGenerator();
    private NumberGenerator(){

    }
    public static NumberGenerator getInstance(){
        return instance;
    }
    public int proximoSintoma(){
        return ++sintoma;
    }
    public int proximaPessoa(){
        return ++pessoa;
    }
}



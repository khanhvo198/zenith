package com.mystic.zenith.shared.exception;

public class TakenException extends RuntimeException{
    public TakenException() {
        super("taken");
    }
}

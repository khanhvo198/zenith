package com.mystic.zenith.shared.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("not found");
    }
}

package com.github.ssullivan.jcompose.exceptions;

public class UnsupportedSyntaxException extends RuntimeException {
    private String _syntax;

    public UnsupportedSyntaxException(String syntax) {
        _syntax = syntax;
    }

    public String getSyntax() {
        return _syntax;
    }
}

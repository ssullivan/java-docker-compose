package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

public class ComposeFileReader {
    private ObjectReader _objectReader;

    public ComposeFileReader() {
        _objectReader = Jackson.objectReader();
    }

    public ComposeFile read(String inputStream) throws IOException {
        return _objectReader.readValue(inputStream);
    }
}

package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by catal on 6/29/2017.
 */
public class ComposeFileReader {
    private ObjectReader _objectReader;

    public ComposeFileReader() {
        _objectReader = Jackson.objectReader();
    }

    public ComposeFile read(String inputStream) throws IOException {
        return _objectReader.readValue(inputStream);
    }
}

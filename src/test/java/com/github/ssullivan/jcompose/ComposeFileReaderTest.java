package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.Test;

import java.io.IOException;

import static com.github.ssullivan.jcompose.FixtureUtil.fixture;

/**
 * Created by catal on 6/29/2017.
 */
public class ComposeFileReaderTest {

    @Test
    public void testReadVersion() throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        ObjectMapper objectMapper = new ObjectMapper(yamlMapper.getFactory());
        ComposeFile composeFile = objectMapper.readValue(fixture("fixtures/v3/docker-compose_versionOnly.yml"), ComposeFile.class);

        int k = 0;
    }
}

package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.github.ssullivan.jcompose.FixtureUtil.fixture;

/**
 * Created by catal on 6/29/2017.
 */
public class ComposeFileReaderTest {

    @Test
    public void testReadVersion() throws IOException {
        ComposeFileReader reader = new ComposeFileReader();
        ComposeFile composeFile = reader.read(fixture("fixtures/v3/docker-compose_versionOnly.yml"));
        Assert.assertNotNull(composeFile);
        Assert.assertEquals(composeFile.version(), "3");
    }
}

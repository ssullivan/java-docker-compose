package com.github.ssullivan.jcompose;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.github.ssullivan.jcompose.FixtureUtil.fixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by catal on 6/29/2017.
 */
public class ComposeFileReaderTest {
    @Test
    public void testReadVersionOnly() throws IOException {
        ComposeFileReader reader = new ComposeFileReader();
        ComposeFile composeFile = reader.read(fixture("fixtures/v3/docker-compose_versionOnly.yml"));
        assertThat(composeFile, notNullValue());
        assertThat(composeFile.version(), equalTo("3"));
    }

    @Test
    public void testReadServices() throws IOException {
        ComposeFileReader reader = new ComposeFileReader();
        ComposeFile composeFile = reader.read(fixture("fixtures/v3/docker-compose_services.yml"));
        assertThat(composeFile, notNullValue());
        assertThat(composeFile.version(), equalTo("3"));

        assertThat(composeFile.services(), notNullValue());
    }
}

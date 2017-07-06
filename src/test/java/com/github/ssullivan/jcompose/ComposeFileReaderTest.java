package com.github.ssullivan.jcompose;

import com.google.common.util.concurrent.Futures;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.github.ssullivan.jcompose.FixtureUtil.fixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        assertThat(composeFile.services().keySet(), contains("foo", "bar"));

        final ServiceSpec foo = composeFile.services().get("foo");

        assertThat(foo.image(), equalTo("redis"));
        assertThat(foo.deploy(), notNullValue());

        final Deploy fooDeploy = foo.deploy();
        assertThat(fooDeploy.replicas(), equalTo(1));
        assertThat(fooDeploy.updateConfig(), notNullValue());
        assertThat(fooDeploy.updateConfig().parallelism(), equalTo(2));
        assertThat(fooDeploy.updateConfig().delay(), equalTo("10s"));

        assertThat(fooDeploy.restartPolicy(), notNullValue());
        assertThat(fooDeploy.restartPolicy().condition(), equalTo("on-failure"));

        assertThat(foo.networks(), contains("frontend", "backend"));
        assertThat(composeFile.services(), notNullValue());

        assertThat(fooDeploy.placement(), notNullValue());
        assertThat(fooDeploy.placement().constraints(), contains("node.role == database"));

        assertThat(fooDeploy.labels(), notNullValue());
        assertThat(fooDeploy.labels().get("foo"), equalTo("bar"));

        assertThat(fooDeploy.resources().limits().cpus(), allOf(greaterThan(0.0), lessThanOrEqualTo(0.001)));
        assertThat(fooDeploy.resources().limits().memory(), equalTo("50M"));

        assertThat(fooDeploy.resources().reservations().cpus(), allOf(greaterThan(0.0), lessThanOrEqualTo( 0.00001)));
        assertThat(fooDeploy.resources().reservations().memory(), equalTo("20M"));

        final ServiceSpec bar = composeFile.services().get("bar");
        assertThat(bar.deploy().mode(), equalTo("global"));
        assertThat(bar.image(), equalTo("tomcat"));
        assertThat(bar.deploy().replicas(), equalTo(6));
        assertThat(bar.networks(), contains("frontend", "backend"));
    }
}

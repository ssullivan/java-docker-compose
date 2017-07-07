package com.github.ssullivan.jcompose;

import com.spotify.docker.client.DockerClient;

/**
 * Created by catal on 7/6/2017.
 */
public class StackClient {
    private DockerClient _dockerClient;

    public StackClient(DockerClient dockerClient) {
        _dockerClient = dockerClient;
    }

    public void deploy(ComposeFile composeFile) {

    }
}

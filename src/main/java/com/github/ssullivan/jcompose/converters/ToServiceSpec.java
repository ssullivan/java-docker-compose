package com.github.ssullivan.jcompose.converters;

import com.github.ssullivan.jcompose.ServiceSpec;
import com.google.common.collect.ImmutableList;
import com.spotify.docker.client.messages.swarm.EndpointSpec;
import com.spotify.docker.client.messages.swarm.ServiceMode;

import java.util.List;
import java.util.Map;

/**
 * Created by catal on 7/6/2017.
 */
public class ToServiceSpec implements IConverter<Map<String, ServiceSpec>, List<com.spotify.docker.client.messages.swarm.ServiceSpec>> {
    private static final String GLOBAL = "global";

    @Override
    public List<com.spotify.docker.client.messages.swarm.ServiceSpec> convert(Map<String, ServiceSpec> services) {
        ImmutableList.Builder<com.spotify.docker.client.messages.swarm.ServiceSpec> builder = ImmutableList.builder();
        services.entrySet()
                .stream()
                .map(entry -> convert(entry.getKey(), entry.getValue()))
                .forEach(builder::add);
        return builder.build();
    }

    /**
     * Builds a spotify {@link com.spotify.docker.client.messages.swarm.ServiceSpec} from {@link ServiceSpec}
     * @param name the name of the service
     * @param serviceSpec the source ServiceSpec from the yaml
     * @return a new spotify ServiceSpec
     */
    private com.spotify.docker.client.messages.swarm.ServiceSpec convert(final String name, final ServiceSpec serviceSpec) {
        com.spotify.docker.client.messages.swarm.ServiceSpec.Builder builder = com.spotify.docker.client.messages.swarm.ServiceSpec
                .builder()
                .name(name)
                .labels(serviceSpec.deploy().labels());

        if (GLOBAL.equalsIgnoreCase(serviceSpec.deploy().mode()))
            builder.mode(ServiceMode.withGlobal());
        else
            builder.mode(ServiceMode.withReplicas(serviceSpec.deploy().replicas()));

        return builder.build();
    }
}

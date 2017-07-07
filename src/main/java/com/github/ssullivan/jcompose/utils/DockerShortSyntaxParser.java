package com.github.ssullivan.jcompose.utils;

import com.github.ssullivan.jcompose.PortConfig;
import com.github.ssullivan.jcompose.exceptions.UnsupportedSyntaxException;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DockerShortSyntaxParser {
    private static final Pattern SINGLE_CONTAINER_PORT = Pattern.compile("^(?<container>\\d+)(?<proto>(?:/tcp|/udp))?$");
    private static final Pattern SINGLE_HOST_CONTAINER_PORTS = Pattern.compile("^(?<host>\\d+):(?<container>\\d+)(?<proto>(?:/tcp|/udp))$");
    private static final Pattern RANGE_HOST_CONTAINER_PORTS = Pattern.compile("^(?<hostRangeStart>\\d+)-(?<hostRangeEnd>\\d+):(?<containerRangeStart>\\d+)-(?<containerRangeEnd>\\d+)(?<proto>(?:/tcp|/udp))$");
    private static final Pattern RANGE_HOST_INTERFACE_CONTAINER_PORTS = Pattern.compile("^(?<interface>.+?):(?<hostRangeStart>\\d+)-(?<hostRangeEnd>\\d+):(?<containerRangeStart>\\d+)-(?<containerRangeEnd>\\d+)(?<proto>(?:/tcp|/udp))");

    private DockerShortSyntaxParser() {

    }

    // Cases we need to cover
    // - 8080
    // - 8080:80
    // - 9090-9091:8080-8081
    // - 127.0.0.1:9090-9091:8080-8081
    // - 127.0.0.1:9090:8080
    // - 8060:8060/udp
    // - 8060:8060/tcp

    public static PortConfig parse(final String source) throws IOException {
        Matcher matcher;
        final PortConfig.Builder builder = PortConfig.builder();

        if ((matcher = SINGLE_CONTAINER_PORT.matcher(source)).matches()) {
            builder
                    .mode("host")
                    .target(Integer.parseInt(matcher.group("container")));

            addProto(builder, matcher.group("proto"));
            return builder.build();
        }

        if ((matcher = SINGLE_HOST_CONTAINER_PORTS.matcher(source)).matches()) {
            builder
                    .mode("ingress")
                    .published(Integer.parseInt(matcher.group("host")))
                    .target(Integer.parseInt(matcher.group("container")));

            addProto(builder, matcher.group("proto"));
            return builder.build();
        }
        else if ((matcher = RANGE_HOST_CONTAINER_PORTS.matcher(source)).matches()) {
            throw new UnsupportedSyntaxException(source);
        }
        else  if ((matcher = RANGE_HOST_INTERFACE_CONTAINER_PORTS.matcher(source)).matches()) {
            throw new UnsupportedSyntaxException(source);
        }
        throw new IOException("Failed to parser shorthand syntax '" + source + "'");
    }

    private static PortConfig.Builder addProto(PortConfig.Builder builder, final String proto) {
        if (null == proto || proto.isEmpty()) return builder;
        return builder.protocol(proto);
    }
}

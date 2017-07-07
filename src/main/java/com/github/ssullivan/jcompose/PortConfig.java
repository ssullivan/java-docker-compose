package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ssullivan.jcompose.utils.DockerShortSyntaxParser;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

import java.io.IOException;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class PortConfig {
    /**
     * the port inside the container
     * @return a positive integer that 0 > port <= 65536
     */
    @Nullable
    @JsonProperty("target")
    public abstract Integer target();

    @Nullable
    @JsonProperty("published")
    public abstract Integer published();

    @Nullable
    @JsonProperty("protocol")
    public abstract String protocol();

    @Nullable
    @JsonProperty("mode")
    public abstract String mode();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder target(Integer target);

        public abstract Builder published(Integer published);

        public abstract Builder protocol(String protocol);

        public abstract Builder mode(String mode);

        public abstract PortConfig build();
    }

    public static Builder builder() {
        return new AutoValue_PortConfig.Builder();
    }

    @JsonCreator
    static PortConfig create(@JsonProperty("target") Integer target,
                             @JsonProperty("published") Integer published,
                             @JsonProperty("protocol") String protocol,
                             @JsonProperty("mode") String mode) {
        return builder()
                .target(target)
                .published(published)
                .protocol(protocol)
                .mode(mode)
                .build();
    }

    @JsonCreator
    static PortConfig create(String shortHandPortSyntax) throws IOException {
        return DockerShortSyntaxParser.parse(shortHandPortSyntax);
    }

    @JsonCreator
    static PortConfig create(Integer containerPort) {
        return builder().target(containerPort).build();
    }
}

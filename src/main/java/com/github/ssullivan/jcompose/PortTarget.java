package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class PortTarget {
    /**
     * the port inside the container
     * @return a positive integer that 0 > port <= 65536
     */
    @JsonProperty("target")
    public abstract Integer target();

    @JsonProperty("published")
    public abstract Integer published();

    @JsonProperty("protocol")
    public abstract String protocol();

    @JsonProperty("mode")
    public abstract String mode();

    @JsonCreator
    static PortTarget create(@JsonProperty("target") Integer target,
                             @JsonProperty("published") Integer published,
                             @JsonProperty("protocol") String protocol,
                             @JsonProperty("mode") String mode) {
        return new AutoValue_PortTarget(target, published, protocol, mode);
    }

    @JsonCreator
    static PortTarget create(String portTarget) {
        return new AutoValue_PortTarget(0, 0, "tcp", "ingress");
    }
}

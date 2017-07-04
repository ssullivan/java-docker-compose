package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nullable;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class ComposeFile {
    @JsonProperty("version")
    public abstract String version();

    @Nullable
    @JsonProperty("services")
    public abstract ImmutableMap<String, ServiceSpec> services();

    @JsonCreator
    static ComposeFile create(@JsonProperty("version") final String version,
                                        @JsonProperty("services") Map<String, ServiceSpec> services) {
        if (services != null)
            return new AutoValue_ComposeFile(version, ImmutableMap.copyOf(services));
        return new AutoValue_ComposeFile(version, null);
    }
}

package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class Resources {
    @Nullable
    @JsonProperty("cpus")
    public abstract Double cpus();

    @Nullable
    @JsonProperty("memory")
    public abstract String memory();

    @JsonCreator
    static Resources create(@JsonProperty("cpus") Double cpus, @JsonProperty("memory") String memory) {
        return new AutoValue_Resources(cpus, memory);
    }
}

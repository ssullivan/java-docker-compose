package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class UpdateConfig {
    @Nullable
    @JsonProperty("parallelism")
    public abstract Integer parallelism();

    @Nullable
    @JsonProperty("delay")
    public abstract String delay();

    @JsonProperty(value = "failure_action", defaultValue = "pause")
    public abstract String failureAction();

    @JsonProperty(value = "monitor", defaultValue = "0s")
    public abstract String monitor();

}

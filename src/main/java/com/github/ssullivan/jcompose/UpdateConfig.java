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
public abstract class UpdateConfig {
    @Nullable
    @JsonProperty("parallelism")
    public abstract Integer parallelism();

    @Nullable
    @JsonProperty("delay")
    public abstract String delay();

    @Nullable
    @JsonProperty(value = "failure_action", defaultValue = "pause")
    public abstract String failureAction();

    @Nullable
    @JsonProperty(value = "monitor", defaultValue = "0s")
    public abstract String monitor();

    @JsonCreator
    static UpdateConfig create(@JsonProperty("parallelism") Integer parallelism,
                               @JsonProperty("delay") String delay,
                               @JsonProperty("failure_action") String failureAction,
                               @JsonProperty("monitor") String monitor) {
        return new AutoValue_UpdateConfig(parallelism, delay, failureAction, monitor);
    }
}

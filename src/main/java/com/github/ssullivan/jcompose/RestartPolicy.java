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
public abstract class RestartPolicy {
    @JsonProperty(value = "condition", defaultValue = "any")
    public abstract String condition();

    @Nullable
    @JsonProperty(value = "delay", defaultValue = "0s")
    public abstract String delay();

    @Nullable
    @JsonProperty(value = "max_attempts")
    public abstract Integer maxAttempts();

    @Nullable
    @JsonProperty(value = "window")
    public abstract String window();


    @JsonCreator
    static RestartPolicy create(@JsonProperty("condition") String condition,
                                @JsonProperty("delay") String delay,
                                @JsonProperty("max_attempts") Integer maxAttempts,
                                @JsonProperty("window") String window) {
        return new AutoValue_RestartPolicy(condition, delay, maxAttempts, window);
    }
}

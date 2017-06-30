package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * Created by catal on 6/29/2017.
 */
@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class ComposeFile {
    @JsonProperty("version")
    public abstract String version();

    @JsonCreator
    static AutoValue_ComposeFile create(@JsonProperty("version") final String version) {
        return new AutoValue_ComposeFile(version);
    }
}

package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nullable;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class Service {

    @JsonProperty("image")
    public abstract String image();

    @Nullable
    @JsonProperty("networks")
    public abstract ImmutableList<String> networks();

    @Nullable
    @JsonProperty("deploy")
    public abstract Deploy deploy();

    @JsonCreator
    static Service create(@JsonProperty("image") String image,
                          @JsonProperty("networks") List<String> networks,
                          @JsonProperty("deply") Deploy deploy) {
        return new AutoValue_Service(image, ImmutableList.copyOf(networks), deploy);
    }
}

package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nullable;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * Created by catal on 7/1/2017.
 */
@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class Deploy {

    @JsonProperty("mode")
    public abstract String mode();

    @JsonProperty("replicas")
    public abstract int replicas();

    @Nullable
    @JsonProperty("update_config")
    public abstract UpdateConfig updateConfig();

    @Nullable
    @JsonProperty("placement")
    public abstract Placement placement();

    @Nullable
    @JsonProperty("labels")
    public abstract ImmutableMap<String, String> labels();


}

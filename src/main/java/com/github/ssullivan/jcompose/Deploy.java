package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import com.sun.org.apache.bcel.internal.generic.IMUL;

import javax.annotation.Nullable;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class Deploy {

    @JsonProperty(value = "mode", defaultValue = "replicated")
    public abstract String mode();

    @Nullable
    @JsonProperty(value = "replicas")
    public abstract Integer replicas();

    @Nullable
    @JsonProperty("update_config")
    public abstract UpdateConfig updateConfig();

    @Nullable
    @JsonProperty("placement")
    public abstract Placement placement();

    @Nullable
    @JsonProperty("resources")
    public abstract ResourceSpec resources();

    @Nullable
    @JsonProperty("labels")
    public abstract ImmutableMap<String, String> labels();

    static Deploy create(@JsonProperty("mode") String mode,
                         @JsonProperty("replicas") Integer replicas,
                         @JsonProperty("update_config") UpdateConfig updateConfig,
                         @JsonProperty("placement") Placement placement,
                         @JsonProperty("resources") ResourceSpec resources,
                         @JsonProperty("labels") Map<String, String> labels) {

        ImmutableMap<String, String> ilabels = null;
        if (null != labels)
            ilabels = ImmutableMap.copyOf(labels);

        return new AutoValue_Deploy(mode, replicas, updateConfig, placement, resources,
                ilabels);
    }

}

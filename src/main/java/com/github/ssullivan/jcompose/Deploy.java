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
public abstract class Deploy {

    @Nullable
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
    @JsonProperty("restart_policy")
    public abstract RestartPolicy restartPolicy();

    @Nullable
    @JsonProperty("labels")
    public abstract ImmutableMap<String, String> labels();

    @JsonCreator
    static Deploy create(@JsonProperty(value = "mode", defaultValue = "replicated") String mode,
                         @JsonProperty("replicas") Integer replicas,
                         @JsonProperty("update_config") UpdateConfig updateConfig,
                         @JsonProperty("placement") Placement placement,
                         @JsonProperty("resources") ResourceSpec resources,
                         @JsonProperty("restart_policy") RestartPolicy restartPolicy,
                         @JsonProperty("labels") Map<String, String> labels) {

        ImmutableMap<String, String> ilabels = null;
        if (null != labels)
            ilabels = ImmutableMap.copyOf(labels);

        if (null == mode)
            mode = "replicated";

        return new AutoValue_Deploy(mode, replicas, updateConfig, placement, resources,
                restartPolicy,
                ilabels);
    }

}

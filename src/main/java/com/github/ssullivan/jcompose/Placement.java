package com.github.ssullivan.jcompose;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

/**
 * Created by catal on 7/1/2017.
 */
public abstract class Placement {
    @JsonProperty("constraints")
    public abstract ImmutableList<String> constraints();
}

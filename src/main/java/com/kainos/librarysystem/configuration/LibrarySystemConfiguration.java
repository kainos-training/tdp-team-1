package com.kainos.librarysystem.configuration;

import java.util.Map;
import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

public class LibrarySystemConfiguration extends Configuration {
	
	@NotNull
    private ImmutableMap<String, ImmutableMap<String, String>> viewRendererConfiguration = ImmutableMap.of();

	@JsonProperty("viewRendererConfiguration")
    public ImmutableMap<String, ImmutableMap<String, String>> getViewRendererConfiguration() {
        return viewRendererConfiguration;
    }

    @JsonProperty("viewRendererConfiguration")
    public void setViewRendererConfiguration(Map<String, Map<String, String>> viewRendererConfiguration) {
        ImmutableMap.Builder<String, ImmutableMap<String, String>> builder = ImmutableMap.builder();
        for (Map.Entry<String, Map<String, String>> entry : viewRendererConfiguration.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
        }
        this.viewRendererConfiguration = builder.build();
    }
}

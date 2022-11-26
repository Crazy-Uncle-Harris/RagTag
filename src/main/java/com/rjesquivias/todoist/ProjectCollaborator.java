package com.rjesquivias.todoist;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
public sealed interface ProjectCollaborator permits ImmutableProjectCollaborator {
   long id();
   String name();
   String email(); 
}

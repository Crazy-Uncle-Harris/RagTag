package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Project.Builder.class)
@JsonPOJOBuilder(withPrefix = "")
public sealed interface Project permits ImmutableProject {
    @JsonProperty("id")
    String id();

    @JsonProperty("name")
    String name();

    @JsonProperty("color")
    Color color();

    @JsonProperty("parent_id")
    String parentId();

    @JsonProperty("order")
    long order();

    @JsonProperty("comment_count")
    long commentCount();

    @JsonProperty("shared")
    boolean shared();

    @JsonProperty("favorite")
    boolean favorite();

    @JsonProperty("inbox_project")
    boolean inboxProject();

    @JsonProperty("team_inbox")
    boolean teamInbox();

    @JsonProperty("sync_id")
    long syncId();

    @JsonProperty("url")
    String url();

    static Project.Builder builder() {
        return new Project.Builder();
    }

    final class Builder extends ImmutableProject.Builder {
        Builder() {
        }
    }
}

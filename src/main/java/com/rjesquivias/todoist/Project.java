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
        overshadowImplementation = true,
        jdkOnly = true
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

    @JsonProperty("is_shared")
    boolean isShared();

    @JsonProperty("is_favorite")
    boolean isFavorite();

    @JsonProperty("is_inbox_project")
    boolean isInboxProject();

    @JsonProperty("is_team_inbox")
    boolean isTeamInbox();

    @JsonProperty("view_style")
    String viewStyle();

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

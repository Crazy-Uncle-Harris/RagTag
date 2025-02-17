package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true,
        jdkOnly = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
public sealed interface Comment permits ImmutableComment {
    String id();

    @JsonProperty("task_id")
    String taskId();

    @JsonProperty("project_id")
    String projectId();

    @JsonProperty("posted_at")
    String postedAt();

    String content();

    @JsonProperty("attachment")
    Object attachment();

    static Builder builder() {
        return new Builder();
    }

    final class Builder extends ImmutableComment.Builder {
        Builder() {
        }
    }
}


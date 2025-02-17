package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

import java.util.Collection;

@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true,
        jdkOnly = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
public sealed interface Task permits ImmutableTask {

    String id();

    @JsonProperty("project_id")
    String projectId();

    @JsonProperty("section_id")
    String sectionId();

    String content();

    String description();

    @JsonProperty("is_completed")
    boolean isCompleted();

    @JsonProperty("labels")
    Collection<String> labels();

    @JsonProperty("parent_id")
    String parentId();

    long order();

    long priority();

    Due due();

    String url();

    @JsonProperty("comment_count")
    long commentCount();

    @JsonProperty("assignee_id")
    String assigneeId();

    @JsonProperty("assigner_id")
    String assignerId();

    @JsonProperty("creator_id")
    String creatorId();

    @JsonProperty("created_at")
    String createdAt();

    @JsonProperty("duration")
    Integer duration();

    @JsonProperty("duration_unit")
    String durationUnit();

    static Task.Builder builder() {
        return new Task.Builder();
    }

    final class Builder extends ImmutableTask.Builder {
        Builder() {
        }
    }
}

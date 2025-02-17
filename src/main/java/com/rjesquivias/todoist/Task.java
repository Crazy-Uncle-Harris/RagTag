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

    boolean completed();

    @JsonProperty("label_ids")
    Collection<String> labelIds();

    @JsonProperty("parent_id")
    String parentId();

    long order();

    long priority();

    Due due();

    String url();

    @JsonProperty("comment_count")
    long commentCount();

    String assignee();

    String assigner();

    static Task.Builder builder() {
        return new Task.Builder();
    }

    final class Builder extends ImmutableTask.Builder {
        Builder() {
        }
    }
}

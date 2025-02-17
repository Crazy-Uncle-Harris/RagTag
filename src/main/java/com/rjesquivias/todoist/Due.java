package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

/**
 * Represents a due date/time for a Todoist task.
 * This object is returned as part of Task responses from the Todoist API.
 */
@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
public sealed interface Due permits ImmutableDue {
    /**
     * Human readable date string (e.g. "tomorrow at 12")
     */
    String string();

    /**
     * The date in YYYY-MM-DD format
     */
    String date();

    /**
     * The date and time in RFC3339 format
     */
    String datetime();

    /**
     * The timezone name (e.g. "Europe/Moscow")
     */
    String timezone();

    /**
     * Whether this is a recurring due date
     */
    @JsonProperty("is_recurring")
    boolean isRecurring();

    static Due.Builder builder() {
        return new Due.Builder();
    }

    final class Builder extends ImmutableDue.Builder {
        Builder() {
        }
    }
}

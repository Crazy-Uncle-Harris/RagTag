package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(
        builderVisibility = Value.Style.BuilderVisibility.PACKAGE,
        visibility = Value.Style.ImplementationVisibility.PACKAGE,
        overshadowImplementation = true
)
@JsonIgnoreProperties(ignoreUnknown = true)
public sealed interface Due permits ImmutableDue {
    String string();

    String date();

    @JsonProperty("is_recurring")
    boolean isRecurring();

    String datetime();

    String timezone();

    static Due.Builder builder() {
        return new Due.Builder();
    }

    final class Builder extends ImmutableDue.Builder {
        Builder() {
        }
    }
}

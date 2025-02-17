package com.rjesquivias.todoist;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

public interface Arguments {
    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    final class CreateCommentArgs {

        private String task_id;
        private String project_id;
        private String content;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class CreateLabelArgs {

        private String name;
        private Long order;
        private Color color;
        private Boolean favorite;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class UpdateLabelArgs {

        private String name;
        private Long order;
        private Color color;
        private Boolean favorite;
    }

    @Data
    @Builder
    class CreateProjectArgs {

        private String name;
        private String parent_id;
        private Color color;
        private boolean is_favorite;
        private String view_style;
    }

    @Data
    @Builder
    class UpdateProjectArgs {

        private String name;
        private Color color;
        private boolean is_favorite;
        private String view_style;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class CreateSectionArgs {

        private String name;
        private String project_id;
        private Long order;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class GetAllActiveTasksArgs {

        private String project_id;
        private String section_id;
        private Collection<String> labels;
        private String filter;
        private String lang;
        private Collection<String> ids;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class CreateTaskArgs {

        private String content;
        private String description;
        private String project_id;
        private String section_id;
        private String parent_id;
        private String parent;
        private Long order;
        private Collection<String> labels;
        private Long priority;
        private String due_string;
        private String due_date;
        private String due_datetime;
        private String due_lang;
        private String assignee;
        private Integer duration;
        private String duration_unit;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class UpdateTaskArgs {

        private String content;
        private String description;
        private Collection<String> labels;
        private Long priority;
        private String due_string;
        private String due_date;
        private String due_datetime;
        private String due_lang;
        private Long assignee;
        private Integer duration;
        private String duration_unit;
    }
}

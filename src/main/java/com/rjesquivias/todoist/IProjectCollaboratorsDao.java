package com.rjesquivias.todoist;

import java.util.Collection;

public interface IProjectCollaboratorsDao {
    Collection<ProjectCollaborator> getAll(String projectId);

    ProjectCollaborator get(String projectId, String id);
}

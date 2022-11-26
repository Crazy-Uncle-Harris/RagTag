package com.rjesquivias.todoist;

import java.util.Collection;

public interface IProjectCollaboratorsDao {
    Collection<ProjectCollaborator> getAll(long projectId);

    ProjectCollaborator get(long projectId, long id);
}

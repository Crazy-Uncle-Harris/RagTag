package com.rjesquivias.todoist;

import java.util.Collection;

interface IProjectDao {

    Collection<Project> getAll();

    Project get(String id);

    Project create(Arguments.CreateProjectArgs args);

    void update(String id, Arguments.UpdateProjectArgs args);

    void delete(String id);
}

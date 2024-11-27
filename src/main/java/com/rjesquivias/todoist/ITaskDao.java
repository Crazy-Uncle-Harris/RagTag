package com.rjesquivias.todoist;

import java.util.Collection;

interface ITaskDao {

    Collection<Task> getAllActive(Arguments.GetAllActiveTasksArgs args);

    Task create(Arguments.CreateTaskArgs args);

    Task getActive(String id);

    void update(String id, Arguments.UpdateTaskArgs args);

    void close(String id);

    void reOpen(String id);

    void delete(String id);
}

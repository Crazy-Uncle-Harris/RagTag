package com.rjesquivias.todoist;

import java.util.Collection;

interface ILabelDao {

    Collection<Label> getAll();

    Label create(Arguments.CreateLabelArgs args);

    Label get(String id);

    void update(String id, Arguments.UpdateLabelArgs args);

    void delete(String id);
}

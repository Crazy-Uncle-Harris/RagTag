package com.rjesquivias.todoist;

import java.util.Collection;

interface ISectionDao {

    Collection<Section> getAll();

    Collection<Section> getAll(String project_id);

    Section create(Arguments.CreateSectionArgs args);

    Section get(String id);

    void update(String id, String name);

    void delete(String id);
}

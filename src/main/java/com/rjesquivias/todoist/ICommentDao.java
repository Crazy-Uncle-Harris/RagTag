package com.rjesquivias.todoist;


import java.util.Collection;

interface ICommentDao {

    Collection<Comment> getAllInProject(String projectId);

    Collection<Comment> getAllInTask(String taskId);

    Comment create(Arguments.CreateCommentArgs args);

    Comment get(String commentId);

    void update(String commentId, String content);

    void delete(String commentId);
}

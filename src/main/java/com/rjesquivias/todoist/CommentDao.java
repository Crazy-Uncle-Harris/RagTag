package com.rjesquivias.todoist;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.logging.Logger;

import static com.rjesquivias.todoist.Predicates.noContentPredicate;
import static com.rjesquivias.todoist.Predicates.okPredicate;

final class CommentDao implements ICommentDao {

    private final String baseUri;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final HttpRequestFactory httpRequestFactory;
    private final HttpRequestHelper httpRequestHelper;

    public CommentDao(HttpRequestHelper httpRequestHelper, String commentURI, String apiToken) {
        this.baseUri = commentURI;
        this.httpRequestFactory = new HttpRequestFactory(apiToken,
                new ObjectMapper());
        this.httpRequestHelper = httpRequestHelper;
    }

    @Override
    public Collection<Comment> getAllInProject(String projectId) {
        LOGGER.info("CommentDao::getAllInProject(long projectId)");
        HttpRequest request = httpRequestFactory.buildGet(
                String.format("%s?project_id=%s", baseUri, projectId));
        return httpRequestHelper.makeCollectionRequest(request, okPredicate, ImmutableComment.class);
    }

    @Override
    public Collection<Comment> getAllInTask(String taskId) {
        LOGGER.info("CommentDao::getAllInTask(long taskId)");
        HttpRequest request = httpRequestFactory.buildGet(
                String.format("%s?task_id=%s", baseUri, taskId));
        return httpRequestHelper.makeCollectionRequest(request, okPredicate, ImmutableComment.class);
    }

    @Override
    public Comment create(Arguments.CreateCommentArgs args) {
        LOGGER.info("CommentDao::create(CommentArgs args)");
        HttpRequest request = httpRequestFactory.buildPost(baseUri, args);
        return httpRequestHelper.makeRequest(request, okPredicate, ImmutableComment.class);
    }

    @Override
    public Comment get(String commentId) {

        LOGGER.info("CommentDao::get(long commentId)");
        HttpRequest request = httpRequestFactory.buildGet(baseUri + commentId);
        return httpRequestHelper.makeRequest(request, okPredicate, ImmutableComment.class);
    }

    @Override
    public void update(String commentId, String content) {
        LOGGER.info("CommentDao::update(long commentId, String content)");
        HttpRequest request = httpRequestFactory.buildPost(baseUri + commentId,
                String.format("{\"content\": \"%s\"}", content));
        httpRequestHelper.makeRequest(request, noContentPredicate, ImmutableComment.class);
    }

    @Override
    public void delete(String commentId) {
        LOGGER.info("CommentDao::delete(long commentId)");
        HttpRequest request = httpRequestFactory.buildDelete(baseUri + commentId);
        httpRequestHelper.makeRequest(request, noContentPredicate, ImmutableComment.class);
    }
}

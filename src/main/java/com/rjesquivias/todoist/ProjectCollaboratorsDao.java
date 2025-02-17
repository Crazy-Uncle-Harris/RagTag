package com.rjesquivias.todoist;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.logging.Logger;

import static com.rjesquivias.todoist.Predicates.okPredicate;

public class ProjectCollaboratorsDao implements IProjectCollaboratorsDao{
    
    private final String baseUri;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final HttpRequestFactory httpRequestFactory;
    private final HttpRequestHelper httpRequestHelper;

    public ProjectCollaboratorsDao(HttpRequestHelper httpRequestHelper, String collaboratorUri, String apiToken) {
        this.baseUri = collaboratorUri;
        this.httpRequestFactory = new HttpRequestFactory(apiToken,
                new ObjectMapper());
        this.httpRequestHelper = httpRequestHelper;
    }

    @Override
    public Collection<ProjectCollaborator> getAll(String projectId) {
        LOGGER.info("CollaboratorsDao::getAll()");
        HttpRequest request = httpRequestFactory.buildGet(baseUri);

        return httpRequestHelper.makeCollectionRequest(request, okPredicate, ImmutableProjectCollaborator.class);
    }

    @Override
    public ProjectCollaborator get(String projectId, String id) {
        LOGGER.info("CollaboratorsDao::get()");
        HttpRequest request = httpRequestFactory.buildGet(baseUri);

        return httpRequestHelper.makeRequest(request, okPredicate, ImmutableProjectCollaborator.class);
    }
}

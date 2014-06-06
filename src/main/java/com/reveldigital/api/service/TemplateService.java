package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Template;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_TEMPLATES;

/**
 * Created by Mike on 6/5/2014.
 */
public class TemplateService extends RevelService {

    /**
     * Create template service
     */
    public TemplateService() {
        super();
    }

    /**
     * Create template service for client
     *
     * @param client
     */
    public TemplateService(RevelClient client) {
        super(client);
    }

    /**
     * Get all templates
     *
     * @return
     * @throws java.io.IOException
     */
    public List<Template> getTemplates() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_TEMPLATES);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Template>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get template by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public Template getTemplate(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_TEMPLATES);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Template>>() {
        }.getType());

        List<Template> ret = client.get(request);
        if (ret == null || ret.size() == 0) {
            return null;
        } else {
            return ret.get(0);
        }
    }
}

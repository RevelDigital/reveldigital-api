package com.reveldigital.api.service;

import com.reveldigital.api.client.PagedRequest;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.reveldigital.api.client.PagedRequest.PAGE_FIRST;
import static com.reveldigital.api.client.PagedRequest.PAGE_SIZE;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;

/**
 * Base RevelDigital service class.
 */
public abstract class RevelService {

    /**
     * Accept header for full response
     */
    protected static final String ACCEPT_JSON = "application/json"; //$NON-NLS-1$

    /**
     * Client field
     */
    protected final RevelClient client;

    /**
     * Create service using a default {@link RevelClient}
     */
    public RevelService() {
        this(new RevelClient());
    }

    /**
     * Create service for client
     *
     * @param client must be non-null
     */
    public RevelService(RevelClient client) {
        if (client == null)
            throw new IllegalArgumentException("Client cannot be null"); //$NON-NLS-1$
        this.client = client;
    }

    /**
     * Get configured client
     *
     * @return non-null client
     */
    public RevelClient getClient() {
        return client;
    }

    /**
     * Unified request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @return request
     */
    protected RevelRequest createRequest() {
        RevelRequest req = new RevelRequest();
        req.setParams(Collections.singletonMap("api_key", getApiKey()));
        return req;
    }

    /**
     * Unified request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @return request
     */
    protected RevelRequest createRequest(Map<String, String> params) {
        RevelRequest req = new RevelRequest();
        params.put("api_key", getApiKey());
        req.setParams(params);
        return req;
    }

    /**
     * Unified paged request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @return request
     */
    protected <V> PagedRequest<V> createPagedRequest() {
        return createPagedRequest(PAGE_FIRST, PAGE_SIZE);
    }

    /**
     * Unified paged request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @param start
     * @param size
     * @return request
     */
    protected <V> PagedRequest<V> createPagedRequest(int start, int size) {
        PagedRequest<V> req = new PagedRequest<V>(start, size);
        Map<String, String> table = new HashMap<String, String>();
        table.put("api_key", getApiKey());
        req.setParams(table);
        return req;
    }
//
//    /**
//     * Unified page iterator creation method that all sub-classes should use so
//     * overriding classes can extend and configure the default iterator.
//     *
//     * @param request
//     * @return iterator
//     */
//    protected <V> PageIterator<V> createPageIterator(PagedRequest<V> request) {
//        return new PageIterator<V>(request, client);
//    }

//    /**
//     * Get paged request by performing multiple requests until no more pages are
//     * available or an exception occurs.
//     *
//     * @param <V>
//     * @param request
//     * @return list of all elements
//     * @throws IOException
//     */
//    protected <V> List<V> getAll(PagedRequest<V> request) throws IOException {
//        return getAll(createPageIterator(request));
//    }
//
//    /**
//     * Get paged request by performing multiple requests until no more pages are
//     * available or an exception occurs.
//     *
//     * @param <V>
//     * @param iterator
//     * @return list of all elements
//     * @throws IOException
//     */
//    protected <V> List<V> getAll(PageIterator<V> iterator) throws IOException {
//        List<V> elements = new ArrayList<V>();
//        try {
//            while (iterator.hasNext())
//                elements.addAll(iterator.next());
//        } catch (NoSuchPageException pageException) {
//            throw pageException.getCause();
//        }
//        return elements;
//    }

    /**
     * Check if the uri returns a non-404
     *
     * @param uri
     * @return true if no exception, false if 404
     * @throws java.io.IOException
     */
    protected boolean check(String uri) throws IOException {
        try {
            client.get(createRequest().setUri(uri));
            return true;
        } catch (RequestException e) {
            if (e.getStatusCode() == HTTP_NOT_FOUND)
                return false;
            throw e;
        }
    }

    /**
     * Get API key
     *
     * @return non-null API key
     */
    protected String getApiKey() {

        if (client.getApiKey() == null)
            throw new IllegalArgumentException("API key cannot be null"); //$NON-NLS-1$
        if (client.getApiKey().length() == 0)
            throw new IllegalArgumentException("API key cannot be empty"); //$NON-NLS-1$
        return client.getApiKey();
    }
}
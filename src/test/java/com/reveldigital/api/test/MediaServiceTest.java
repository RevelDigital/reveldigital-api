package com.reveldigital.api.test;

import com.reveldigital.api.Media;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.MediaService;
import junit.framework.TestCase;

import java.util.List;


/**
 * Created by Mike on 6/5/2014.
 */
public class MediaServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetMedias() throws Exception, RequestException {
        MediaService service = new MediaService(client);
        List<Media> ret = service.getMedias();
        assertTrue(ret.size() > 0);
    }

    public void testGetMedia() throws Exception, RequestException {
        MediaService service = new MediaService(client);
        Media ret = service.getMedia("DFXYHYOESbA");
        assertTrue(ret.getName().equals("Menu 1 Template - Overlay"));
    }
}

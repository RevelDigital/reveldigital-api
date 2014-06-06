package com.reveldigital.api.test;

import com.reveldigital.api.Playlist;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.PlaylistService;
import junit.framework.TestCase;

import java.util.List;


/**
 * Created by Mike on 6/5/2014.
 */
public class PlaylistServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetPlaylists() throws Exception, RequestException {
        PlaylistService service = new PlaylistService(client);
        List<Playlist> ret = service.getPlaylists();
        assertTrue(ret.size() > 0);
    }

    public void testGetPlaylist() throws Exception, RequestException {
        PlaylistService service = new PlaylistService(client);
        Playlist ret = service.getPlaylist("ORryJsvz8FU");
        assertTrue(ret.getName().equals("command_test_playlist"));
    }
}

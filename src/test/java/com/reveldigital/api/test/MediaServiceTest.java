/*
 * Copyright (c) 2016. Catalyst LLC. All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reveldigital.api.test;

import com.reveldigital.api.Group;
import com.reveldigital.api.Media;
import com.reveldigital.api.service.MediaService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class MediaServiceTest {

    MediaService service;

    @Before
    public void initialize() {
        service = new MediaService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetMedias() throws Exception {
        List<Media> ret = service.getMedias();
        assertTrue(ret.size() > 0);
    }

    @Test
    public void testGetMedia() throws Exception {
        Media ret = service.getMedia("DFXYHYOESbA");
        assertTrue(ret.getName().equals("Menu 1 Template - Overlay"));
    }

    @Test
    public void testGetGroups() throws Exception {
        List<Group> groups = service.getGroups();
        assertTrue(groups.size() > 0);
    }

    @Test
    public void testCreateMedia() throws Exception {
        Media media = new Media();
        media.setGroupId("IdVYUkPXmTs"); // required
        media.setEndDate(new Date());
        media.setTags("testing");

        Media ret = service.createMedia(media, new File("C:\\REVEL\\Media\\262419!Logo.png"));
        assertTrue(ret.getName().equals("262419!Logo.png"));
    }
}

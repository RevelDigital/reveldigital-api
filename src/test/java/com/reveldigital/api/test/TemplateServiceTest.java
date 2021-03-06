/*
 * Copyright (c) 2015. Catalyst LLC. All right reserved.
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
import com.reveldigital.api.Template;
import com.reveldigital.api.service.TemplateService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class TemplateServiceTest {

    TemplateService service;

    @Before
    public void initialize() {
        service = new TemplateService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetTemplates() throws Exception {
        List<Template> ret = service.getTemplates();
        assertTrue(ret.size() > 0);
    }

    @Test
    public void testGetTemplate() throws Exception {
        Template ret = service.getTemplate("G0IrSYzbjJA");
        assertTrue(ret.getName().equals("HudsonsCoffee"));
    }

    @Test
    public void testGetGroups() throws Exception {
        List<Group> groups = service.getGroups();
        assertTrue(groups.size() > 0);
    }
}

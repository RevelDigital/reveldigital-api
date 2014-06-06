package com.reveldigital.api.test;

import com.reveldigital.api.Template;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.TemplateService;
import junit.framework.TestCase;

import java.util.List;


/**
 * Created by Mike on 6/5/2014.
 */
public class TemplateServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);

    }

    public void testGetTemplates() throws Exception, RequestException {
        TemplateService service = new TemplateService(client);
        List<Template> ret = service.getTemplates();
        assertTrue(ret.size() > 0);
    }

    public void testGetTemplate() throws Exception, RequestException {
        TemplateService service = new TemplateService(client);
        Template ret = service.getTemplate("G0IrSYzbjJA");
        assertTrue(ret.getName().equals("HudsonsCoffee"));
    }
}

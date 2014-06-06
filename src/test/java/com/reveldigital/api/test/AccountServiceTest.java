package com.reveldigital.api.test;

import com.reveldigital.api.Account;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.AccountService;
import junit.framework.TestCase;

public class AccountServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetAccount() throws Exception, RequestException {
        AccountService service = new AccountService(client);
        Account account = service.getAccount();
        assertTrue("Moorhead".equals(account.getCity()));
    }
}
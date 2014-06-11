package com.reveldigital.api.test;

import com.reveldigital.api.Account;
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

    public void testGetAccount() throws Exception {
        AccountService service = new AccountService(client);
        Account account = service.getAccount();
        assertTrue("Moorhead".equals(account.getCity()));
    }

    public void testUpdateAccount() throws Exception {
        AccountService service = new AccountService(client);
        Account account = service.getAccount();
        account.setFax("333-444-5555");
        service.updateAccount(account);
        assertTrue(account.getFax().equals("333-444-5555"));
    }
}
package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Account;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;

import static com.reveldigital.api.client.IConstants.SEGMENT_ACCOUNT;

/**
 *
 */
public class AccountService extends RevelService {

    /**
     * Create account service
     */
    public AccountService() {
        super();
    }

    /**
     * Create account service for client
     *
     * @param client
     */
    public AccountService(RevelClient client) {
        super(client);
    }

    /**
     * Get account
     *
     * @return account details
     * @throws java.io.IOException
     */
    public Account getAccount() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_ACCOUNT);
        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<Account>() {
        }.getType());
        return client.get(request);
    }

    /**
     * Update account
     *
     * @param account
     * @return
     * @throws IOException
     */
    public Account updateAccount(Account account) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_ACCOUNT);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(Account.class);
        request.setBody(account);

        return client.put(request);
    }
}
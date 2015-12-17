package com.rduda.Model;

import com.rduda.Model.API.Account;
import com.rduda.Model.API.StoreProvider;

/**
 * Created by Robin on 2015-12-01.
 * <p>
 * Contains StoreProvider extension methods required for REST operation.
 */
public interface StoreProviderREST extends StoreProvider {
    /**
     * Get the Account of the current in-context Account of the Provider.
     *
     * @return The account that is in-context for the store instance.
     */
    Account getRequest();

    /**
     * Set the Account of the current in-context Account of the provider.
     *
     * @param request An account that has been authenticated.
     */
    void setRequest(Account request);
}

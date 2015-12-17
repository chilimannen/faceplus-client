package com.rduda.Controller;

import com.rduda.Model.API.AccountManager;
import org.primefaces.model.DefaultStreamedContent;

/**
 * Created by Robin on 2015-11-16.
 * <p>
 * Strip user input from a bean holding a manager,
 * allows bean injection without user-inserted data.
 */
interface AccountManagerHolder {
    /**
     * Returns the AccountManager that is being held by the implementing class.
     *
     * @return an AccountManager instance for an account.
     */
    AccountManager getManager();

    /**
     * Get profile image.
     *
     * @return a profile image or a placeholder.
     */
    DefaultStreamedContent getProfileImage(long accountId);
}

package Mock;

import com.rduda.Model.API.AccountManager;
import com.rduda.Model.AccountHandler;

/**
 * Created by Robin on 2015-11-21.
 * <p>
 * Toggles the testing mode to use the mocked provider or default implementation.
 */
public class ManagerProvider {
    public static AccountManager getAccountManager() {
        return new AccountHandler();
    }

}

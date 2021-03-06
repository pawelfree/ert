package pl.pd.emir.auth.ldap;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import pl.pd.emir.admin.UserManager;
import pl.pd.emir.auth.IConnector;
import pl.pd.emir.auth.IIDMConfig;
import pl.pd.emir.auth.ILdapHelper;
import pl.pd.emir.auth.config.LdapConfig;
import pl.pd.emir.entity.administration.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Local(IConnector.class)
public class LDAPConnector implements IConnector {

    private static final Logger LOGGER = LoggerFactory.getLogger(LDAPConnector.class);
    @EJB
    private IIDMConfig idmConfig;
    @EJB
    private ILdapHelper ldapHelper;
    @EJB
    private transient UserManager userManager;

    @Override
    public boolean checkUsernamePassword(String userName, String password) {
        LOGGER.info("logowanie do aplikacji poprzez LDAP");
        if (!isLoginRegisterdAndActiveInDb(userName)) {
            LOGGER.info("Brak loginu {} w bazie danych EMIR", userName);
            return false;
        }
        LOGGER.info("Login {} znaleziony w bazie danych EMIR", userName);

        boolean result = false;
        try {
            LdapConfig ldapConfig = idmConfig.getConfig().getLdapConfig();
            Ldap ldap = new Ldap(ldapConfig.getProviderUrl(), ldapConfig.getDomain(), ldapConfig.getAuthType(), ldapConfig.isUseSSL());
            LdapErrorCodes ldapResult = ldap.authenticate(userName, password);
            if (LdapErrorCodes.ERROR_SUCCESS.equals(ldapResult)) {
                result = true;
                LOGGER.info("Poprawne logowanie w LDAP, uzytkownik: {}", userName);
            } else {
                LOGGER.warn("Blad logowania w LDAP, uzytkownik {}, blad z ldap: {}", userName, ldapResult);
            }
        } catch (Exception e) {
            LOGGER.error("Blad autentylakcji uzytkownika {} w ldap {}", userName, e);
        }

        return result;
    }

    private boolean isLoginRegisterdAndActiveInDb(String login) {
        User usr = userManager.getUserByLogin(login);
        return usr != null && usr.isActive();
    }
}

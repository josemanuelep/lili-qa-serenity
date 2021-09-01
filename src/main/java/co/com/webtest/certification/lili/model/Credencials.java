package co.com.webtest.certification.lili.model;

import co.com.webtest.certification.lili.model.Builders.CredencialsBuilder;

public class Credencials {

    private String user;
    private String password;

    public Credencials(CredencialsBuilder credencialsBuilder) {
        this.password=credencialsBuilder.getPasswordBuild();
        this.user=credencialsBuilder.getUserBuild();
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

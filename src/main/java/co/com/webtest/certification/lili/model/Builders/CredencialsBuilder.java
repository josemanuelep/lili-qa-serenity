package co.com.webtest.certification.lili.model.Builders;

import co.com.webtest.certification.lili.model.Credencials;
import co.com.webtest.certification.lili.util.Builder;

import static co.com.webtest.certification.lili.util.Constants.BOT_DESIGNER_ROL;
import static co.com.webtest.certification.lili.util.Constants.QAUSER;

public class CredencialsBuilder implements Builder<Credencials> {
    private String userBuild;
    private String passwordBuild;

    public CredencialsBuilder() {
        this.userBuild="qauser@vozy.co";
        this.passwordBuild = "A5wExi0M%86M";
    }

    public Credencials withCredencials(String user){
        if (user!=null && !user.isEmpty()){
            setCredencialsByUser(user);
        }
        return build();
    }

    public static Credencials getCredencials(String user){
        return new CredencialsBuilder().withCredencials(user);
    }

    private void setCredencialsByUser(String user){
        switch(user){
            case(QAUSER):
                this.userBuild="qauser@vozy.co";
                this.passwordBuild="A5wExi0M%86M";
                break;
            case(BOT_DESIGNER_ROL):
                this.userBuild="qabotdesigner@ebarg.net";
                this.passwordBuild="123456789Vozy";
                break;
            default:
                this.userBuild="jecheverri@vozy.co";
                this.passwordBuild="NITROpc98";
                break;
        }
    }

    public String getUserBuild() {
        return userBuild;
    }

    public String getPasswordBuild() {
        return passwordBuild;
    }

    @Override
    public Credencials build() {
        return new Credencials(this);
    }
}

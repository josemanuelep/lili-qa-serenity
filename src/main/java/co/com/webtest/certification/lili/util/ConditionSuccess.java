package co.com.webtest.certification.lili.util;

import java.util.concurrent.Callable;

public class ConditionSuccess {

    static Boolean allMessagesProcessed = true;

    private ConditionSuccess() {
    }

    public static Callable<Boolean> forTheTime() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return allMessagesProcessed;

            }
        };
    }

}

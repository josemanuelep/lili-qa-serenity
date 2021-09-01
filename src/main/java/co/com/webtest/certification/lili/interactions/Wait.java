package co.com.webtest.certification.lili.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

import static co.com.webtest.certification.lili.util.ConditionSuccess.forTheTime;

public class Wait implements Interaction {

    private int segundos;

    public Wait(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().forever().pollInterval(segundos, TimeUnit.SECONDS).until(forTheTime());
    }

    public static Wait oneMoment(int segundos) {
        return Tasks.instrumented(Wait.class, segundos);
    }

}


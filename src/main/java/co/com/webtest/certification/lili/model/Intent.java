package co.com.webtest.certification.lili.model;

import co.com.webtest.certification.lili.model.builders.IntentBuilder;

public class Intent {

    private String uttercanceName;
    private String slotName;

    public Intent(IntentBuilder intentBuilder) {
        this.uttercanceName = intentBuilder.getUttercanceNameBuilder();
        this.slotName = intentBuilder.getSlotNameBuilder();
    }

    public String getUttercanceName() {
        return uttercanceName;
    }

    public String getSlotName() {
        return slotName;
    }
}

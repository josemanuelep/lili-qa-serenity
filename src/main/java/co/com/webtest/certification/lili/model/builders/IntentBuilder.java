package co.com.webtest.certification.lili.model.builders;

import co.com.webtest.certification.lili.model.FeatureData;
import co.com.webtest.certification.lili.model.Intent;
import co.com.webtest.certification.lili.util.Builder;

public class IntentBuilder implements Builder<Intent> {

    private String uttercanceNameBuilder;
    private String slotNameBuilder;

    private Intent withDataFeature(FeatureData featureData) {
        if (featureData.getUttercanceName() != null && !featureData.getUttercanceName().isEmpty()) {
            this.uttercanceNameBuilder = featureData.getUttercanceName();
        }
        if (featureData.getSlotName() != null && !featureData.getSlotName().isEmpty()) {
            this.slotNameBuilder = featureData.getSlotName();
        }
        return this.build();
    }

    public static Intent withData(FeatureData feature) {
        return new IntentBuilder().withDataFeature(feature);
    }

    public String getUttercanceNameBuilder() {
        return uttercanceNameBuilder;
    }

    public String getSlotNameBuilder() {
        return slotNameBuilder;
    }

    @Override
    public Intent build() {
        return new Intent(this);
    }
}

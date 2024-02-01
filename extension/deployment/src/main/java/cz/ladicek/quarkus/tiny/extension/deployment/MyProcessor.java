package cz.ladicek.quarkus.tiny.extension.deployment;

import cz.ladicek.quarkus.tiny.extension.runtime.MyRecorder;
import io.quarkus.arc.deployment.ValidationPhaseBuildItem;
import io.quarkus.arc.deployment.ValidationPhaseBuildItem.ValidationErrorBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class MyProcessor {
    private static final String FEATURE = "my-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    void doSomethingAtRuntime(MyRecorder recorder,
            // `validation` and `errors` only declared for lifecycle purposes
            ValidationPhaseBuildItem validation,
            BuildProducer<ValidationErrorBuildItem> errors) {
        recorder.doSomething();
    }
}

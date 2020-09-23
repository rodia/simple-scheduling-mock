package org.scheduling;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.scheduling.resources.ClassController;
import org.scheduling.resources.StudentController;

public class SchedulingApplication extends Application<SchedulingConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SchedulingApplication().run(args);
    }

    @Override
    public String getName() {
        return "Scheduling";
    }

    @Override
    public void initialize(final Bootstrap<SchedulingConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final SchedulingConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new StudentController());
        environment.jersey().register(new ClassController());
    }
}

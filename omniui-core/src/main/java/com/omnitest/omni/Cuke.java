package com.omnitest.omni;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import org.apache.commons.io.FilenameUtils;
import org.testng.ITest;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Cucumber implementation.
 *
 * @author Mohan Gundala
 */
public class Cuke implements ITest {

    private final String feature;
    private final String tags;
    private cucumber.runtime.Runtime cukeruntime;

    public Cuke(String feature, String tags) {
        this.feature = feature;
        this.tags = tags;
        this.cukeruntime = null;
    }
    @Override
    public String getTestName() {
        return FilenameUtils.getName(feature);
    }

    @Test(groups = "cukes", description = "Runs Cuke Features")
    public void CukerRunner() throws Throwable {

        ClassLoader classLoader = getClass().getClassLoader();
        ResourceLoader resourceLoader = new MultiLoader(classLoader);

        RuntimeOptionsFactory cukeRunFactory = new RuntimeOptionsFactory(getClass());

        RuntimeOptions cukeRun = cukeRunFactory.create();

        cukeRun.getGlue().clear();
        cukeRun.getGlue().add("classpath:");

        cukeRun.getFeaturePaths().clear();
        cukeRun.getFeaturePaths().add(feature);
        
        if (!tags.isEmpty()) {
            for (String tagname : tags.split("--tags")) {
                if (!tagname.trim().isEmpty()) {
                	cukeRun.getFilters().add(tagname.trim());
                }
            }
        }

        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
        cukeruntime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, cukeRun);
        try {
        	cukeruntime.run();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        if (!cukeruntime.getErrors().isEmpty()) {
            throw new CucumberException(cukeruntime.getErrors().get(0));
        }
        
    }


}
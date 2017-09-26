package com.omnitest.omni.cuke;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.omnitest.omni.Cuke;

public class CukeBuilder {
	
	
	/**
	 * 
	 * @param To get all feature files from the given location
	 * @return list of feature files
	 */
	public static List<String> fetchFeatures(File featureFilePath) {
		List<String> featuresList = new ArrayList<>();

		if (featureFilePath.isDirectory()) {
			File[] list = featureFilePath.listFiles();
			if (list != null) {
				for (File file : list) {
					featuresList.addAll(fetchFeatures(new File(file.getAbsolutePath())));
				}
			}
		} else {
			if (featureFilePath.getName().endsWith(".feature"))
				featuresList.add(featureFilePath.getPath());
		}
		return featuresList;
	}

	public Object[] runAllFeatures(String tags) {
		List<Object> tests = new ArrayList<>();
		List<String> features = fetchFeatures(new File("src/test/resources/features"));

		features.forEach(feature -> {
			Cuke cukeTest = new Cuke(feature, tags);
			tests.add(cukeTest);
		});

		return tests.toArray();
	}

}

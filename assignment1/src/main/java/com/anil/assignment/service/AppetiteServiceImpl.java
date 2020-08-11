package com.anil.assignment.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.algo.dp.Knapsack;

@Service
public class AppetiteServiceImpl implements AppetiteService {

	static private Logger logger = Logger.getLogger("AppetiteServiceImpl.class");
	/*
	 * The following map is going to act as in memory data cache, for storing the file data
	 * HashMap is selected as it is the fastest and efficient in get operations
	 * */
	private Map<Integer, Integer> dataMap = new HashMap<>();

	/*
	 * In the default constructor the following tasks are performed
	 * 1. get a handle to the data file which is present in resources folder
	 * 2. scan the file using Scanner class to obtain data line by line
	 * 3. once the data is available, split the data using blank space saparator
	 * 4. finally store the two string values as key value pairs in the HashMap.
	 */
	public AppetiteServiceImpl() {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Data.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String rowData[] = line.split(" ");
				dataMap.put(Integer.valueOf(rowData[0]), Integer.valueOf(rowData[1]));
			}

			System.out.println(dataMap);

		} catch (IOException e) {

			logger.error(e.getMessage(), e);
		}

	}

	public Map<Integer, Integer> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<Integer, Integer> dataMap) {
		this.dataMap = dataMap;
	}

	// this method is self explanatory
	@Override
	public Integer optimizer(Integer inputTime) {

		
		Set<Integer> keySet = dataMap.keySet();
		Integer minKey = Collections.min(keySet);
		Integer maxKey = Collections.max(keySet);
		
		
		
		Collection<Integer> dataMapValues = dataMap.values();
		
		 if (inputTime >0) {
            System.out.println("<< input time >>" + inputTime);
            System.out.println("KeySet = " + keySet);
			Integer[] weights = dataMap.values().toArray(new Integer[dataMap.size()]);
			Integer[] values = keySet.toArray(new Integer[keySet.size()]);
			return Knapsack.compute(inputTime, weights, values);
		
		}
		return -1;
	}
}

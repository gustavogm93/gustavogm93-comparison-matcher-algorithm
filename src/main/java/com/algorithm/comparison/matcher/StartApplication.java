package com.algorithm.comparison.matcher;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		try {

			//Timer
			long startTime = System.currentTimeMillis();

			String excelPath = "data/contact-registries.xlsx";
			ExcelReadStrategy readStrategy = new ExcelReadStrategy(excelPath);
			List<Contact> contacts = readStrategy.parse();

			List<ContactMatchResult> contactMatchResults = new ArrayList<>();
				contactMatchResults = DuplicateFinder.findDuplicates(contacts);
				for (ContactMatchResult result : contactMatchResults) {
					System.out.println(result.toString());
				}

			System.out.println("Total duplicates found: " + contactMatchResults.size());
			//end timer
			long endTime = System.currentTimeMillis();

			System.out.println("Execution time: " + (endTime - startTime) + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

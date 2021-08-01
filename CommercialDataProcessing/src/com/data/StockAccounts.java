package com.data;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class StockAccounts {

	public static double valueOf() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".//data/commercialdata.json");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

		Object object = jsonParser.parse(reader);
		JSONObject company = (JSONObject) object;

		JSONArray airtelCompany = (JSONArray) company.get("airtel");
		Commercial airteleStock = new Commercial();

		int airtelTotalStocks = 0;
		int airtelTotalPrice = 0;

		for (int i = 0; i < airtelCompany.size(); i++) {
			JSONObject relianceDetails = (JSONObject) airtelCompany.get(i);

			Airtel airtel = new Airtel();

			airtel.setName((String) relianceDetails.get("name"));
			airtel.setNumberOfStocks((long) relianceDetails.get("numberOfStocks"));
			airtel.setPricePerStock((long) relianceDetails.get("pricePerStock"));
			airtelTotalStocks += airtel.getNumberOfStocks();
			airtelTotalPrice += airtel.getNumberOfStocks() * airtel.getPricePerStock();
		}
		return airtelTotalPrice;
	}

	void buy(int amount, String symbol) {
		System.out.println("Bought " + amount + " stocks of " + symbol + " company");
	}

	void sell(int amount, String symbol) {
		System.out.println("Sold " + amount + " stocks of " + symbol + " company");
	}

	void save(String fileName) {
		List<String> companies = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int numberOfCompany = sc.nextInt();
		for (int i = 0; i < numberOfCompany; i++) {
			System.out.println("Enter company name: ");
			String companyAdded = sc.next();
			companies.add(companyAdded);
		}
		System.out.println(companies);
	}
	
	void printReport() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".//data/commercialdata.json");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

		Object object = jsonParser.parse(reader);
		JSONObject company = (JSONObject) object;
		
		JSONArray airtelCompany = (JSONArray) company.get("airtel");

		Commercial airtelStocks = new Commercial();

		int airtelTotalStocks = 0;
		int airtelTotalPrice = 0;

		for (int i = 0; i < airtelCompany.size(); i++) {
			JSONObject airtelDetails = (JSONObject) airtelCompany.get(i);

			Airtel airtel = new Airtel();

			airtel.setName((String) airtelDetails.get("name"));
			airtel.setNumberOfStocks((long) airtelDetails.get("numberOfStocks"));
			airtel.setPricePerStock((long) airtelDetails.get("pricePerStock"));
			airtelTotalStocks += airtel.getNumberOfStocks();
			airtelTotalPrice += airtel.getNumberOfStocks() * airtel.getPricePerStock();
		}

		airtelStocks.setFileName("Airtel");
		airtelStocks.setSymbol("Airtel Company");
		airtelStocks.setAmount(airtelTotalPrice);

		System.out.println(writer.writeValueAsString(airtelStocks));
	}
}

package com.model;

import com.stock.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class StockRunner {

	public static void main(String[] args) throws IOException, ParseException {

		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".//data/stock.json");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

		List<Stocks> list = new ArrayList<>();

		Object object = jsonParser.parse(reader);
		JSONObject company = (JSONObject) object;

		JSONArray relianceCompany = (JSONArray) company.get("reliance");
		Stocks relianceStock = new Stocks();

		int relianceTotalStocks = 0;
		int relianceTotalPrice = 0;

		for (int i = 0; i < relianceCompany.size(); i++) {
			JSONObject relianceDetails = (JSONObject) relianceCompany.get(i);

			Reliance reliance = new Reliance();

			reliance.setName((String) relianceDetails.get("name"));
			reliance.setNumberOfStocks((long) relianceDetails.get("numberOfStocks"));
			reliance.setPricePerStock((long) relianceDetails.get("pricePerStock"));
			relianceTotalStocks += reliance.getNumberOfStocks();
			relianceTotalPrice += reliance.getNumberOfStocks() * reliance.getPricePerStock();

		}

		relianceStock.setCompanyName("Reliance");
		relianceStock.setTotalStocks(relianceTotalStocks);
		relianceStock.setTotalPrice(relianceTotalPrice);

		list.add(relianceStock);
		System.out.println(writer.writeValueAsString(relianceStock));

		JSONArray bsnlCompany = (JSONArray) company.get("bsnl");

		Stocks bsnlStocks = new Stocks();

		int bsnlTotalStocks = 0;
		int bsnlTotalPrice = 0;

		for (int i = 0; i < bsnlCompany.size(); i++) {
			JSONObject bsnlDetails = (JSONObject) bsnlCompany.get(i);

			Bsnl bsnl = new Bsnl();
			bsnl.setName((String) bsnlDetails.get("name"));
			bsnl.setNumberOfStocks((long) bsnlDetails.get("numberOfStocks"));
			bsnl.setPricePerStock((long) bsnlDetails.get("pricePerStock"));
			bsnlTotalStocks += bsnl.getNumberOfStocks();
			bsnlTotalPrice += bsnl.getNumberOfStocks() * bsnl.getPricePerStock();

		}

		bsnlStocks.setCompanyName("Bsnl");
		bsnlStocks.setTotalStocks(bsnlTotalStocks);
		bsnlStocks.setTotalPrice(bsnlTotalPrice);

		list.add(bsnlStocks);
		System.out.println(writer.writeValueAsString(bsnlStocks));

		JSONArray airtelCompany = (JSONArray) company.get("airtel");

		Stocks airtelStocks = new Stocks();

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

		airtelStocks.setCompanyName("Airtel");
		airtelStocks.setTotalStocks(airtelTotalStocks);
		airtelStocks.setTotalPrice(airtelTotalPrice);

		list.add(airtelStocks);
		System.out.println(writer.writeValueAsString(airtelStocks));
	}
}
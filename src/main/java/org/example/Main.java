package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<River> rivers = parseRiverTable();
        for (River river : rivers) {
            System.out.println(river);
        }
    }

    public static List<River> parseRiverTable() {
        List<River> rivers = new ArrayList<>();
        try {
            String url = "https://en.wikipedia.org/wiki/List_of_river_systems_by_length";
            Document doc = Jsoup.connect(url).get();
            Elements table1 = doc.select("table.wikitable.sortable tr");
            for (Element row
                    :
                    table1
            ) {
                if (row.child(0).text().equals("Rank")) {
                    continue;
                }
                String  name = row.child(1).text();

                String lengthMetric = row.child(2).text();
                lengthMetric = getParsableNumber(lengthMetric);

                String lengthImperial = row.child(3).text();
                lengthImperial = getParsableNumber(lengthImperial);

                String drain = row.child(4).text();
                drain = getParsableNumber(drain);

                River river = new River(
                        name,
                        Integer.parseInt(lengthMetric),
                        Integer.parseInt(lengthImperial),
                        Integer.parseInt(drain)
                );
                rivers.add(river);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rivers;
    }

    private static String getParsableNumber(String str) {
        str = str.replace(",", "");
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (!Character.isDigit(a)) {
                str = str.substring(0, i);
                break;
            }
        }
        if (str.equals("")) {
            str = "0";
        }
        return str;
    }
}


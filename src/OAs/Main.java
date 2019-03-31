package OAs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * Iterate through each line of input.
     */
    static class Asset implements Comparable<Asset>{
        String name;
        String assetType;
        int shares;
        int price;
        double accruedInterest;
        double marketValue;
        double marketValPer;
        String trade;
        int sell;
        double totalVal;

        Asset(String name, String assetType, int shares, int price, double accruedInterest){
            this.name = name;
            this.assetType = assetType;
            this.shares = shares;
            this.price = price;
            this.accruedInterest = accruedInterest;
        }

        Asset(String name, String trade, int sell){
            this.name = name;
            this.trade = trade;
            this.sell = sell;
        }

        public int compareTo(Asset o){
            return this.name.compareTo(o.name);
        }
    }

    public static ArrayList<Asset> generatePortfolio(String[] input){
        ArrayList<Asset> portfolio= new ArrayList<Asset>();
        double totalVal = 0;
        for (int i = 0; i < input.length; i++){
            String[] attributes = input[i].split(",");
            Asset asset = new Asset(attributes[0], attributes[1], Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]), Double.parseDouble(attributes[4]));  //creating assets
            if (asset.assetType.equals("STOCK")){
                asset.marketValue = asset.shares * asset.price; //static class!
            }else if(asset.assetType.equals("BOND")){
                asset.marketValue = asset.shares * (asset.price + asset.accruedInterest) * 0.01;
            }
            totalVal += asset.marketValue;
            portfolio.add(asset);   //adding asset to portfolio
        }
        for (Asset a: portfolio){
            a.totalVal = totalVal;
            a.marketValPer = a.marketValue / totalVal;  //setting up MVP
        }
        return portfolio;
    }

    public static Asset getAssetByName(Asset a, ArrayList<Asset> list){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).name.equals(a.name))
                return list.get(i);
        }
        return null;
    }

    public static double sharesToTrade(double diff, Asset portfolio){
        double shares = 0;
        if(portfolio.assetType.equals("STOCK")){
            shares = diff / portfolio.price;
        }else if (portfolio.assetType.equals("BOND")){
            shares = diff / (portfolio.price * 0.01);
        }
        return shares;
    }

    public static ArrayList<Asset> comparePorBen(String[] por, String[] ben){
        ArrayList<Asset> portfolio = generatePortfolio(por);
        ArrayList<Asset> benchmark = generatePortfolio(ben);
        ArrayList<Asset> transactions = new ArrayList<Asset>();
        for(int i = 0; i < portfolio.size(); i++){
            Asset port = portfolio.get(i);
            Asset bench = getAssetByName(port, benchmark);
            if (port.marketValue < bench.marketValue){
                double shares = sharesToTrade(bench.marketValue - port.marketValue, port);
                Asset trans = new Asset(port.name, "BUY", (int)Math.round(shares));
                transactions.add(trans);
            }else if (port.marketValue > bench.marketValue){
                double shares = sharesToTrade(port.marketValue - bench.marketValue, port);
                Asset trans = new Asset(port.name, "SELL", (int)Math.round(shares));
                transactions.add(trans);
            }
        }
        return transactions;
    }

    public static void printTrans(ArrayList<Asset> transactions){
        Collections.sort(transactions);
        for (Asset a: transactions){
            System.out.println(a.trade + "," + a.name + "," + a.sell);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] inputs = line.split(":");
            String[] por = inputs[0].split("\\|");    //portfolio
            String[] ben = inputs[1].split("\\|");    //benchmark
            printTrans(comparePorBen(por, ben));
        }
        in.close();
        reader.close();
    }
}
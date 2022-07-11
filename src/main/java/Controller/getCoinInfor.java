package Controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DAO.CoinDAO;

public class getCoinInfor {

//	public static void main(String[] args) throws IOException {
//		String link = "https://vn.investing.com/crypto/";
//		Document doc = Jsoup.connect(link).timeout(5000).get();
//		
//		Elements DataCoin = doc.select("div.cryptocurrency-table-block table tbody tr");
//		for(Element coin:DataCoin) {
//			//name coin
//			Elements coinName = coin.select("td[class=left bold elp name cryptoName first js-currency-name] a");
//			System.out.print("coinName: "+coinName.text()+"\t");
//			//price
//			Elements price = coin.select("td.price.js-currency-price a");
//			System.out.print("price: "+price.text()+"\t");
//			
//			System.out.println();
//		}
//	}
	public void getCoin() throws IOException {
		String link = "https://vn.investing.com/crypto/";
		Document doc = Jsoup.connect(link).timeout(5000).get();
		
		Elements DataCoin = doc.select("div.cryptocurrency-table-block table tbody tr");
		for(Element coin:DataCoin) {
			//name coin
			Elements coinName = coin.select("td[class=left bold elp name cryptoName first js-currency-name] a");
			System.out.print("coinName: "+coinName.text()+"\t");
			String name = coinName.text();
			//price
			Elements price = coin.select("td.price.js-currency-price a");
			System.out.print("price: "+price.text()+"\t");
			String priceCoin = price.text();
			System.out.println();
			
			//insert into database
			CoinDAO daoCoin = new CoinDAO();
			daoCoin.InsertCoinInfor(name, priceCoin);
		}
	}

}

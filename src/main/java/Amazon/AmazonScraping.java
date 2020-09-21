package Amazon;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AmazonScraping {

    private static final String URL = "https://www.amazon.com/Best-Sellers/zgbs";

    public static void main (String[]args) throws Exception {


        Connection.Response response = Jsoup.connect(URL).execute().bufferUp();

        Document document = response.parse();

        for(Element element : document.getElementsByClass("zg_homeWidget") ){

            final String categoria = element.getElementsByTag("h3").get(1).text();

            for(Element element1 : element.getElementsByClass("zg_item zg_homeWidgetItem")){

                //Implementar resto do código.
            }

            //final String nomeProduto =

        }

        System.out.print("Rodou");

    }





}

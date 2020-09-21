package BooksToScrape;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebScraping {

    /**
     *
     * @author Gustavo Aquino
     * @since 20/09/2020
     *
     * Site: http://books.toscrape.com/
     * Algoritmo com o objetivo de capturar os dados de uma página web utilizando o JSoup.
     *
     *
     * */

    public static void main (String[]Args) throws Exception {

        //Conexão com o site
        Connection.Response response = Jsoup.connect("http://books.toscrape.com/")
                .execute().bufferUp();

        //Transformar o response em um documento para trabalhar com o html
        Document document = response.parse();

        //Inicialização de uma lista de livros.
        List<Books> listaLivros = new ArrayList<Books>();

        //For que captura as informações para inserir no objeto.
        for(Element element : document.getElementsByClass("col-xs-6 col-sm-4 col-md-3 col-lg-3")){

            final String titulo = element.getElementsByTag("h3").get(0).getElementsByAttribute("title").tagName("a").attr("title");

            final String preco = element.getElementsByClass("price_color").text().replace("£", "");

            final String tituloEstrela = element.getElementsByTag("p").get(0).attr("class");

            final Integer valorEstrela = retornarEstrelas(tituloEstrela);

            listaLivros.add(new Books(titulo, preco, valorEstrela));
        }

        //Mostrar os dados capturados no console.
        for(Books book : listaLivros){
            System.out.println("Hash " + book.getUuid() +  " Titulo: " + book.getTitulo() + " Preco: " + book.getPreco() + " Estrelas: " + book.getEstrelas());
        }
    }


    //Método para retornar o valor da quantidade de estrela que o livro tem. de 1 a 5.
    private static Integer retornarEstrelas(String nomeClass) {

        Map<String, Integer>  listaRating = new HashMap<String, Integer>(5);

        listaRating.put("star-rating One", 1);
        listaRating.put("star-rating Two", 2);
        listaRating.put("star-rating Three", 3);
        listaRating.put("star-rating Four", 4);
        listaRating.put("star-rating Five", 5);

        return listaRating.get(nomeClass);

    }

}

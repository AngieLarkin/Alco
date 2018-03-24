import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
// Парсер для вискарей
class Whiskey {


    //Забираем страницу и разбираем на элементы
  static Elements getPage() throws IOException {
     String url = "https://krasnoeibeloe.ru/catalog/viski/?sort_by=active_from&page_count=48&submit=ОК";
     Document page = Jsoup.parse(new URL(url), 30000);
      Element item = page.select("div[class=catalog_cont_row clearfix]").first();
      Elements name = item.select("div[class = product_item_name]");

      Elements prices = item.select("div[class = product_item__price]");
      String result = name.text() + prices.text();
      return prices;
  }


}

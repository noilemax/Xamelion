package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������������� on 16.12.2015.
 */
public class WorkUA implements Strategy
{
//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
//    https://moikrug.ru/vacancies?page=2&q=java+Dnepropetrovsk
//    https://moikrug.ru/vacancies?q=java+Dnepropetrovsk
//    https://moikrug.ru/vacancies/560164256
//    http://hh.ua/search/vacancy?text=java+����&page=1
//    "https://moikrug.ru/vacancies?q=java+%s&page=%d";

//    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
//    http://hh.ua/search/vacancy?text=java+ADDITIONAL_VALUE&page=PAGE_VALUE
//    http://hh.ua/search/vacancy?text=java+����&page=1
//    "http://hh.ua/search/vacancy?text=java+Kiev&page=3"

//    http://www.work.ua/jobs-kyiv-java/?days=125&page=2
//    http://www.work.ua/jobs/2001595/
//    http://www.work.ua/jobs-kyiv-java/


    //    @Override
//    public List<Vacancy> getVacancies(String searchString)
//    {
//        return null;
//    }
//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT = "http://www.work.ua/jobs-%s-java/?days=125&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0";
    private static final String referrer = "http://www.google.com";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        try
        {
            Document document;
            int pageCounter = 1;
            while (true)
            {
                document = getDocument(searchString, pageCounter++);
                if (document == null) break;
                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;
                for (Element element : elements)
                {
                    String title = "";
                    String salary = "";
                    String city = "";
                    String company = "";
                    String siteName = "http://work.ua/";
                    String url = "";
                    Vacancy vacancy = new Vacancy();
                    title = element.getElementsByClass("title").select("a").text();
                    url = siteName + element.getElementsByClass("title").select("a").attr("href");
                    salary = element.getElementsByClass("count").text();
                    city = element.getElementsByClass("location").text();
                    company = element.getElementsByClass("company_name").select("a[href]").text();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(company);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        }
        catch (Exception e)
        {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
//        searchString = URLEncoder.encode(searchString, "UTF-8");
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent(userAgent)
                .referrer(referrer)
                .get();
        document.html();
        return document;
    }
}

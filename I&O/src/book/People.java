package book;

import nu.xom.*;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by belows on 2016/12/26.
 */
public class People extends ArrayList<Person> {
    public People(String fileName) throws Exception  {
        Document doc = new Builder().build(new FileInputStream(fileName));
        Elements elements =
                doc.getRootElement().getChildElements();
        for(int i = 0; i < elements.size(); i++)
            add(new Person(elements.get(i)));
    }
    public static void main(String[] args) throws Exception {
        People p = new People("People.xml");
        System.out.println(p);
    }
}

package ex;

/**
 * Created by belows on 2016/12/26.
 */

import nu.xom.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ex31 {

    static class Person {
        String first;
        String last;
        String address;

        public Person(String first, String last, String address) {
            this.first = first;
            this.last = last;
            this.address = address;
        }

        public Element getXml() {
            Element element = new Element("person");
            Element first = new Element("first");
            first.appendChild(this.first);
            Element last = new Element("last");
            last.appendChild(this.last);
            Element address = new Element("address");
            address.appendChild(this.address);
            element.appendChild(first);
            element.appendChild(last);
            element.appendChild(address);
            return element;
        }

        public Person(Element element) {
            first = element.getFirstChildElement("first").getValue();
            last = element.getFirstChildElement("last").getValue();
            address = element.getFirstChildElement("address").getValue();
        }

        @Override
        public String toString() {
            return first + " " + last + ":" + address;
        }
    }

    public static void format(OutputStream outputStream, Document doc) throws IOException {
        Serializer serializer = new Serializer(outputStream,"UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        outputStream.flush();
    }

    public static void main(String[] args) throws IOException,ParsingException {
//        List<Person> persons = new ArrayList<>();
//        for (int i=0; i<10; ++i) {
//            persons.add(new Person("刘","奎"+i,"重庆潼南"));
//        }
//        Element root = new Element("persons");
//        for (Person p : persons) {
//            Element element = p.getXml();
//            root.appendChild(element);
//        }
//        Document doc = new Document(root);
//        format(System.out,doc);
//        format(new FileOutputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"),doc);
        read();
    }

    static  final String file = "/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt";

    public static void read() throws IOException,ParsingException {
        Document doc = new Builder().build(file);
        Element root = doc.getRootElement();
        Elements elements = root.getChildElements();

        List<Person> persons = new ArrayList<>();
        for (int i=0,size=elements.size(); i<size; ++i) {
            Element e = elements.get(i);
            Person p = new Person(e);
            persons.add(p);
        }
        System.out.println(persons);
    }

}


package BLL;

import Database.Transport;
import Repo.RepoTransport;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class AngajatBLL {


    public int delete(String t1, String t2, String t3, String t4) {

        RepoTransport repoTransport = new RepoTransport();
        Transport t = new Transport();

        t.setId(Integer.parseInt(t1));
        t.setNrLinie(t2);
        t.setStatie(t3);
        t.setNrStatie(Integer.parseInt(t4));

        return repoTransport.delete(t);


    }

    public int  insert(String t2, String t3, String t4) {

        RepoTransport repoTransport = new RepoTransport();
        Transport t = new Transport();

        t.setNrLinie(t2);
        t.setStatie(t3);
        t.setNrStatie(Integer.parseInt(t4));

        return repoTransport.insert(t);


    }

    public int update(String t1, String t2, String t3, String t4) {

        RepoTransport repoTransport = new RepoTransport();
        Transport t = new Transport();

        t.setId(Integer.parseInt(t1));
        t.setNrLinie(t2);
        t.setStatie(t3);
        t.setNrStatie(Integer.parseInt(t4));

        return repoTransport.update(t);


    }

    public void save() {
        RepoTransport repoTransport = new RepoTransport();
        ArrayList<Transport> t = repoTransport.findAll();
        saveXML(t);
        saveJson(t);
        saveCsv(t);
        saveTxt(t);
    }

    private void saveTxt(ArrayList<Transport> t) {
        String s = "";
        for (Transport i : t) {
            s += i.toString() + '\n';
        }

        FileWriter file = null;
        try {
            file = new FileWriter("out3.txt");

            file.write(s);

            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveCsv(ArrayList<Transport> t) {
        File file = new File("out1.csv");
        FileWriter outputfile = null;
        try {
            outputfile = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter writer = new CSVWriter(outputfile);
        String[] header = {"Id", "nrLinie", "statie", "nrStatie"};
        writer.writeNext(header);
        for (Transport i : t) {
            String[] s = {String.valueOf(i.getId()), i.getNrLinie(), i.getStatie(), String.valueOf(i.getNrStatie())};
            writer.writeNext(s);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveJson(ArrayList<Transport> t) {
        JSONObject jo = new JSONObject();
        for (Transport i : t) {
            Map m = new LinkedHashMap(3);
            m.put("nrLilie", i.getNrLinie());
            m.put("statie", i.getStatie());
            m.put("nrStatie", i.getNrStatie());
            jo.put(i.getId(), m);
            PrintWriter pw = null;
            try {
                pw = new PrintWriter("out2.json");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            pw.write(jo.toJSONString());

            pw.flush();
            pw.close();
        }


    }

    private void saveXML(ArrayList<Transport> t) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("Transport");
            document.appendChild(root);
            for (Transport i : t) {
                Element employee = document.createElement("Line");
                root.appendChild(employee);
                Attr attr = document.createAttribute("id");
                attr.setValue(String.valueOf(i.getId()));
                employee.setAttributeNode(attr);
                Element firstName = document.createElement("nrLilie");
                firstName.appendChild(document.createTextNode(i.getNrLinie()));
                employee.appendChild(firstName);
                Element lastname = document.createElement("statie");
                lastname.appendChild(document.createTextNode(i.getStatie()));
                employee.appendChild(lastname);
                Element email = document.createElement("nrStatie");
                email.appendChild(document.createTextNode(String.valueOf(i.getNrStatie())));
                employee.appendChild(email);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("out.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

}

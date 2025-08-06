package BLL;

import Database.CompareTransport;
import Database.Transport;
import OptimalPath.Graph;
import OptimalPath.Node;
import Repo.RepoTransport;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class ClientBLL {
    private final Graph graph = new Graph();

    public DefaultTableModel findLinie(String name) {

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Index");
        dtm.addColumn("NrLinie");
        dtm.addColumn("Statie");
        dtm.addColumn("NrStatie");
        ArrayList<Transport> xx = new ArrayList<>();
        String x = name;
        RepoTransport repo = new RepoTransport();
        xx = repo.findAll();
        ArrayList<Transport> y = new ArrayList<>();
        for (Transport i : xx) {
            if (x.equals(i.getNrLinie())) {
                y.add(i);
            }
        }
        int ct = 0;
        Collections.sort(y, new CompareTransport());
        for (Transport i : y) {
            ArrayList<Object> show = new ArrayList<>();
            ct++;
            show.add(ct);
            show.add(i.getNrLinie());
            show.add(i.getStatie());
            show.add(i.getNrStatie());
            dtm.addRow(show.toArray());
        }
        return dtm;
    }

    public DefaultTableModel refresh() {
        DefaultTableModel dtm = new DefaultTableModel();
        RepoTransport repo = new RepoTransport();
        ArrayList<Transport> x = new ArrayList<>();
        x = repo.findAll();
        ArrayList<String> y = new ArrayList<>();
        for (Transport i : x) {
            if (!y.contains(i.getNrLinie())) {
                y.add(i.getNrLinie());
            }
        }
        dtm.addColumn("Linie");
        Collections.sort(y);
        ArrayList<String> z = new ArrayList<>();
        for (String i : y) {
            z.add(i);
            dtm.addRow(z.toArray());
            z.clear();
        }
        return dtm;


    }

    public DefaultTableModel line(String t1, String t2) {
        RepoTransport repoTransport = new RepoTransport();
        ArrayList<Transport> t = repoTransport.findAll();
        createGraph(t);
        String dest = t2;
        Node source = getNode(graph.getNodes(), t1);
        if (dest == null || source == null) {
            return null;
        }
        Graph f = new Graph();
        f = graph.calculateShortestPathFromSource(graph, source);

        Set<Node> newNodes = graph.getNodes();

        int ct = 0;

        String linie = "-1";
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Linie");
        dtm.addColumn("Statie");
        Node prev = newNodes.iterator().next();
        for (Node i : newNodes) {
            if (i.getName().equals(dest)) {
                prev = source;
                ArrayList<String> show = new ArrayList<>();
                for (Node x : i.getShortestPath()) {
                    show = new ArrayList<>();
                    if (prev.equals(source)) {
                        linie = prev.getLini().get(0);
                        show.add(linie);
                    } else if (x.getLini().contains(linie)) {
                        show.add(linie);

                    } else {
                        linie = firstMatch(x, prev, t);
                        show.add(linie);
                    }

                    show.add(x.getName());

                    dtm.addRow(show.toArray());
                    prev = x;
                }
                show = new ArrayList<>();
                if (i.getLini().contains(linie)) {
                    show.add(linie);

                } else {
                    linie = firstMatch(i, prev, t);
                    show.add(linie);
                }

                show.add(i.getName());

                dtm.addRow(show.toArray());

            }


        }
        return dtm;
    }


    private String firstMatch(Node a, Node b, ArrayList<Transport> t) {


        for (String i : a.getLini()) {
            if (b.getLini().contains(i) && consec(i, b, a, t))
                return i;
        }
        return null;

    }

    private boolean consec(String nr, Node a, Node b, ArrayList<Transport> t) {
        for (int i = 0; i < t.size() - 1; i++) {
            if (t.get(i).getNrLinie().equals(nr) && t.get(i).getStatie().equals(a.getName()) && t.get(i + 1).getStatie().equals(b.getName()) && t.get(i + 1).getNrLinie().equals(nr)) {
                return true;
            }
        }
        return false;


    }

    private Node getNode(Set<Node> nodes, String name) {

        for (Node i : nodes) {
            if (i.getName().equals(name))
                return i;
        }
        return null;

    }

    private void createGraph(ArrayList<Transport> t) {

        ArrayList<Node> nodes = new ArrayList<>();

        for (int i = 0; i < t.size() - 1; i++) {
            if (!contains(nodes, t.get(i).getStatie())) {

                Node node = new Node(t.get(i).getStatie());
                node.getLini().add(t.get(i).getNrLinie());
                nodes.add(node);
            } else if (t.get(i).getNrLinie().equals(t.get(i + 1).getNrLinie())) {
                int ct = getIndex(nodes, t.get(i).getStatie());
                nodes.get(ct).getLini().add(t.get(i).getNrLinie());
            }
        }
        for (int i = 0; i < t.size() - 1; i++) {
            if (t.get(i).getNrLinie().equals(t.get(i + 1).getNrLinie())) {
                int ct = getIndex(nodes, t.get(i).getStatie());
                int ct2 = getIndex(nodes, t.get(i + 1).getStatie());
                nodes.get(ct).addDestination(nodes.get(ct2), 1);
                nodes.get(ct2).addDestination(nodes.get(ct), 1);
            }

        }
        for (Node i : nodes)
            this.graph.addNode(i);


    }

    private int getIndex(ArrayList<Node> nodes, String name) {
        int ct = 0;
        for (Node i : nodes) {

            if (i.getName().equals(name))
                return ct;
            ct++;
        }
        return ct;
    }

    private boolean contains(ArrayList<Node> nodes, String name) {

        for (Node i : nodes) {

            if (i.getName().equals(name))
                return true;

        }
        return false;
    }


}




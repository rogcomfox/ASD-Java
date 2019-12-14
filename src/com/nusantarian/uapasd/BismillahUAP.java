package com.nusantarian.uapasd;

import java.util.*;

class Node {

    private String name;
    private HashMap<String, Node> relations;

    public Node(String name) {
        this.name = name;
        this.relations = new HashMap<String, Node>();
    }

    public String getName() {
        return this.name;
    }

    public void addRelation(String relation, Node subject) {
        this.relations.put(relation, subject);
    }

    // head stop
// body start
    public Node findNodeByRelation(String relation) {
        // find family member's Node using relation given
        // your code goes here

        return null;
    }

}

class FamilyGraph {

    private ArrayList<Node> listFamilyMember;

    public FamilyGraph(ArrayList<String> listName, ArrayList<String> listRelation) {
        this.listFamilyMember = new ArrayList<Node>();
        initializeGraph(listName, listRelation);
    }

    private void initializeGraph(ArrayList<String> listName, ArrayList<String> listRelation) {
        // parsing data in ArrayList to Node
        listName.forEach(name -> {
            // creating nodes family member
            // your code goes here
            listFamilyMember.add(new Node(name));

        });

        listRelation.forEach(relation -> {
            // adding relation using addRelation method from each Node
            // your code goes here
            String a = relation.split(" ")[0];
            String hubung = relation.split(" ")[1];
            String b = relation.split(" ")[2];
            for (int i = 0; i < listFamilyMember.size(); i++) {
                if (b.equals(listFamilyMember.get(i))) {

                }
            }
        });
    }

    public String executeQuery(String query) {
        // process the query given by sender
        // use method findNodeByRelation to get the node wanted by query
        // your code goes here

        return "something";
    }

}
// body stop

// tail start
public class BismillahUAP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<String> listRelation = new ArrayList<String>();
        ArrayList<String> listQuery = new ArrayList<String>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("EXIT")) {
                break;
            } else {
                String command = line.split(" -> ")[0];
                String param = line.split(" -> ")[1];

                switch (command) {
                    case "ADD":
                        listName.add(param);
                        break;
                    case "RELATION":
                        listRelation.add(param);
                        break;
                    case "QUERY":
                        listQuery.add(param);
                        break;
                }
            }
        }

        for (String s : listQuery) {
            StringBuilder result = new StringBuilder();
            for (String value : listRelation) {
                String a = value.split(" ")[0];
                String b = value.split(" ")[1];
                String c = value.split(" ")[2];
                String e = b + " " + c;
                if (e.equals(s)) {
                    result.append(a).append(" ");
                }
            }
            System.out.println(result);
        }
    }
}
// tail stop
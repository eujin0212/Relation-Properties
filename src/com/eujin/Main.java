package com.eujin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input set: ");
        String set = scanner.next();
        System.out.print("Input relation: ");
        String relation = scanner.next();
//        String set = "1,2,3,4";
        String[] processedSet = set.split(",");
//        String relation = "(1,2),(1,3),(2,2),(2,4)";
//        String relation = "(1,1),(1,4),(2,2),(3,3),(4,4)";
//        String relation = "(1,2),(1,3),(2,1),(3,1)";
//        String relation = "(1,2),(2,2),(2,1)";
//        String relation = "(1,1),(2,2),(3,3),(3,1)";
        String replacedRelation = relation.replace(","," ");
        String replacedRelation1 = replacedRelation.replace(")","");
        String[] processedRelation = replacedRelation1.split("\\(");
        List<String> finalProcessedList = new ArrayList<String>();
        for(int i =0;i<processedRelation.length;i++){
            if(!processedRelation[i].isEmpty()){
                String[] splitRelation = processedRelation[i].split(" ");
                for(int j=0;j<splitRelation.length;j++){
                    finalProcessedList.add(splitRelation[j]);
                }
            }
        }

        Reflexive(processedSet,processedRelation);
        Symmetric(processedRelation);
        Asymmetric(processedSet,processedRelation);
        Antisymmetric(processedSet,processedRelation);

    }

    public static void Reflexive (String[] set, String[] relation){
        int correct = 0;
        for(int i=0;i<set.length;i++){
            for(int j =0;j<relation.length;j++){
                if(!relation[j].isEmpty()){
                    String[] splitRelation = relation[j].split(" ");
                    if(set[i].equals(splitRelation[0]) && set[i].equals(splitRelation[1])){
                            correct++;
                    }

                }
            }
        }
        if(set.length == correct){
            System.out.println("The relation is reflexive");
        }else {
            System.out.println("The relation is not reflexive");
        }
    }

    public static void Symmetric (String[] relation){
        int correct = 0;
        for(int i=0;i<relation.length;i++){
            if(!relation[i].isEmpty()){
                for(int j=0;j< relation.length;j++){
                    if(!relation[j].isEmpty()){
                        String[] processedRelation = relation[i].split(" ");
                        String checkRelation = processedRelation[1]+processedRelation[0];
                        if(checkRelation.equals(relation[j].replace(" ",""))){
                            correct++;
                        }
                    }
                }
            }
        }
        if(relation.length-1 == correct){
            System.out.println("The relation is symmetric");
        }else {
            System.out.println("The relation is not symmetric");
        }
    }

    public static void Asymmetric (String[] set, String[] relation){
        boolean checkDiagonal = false;
        for(int i=0;i<set.length;i++){
            for(int j =0;j<relation.length;j++){
                if(!relation[j].isEmpty()){
                    String[] splitRelation = relation[j].split(" ");
                    if(set[i].equals(splitRelation[0]) && set[i].equals(splitRelation[1])){
                        checkDiagonal = true;
                    }

                }
            }
        }
        int correct = 0;
        if(!checkDiagonal){
            for(int i=0;i<relation.length;i++){
                if(!relation[i].isEmpty()){
                    for(int j=0;j< relation.length;j++){
                        if(!relation[j].isEmpty()){
                            String[] processedRelation = relation[i].split(" ");
                            String checkRelation = processedRelation[1]+processedRelation[0];
                            if(checkRelation.equals(relation[j].replace(" ",""))){
                                correct++;
                            }
                        }
                    }
                }
            }
        }
        if(correct == 0){
            System.out.println("The relation is not asymmetric");
        }else if(relation.length-1 == correct) {
            System.out.println("The relation is not asymmetric");
        }else {
            System.out.println("The relation is asymmetric");
        }
    }

    public static void Antisymmetric (String[] set ,String[] relation){
        boolean checkDiagonal = false;
        for(int i=0;i<set.length;i++){
            for(int j =0;j<relation.length;j++){
                if(!relation[j].isEmpty()){
                    String[] splitRelation = relation[j].split(" ");
                    if(set[i].equals(splitRelation[0]) && set[i].equals(splitRelation[1])){
                        checkDiagonal = true;
                    }

                }
            }
        }
        int correct = 0;
        if(checkDiagonal){
            for(int i=0;i<relation.length;i++){
                if(!relation[i].isEmpty()){
                    for(int j=0;j< relation.length;j++){
                        if(!relation[j].isEmpty()){
                            String[] processedRelation = relation[i].split(" ");
                            String checkRelation = processedRelation[1]+processedRelation[0];
                            if(checkRelation.equals(relation[j].replace(" ",""))){
                                correct++;
                            }
                        }
                    }
                }
            }
        }
        if(correct==0){
            System.out.println("The relation is not antiasymmetric");
        }else if(relation.length-1 == correct){
            System.out.println("The relation is not antiasymmetric");
        }else {
            System.out.println("The relation is antisymmetric");
        }
    }
}

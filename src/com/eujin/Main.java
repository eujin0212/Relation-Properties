package com.eujin;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    public static Main main = new Main();
    private JFrame mainFrame;
    private JButton calculate, clear;
    private JPanel inputPanel, btnPanel, outputPanel;
    private JLabel label,label2, labelInt1, lableInt2 , labelReflexive, labelSymmeric, labelAsymmetic, labelAntisymmetric;
    private TitledBorder inputBorder, btnBorder, outputBorder;
    private JTextField xText, yText, reflexive, symmetric, asymmetric, antisymmetric;
    private JScrollPane scrollPane;

    public void showGUI() {
        mainFrame = new JFrame("Relation Properties");
        mainFrame.setSize(450,420);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(3);

        label = new JLabel("Welcome to Relation Properties",SwingConstants.CENTER);
        label.setBounds(0,5,400,30);
        label.setFont(label.getFont().deriveFont(13f));
        label2 = new JLabel("This system will display the properties of a relation",SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(13f));
        label2.setBounds(0,25,450,30);
        labelInt1 = new JLabel("Set :");
        labelInt1.setPreferredSize(new Dimension(60,25));
        lableInt2 = new JLabel("Relation :");
        lableInt2.setPreferredSize(new Dimension(60,25));
        labelReflexive = new JLabel("Reflexive :");
        labelReflexive.setPreferredSize(new Dimension(90,25));
        labelSymmeric = new JLabel("Symmetric :");
        labelSymmeric.setPreferredSize(new Dimension(90,25));
        labelAsymmetic = new JLabel("Asymmetric :");
        labelAsymmetic.setPreferredSize(new Dimension(90,25));
        labelAntisymmetric = new JLabel("Antisymmetric :");
        labelAntisymmetric.setPreferredSize(new Dimension(90,25));
        xText = new JTextField();
        xText.setPreferredSize(new Dimension(300,25));
        xText.setHorizontalAlignment(JTextField.CENTER);
        yText = new JTextField();
        yText.setPreferredSize(new Dimension(300,25));
        yText.setHorizontalAlignment(JTextField.CENTER);
        reflexive = new JTextField();
        reflexive.setPreferredSize(new Dimension(270,25));
        reflexive.setHorizontalAlignment(JTextField.CENTER);
        reflexive.setEditable(false);
        symmetric = new JTextField();
        symmetric.setPreferredSize(new Dimension(270,25));
        symmetric.setHorizontalAlignment(JTextField.CENTER);
        symmetric.setEditable(false);
        asymmetric = new JTextField();
        asymmetric.setPreferredSize(new Dimension(270,25));
        asymmetric.setHorizontalAlignment(JTextField.CENTER);
        asymmetric.setEditable(false);
        antisymmetric = new JTextField();
        antisymmetric.setPreferredSize(new Dimension(270,25));
        antisymmetric.setHorizontalAlignment(JTextField.CENTER);
        antisymmetric.setEditable(false);


        calculate = new JButton("Show Properties");
        calculate.setPreferredSize(new Dimension(200,25));
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String set, relation;
                set = xText.getText();
                relation = yText.getText();
                String[] processedSet = set.split(",");
                String replacedRelation = relation.replace(","," ");
                String replacedRelation1 = replacedRelation.replace(")","");
                String[] processedRelation = replacedRelation1.split("\\(");
                reflexive.setText(Reflexive(processedSet,processedRelation));
                symmetric.setText(Symmetric(processedRelation));
                asymmetric.setText(Asymmetric(processedSet,processedRelation));
                antisymmetric.setText(Antisymmetric(processedSet,processedRelation));
            }
        });

        clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(200,25));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xText.setText("");
                yText.setText("");
                reflexive.setText("");
                symmetric.setText("");
                asymmetric.setText("");
                antisymmetric.setText("");
            }
        });

        inputBorder = new TitledBorder("User Input");
        inputPanel = new JPanel();
        inputPanel.setBounds(10,50,420,90);
        inputPanel.setBorder(inputBorder);
        inputPanel.add(labelInt1);
        inputPanel.add(xText);
        inputPanel.add(lableInt2);
        inputPanel.add(yText);

        btnBorder = new TitledBorder("Choose Action");
        btnPanel = new JPanel();
        btnPanel.setBounds(10,140,420,60);
        btnPanel.setBorder(btnBorder);
        btnPanel.add(calculate);
        btnPanel.add(clear);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        outputBorder = new TitledBorder("Properties of Relation");
        outputPanel = new JPanel();
        outputPanel.setBounds(10,200,420,150);
        outputPanel.setBorder(outputBorder);
        outputPanel.add(labelReflexive);
        outputPanel.add(reflexive);
        outputPanel.add(labelSymmeric);
        outputPanel.add(symmetric);
        outputPanel.add(labelAsymmetic);
        outputPanel.add(asymmetric);
        outputPanel.add(labelAntisymmetric);
        outputPanel.add(antisymmetric);
        outputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        mainFrame.add(label);
        mainFrame.add(label2);
        mainFrame.add(inputPanel);
        mainFrame.add(btnPanel);
        mainFrame.add(outputPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        main.showGUI();

    }

    public static String Reflexive (String[] set, String[] relation){
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
            return "IS REFLEXIVE";
        }else {
            return "IS NOT REFLEXIVE";
        }
    }

    public static String Symmetric (String[] relation){
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
            return "IS SYMMETRIC";
        }else {
            return "IS NOT SYMMETRIC";
        }
    }

    public static String Asymmetric (String[] set, String[] relation){
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
            return "IS NOT ASYMMETRIC";
        }else if(relation.length-1 == correct) {
            return "IS NOT ASYMMETRIC";
        }else {
            return "IS ASYMMETRIC";
        }
    }

    public static String Antisymmetric (String[] set ,String[] relation){
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
            return "IS NOT ANTISYMMETRIC";
        }else if(relation.length-1 == correct){
            return "IS NOT ANTISYMMETRIC";
        }else {
            return "IS ANTISYMMETRIC";
        }
    }
}

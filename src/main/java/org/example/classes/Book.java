package org.example.classes;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.*;

public class Book {

    private ArrayList<Library> libraries;
    private ArrayList<Label> labels;
    private TextArea output;
    private Status st;
    private boolean read;


    public Book(TextArea text, Label  label1, Label  label2, Label  label3){
        this.read = true;

        this.libraries = new ArrayList<Library>();
        this.labels = new ArrayList<Label>();
        for (int i = 0; i < 3; i++)
            this.libraries.add(new Library());

        this.labels.add(label1);
        this.labels.add(label2);
        this.labels.add(label3);
        this.output = text;

        this.st = new Status();          // Start thread printing in text field
        this.st.start();
    }

    class Status extends Thread {
        public void run() {
            while (read) {
                for (int i = 0; i < 3; i++) {
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!read) return;
                    if (!libraries.get(i).isFree())
                        output.setText(output.getText() + " " + libraries.get(i).getStudent().getName() + " читает.\n");
                }
            }
        }
    }

    public void addStudent(Student stud){
        if (libraries.get(0).isFree()){
            libraries.get(0).setStudent(stud);
            labels.get(0).setText(stud.getName());
            return;
        }
        if (libraries.get(1).isFree()){
            libraries.get(1).setStudent(stud);
            labels.get(1).setText(stud.getName());
            return;
        }
        if (libraries.get(2).isFree()){
            libraries.get(2).setStudent(stud);
            labels.get(2).setText(stud.getName());
            return;
        }
    }

    public void deleteStudent(int number){
        if (!libraries.get(number).isFree()){
            libraries.get(number).removeStudent();
            labels.get(number).setText(" ");
        }
    }

    public void closeBook() throws InterruptedException {
        read = false;
        Thread.sleep(300);          // We wait before all thread stop
        st.interrupt();
    }
}
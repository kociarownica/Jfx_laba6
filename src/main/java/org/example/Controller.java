package org.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.classes.Student;
import org.example.classes.Book;


public class Controller {

    Book book;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textField;


    @FXML
    private Label labelPetFeed2;

    @FXML
    private Label labelPetFeed3;

    @FXML
    private Label labelPetFeed1;

    @FXML
    void addStudent3(ActionEvent event) {
        Student s3 = new Student("Студент 3");
        book.addStudent(s3);
    }

    @FXML
    void addStudent2(ActionEvent event) {
        Student s2 = new Student("Студент 2");
        book.addStudent(s2);
    }

    @FXML
    void addStudent1(ActionEvent event) {
        Student s1 = new Student("Студент 1");
        book.addStudent(s1);
    }

    @FXML
    void addStudent4(ActionEvent event) {
        Student s4 = new Student("Студент 4");
        book.addStudent(s4);
    }

    @FXML
    void clearBook1(ActionEvent event) {
        book.deleteStudent(0);
    }

    @FXML
    void clearBook2(ActionEvent event) {
        book.deleteStudent(1);
    }

    @FXML
    void clearBook3(ActionEvent event) {
        book.deleteStudent(2);
    }

    @FXML
    void clearTextField(ActionEvent event) {
        textField.clear();
    }

    @FXML
    void initialize() {
        book = new Book(textField,  labelPetFeed1, labelPetFeed2, labelPetFeed3);
    }
}
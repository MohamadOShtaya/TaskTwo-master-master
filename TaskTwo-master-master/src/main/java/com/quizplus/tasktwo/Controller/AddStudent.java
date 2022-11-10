package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import com.quizplus.tasktwo.Service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;

public class AddStudent {


    StudentService studentService = new StudentService();
    @FXML
    private TextField txtAvg;
    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;
    @FXML
    void SaveStudent(ActionEvent event) {
        try {
            String sName = txtName.getText();
            String gender = txtGender.getText();
            String dep = txtDepartment.getText();
            double avg = Double.parseDouble(txtAvg.getText());
            Student student = new Student(sName,gender,avg,dep);
            studentService.save(student);
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("Please enter your new student data ");
            alert.show();
        }
    }
}

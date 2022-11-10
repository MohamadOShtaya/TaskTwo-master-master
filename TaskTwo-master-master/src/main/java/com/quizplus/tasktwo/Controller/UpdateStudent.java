package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Student;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Rerpositry.StudentRepo;
import com.quizplus.tasktwo.Service.CourseService;
import com.quizplus.tasktwo.Service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateStudent {


    StudentService studentService = new StudentService();
    @FXML
    private Label txt;

    @FXML
    private TextField txtDep;

    @FXML
    private TextField txtGPA;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtName;

    @FXML
    void Update() {
        try {

            String studentName = txtName.getText();
            String Gender = txtGender.getText();
            double GPA=0;
            if(!txtGPA.getText().isEmpty()) {
                 GPA = Double.parseDouble(txtGPA.getText());
            }
            String department = txtDep.getText();
            tabStudentsControllers tab1Controllers = new tabStudentsControllers();
            int id = tabStudentsControllers.id;
            Student tempStudent = studentService.findById(id);

            if(!txtName.getText().isEmpty()){
                tempStudent.setStudentName(studentName);
            }
            else {
                tempStudent.setStudentName(tempStudent.getStudentName());
            }
            if(!txtGender.getText().isEmpty()){
                tempStudent.setStudentGender(Gender);
            }
            else {
                tempStudent.setStudentGender(tempStudent.getStudentGender());
            }
            if(!txtGPA.getText().isEmpty()){
                tempStudent.setStudentAvg(GPA);

            }
            else {
                tempStudent.setStudentAvg(tempStudent.getStudentAvg());

            }
            if(!txtDep.getText().isEmpty()){
                tempStudent.setStudentDepartmentName(department);
            }
            else {
                tempStudent.setStudentDepartmentName(tempStudent.getStudentDepartmentName());
            }
             studentService.Update(tempStudent);


        }
        catch (Exception ex){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("Please select add data in text");
            alert.show();
        }


    }

}


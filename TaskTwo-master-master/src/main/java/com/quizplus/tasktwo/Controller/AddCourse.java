package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddCourse {
    CourseService courseService = new CourseService();

    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTeacher;
    @FXML
    private CheckBox yes,no;

    @FXML
    void save() {
        try {
            String courseName = txtName.getText();
            String courseTeacher = txtTeacher.getText();
            int capacity = Integer.parseInt(txtCapacity.getText());
            boolean IsAva;
            if(yes.isSelected()){
                 IsAva = true;
            }
            else {
                 IsAva = false;
            }

            Course course = new Course(courseName,courseTeacher,capacity,null,IsAva);
            courseService.save(course);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
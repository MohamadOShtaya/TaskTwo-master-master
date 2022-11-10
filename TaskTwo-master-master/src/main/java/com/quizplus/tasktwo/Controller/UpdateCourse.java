package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.io.IOException;


public class UpdateCourse {
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


    CourseService courseService = new CourseService();
    public static  int id;
    public void OnClickUpdate() {

            try {
                String courseName = txtName.getText();
                String courseTeacher = txtTeacher.getText();
                int capacity=0;
                if(!txtCapacity.getText().isEmpty()){
                    capacity = Integer.parseInt(txtCapacity.getText());
                }

                tabCoursesControllers tab1Controllers = new tabCoursesControllers();
                int id = tab1Controllers.id;
                Course tempCourse = courseService.findById(id);


                if(txtName.getText()!=null){
                    tempCourse.setCourseName(courseName);
                }
                else {
                    tempCourse.setCourseName(tempCourse.getCourseName());
                }
                if(txtTeacher.getText()!=null){
                    tempCourse.setTeacherName(courseTeacher);
                }
                else {
                    tempCourse.setTeacherName(tempCourse.getTeacherName());
                }
                if(txtCapacity.getText()!=null){
                    tempCourse.setCourseCapacity(capacity);
                }
                else {
                    tempCourse.setCourseCapacity(tempCourse.getCourseCapacity());
                }

                if(yes.isSelected()){
                    tempCourse.setIsAvilable(true);
                }
                else if(no.isSelected()){
                    tempCourse.setIsAvilable(false);
                }
                else {
                    tempCourse.setIsAvilable(tempCourse.isAvilable());
                }
                  courseService.Update(tempCourse);

            }
            catch (Exception ex){
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Alert Message");
                alert.setContentText("Please select add data in text");
                alert.show();
            }

    }
}

package com.quizplus.tasktwo.Controller;

import com.quizplus.tasktwo.Main;
import com.quizplus.tasktwo.Models.Course;
import com.quizplus.tasktwo.Rerpositry.CourseRepo;
import com.quizplus.tasktwo.Service.CourseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class tabCoursesControllers {
    public static int id;
    List<Course> courses;
    ObservableList<String> ListObserv = FXCollections.observableArrayList();

    CourseService courseService = new CourseService();
    @FXML  Button Get;
    @FXML private TextField txt = new TextField();
    @FXML private ListView<String> list = new ListView<>();
    @FXML private  TextArea tetxArea = new TextArea();

    public List<Course> getCourses() {
         courses=  courseService.findall();
         List<Course> listCourse = new ArrayList<>();
        for(int i=0;i<courses.size();i++){
            ListObserv.add(courses.get(i).getCourseName());
        }

        for (int i=0;i<ListObserv.size();i++){
            list.getItems().add(ListObserv.get(i));
        }
        return listCourse;
    }

    public void deleteCourses(ActionEvent actionEvent){
        try {
            int index = list.getSelectionModel().getSelectedIndex();
            int courseId = courses.get(index).getCourseId();
            System.out.println(" " + index);
            if(list.getSelectionModel().getSelectedIndex()>=0){

                try{
                    System.out.println(courseId);
                    courseService.deleateById(courseId);
                    list.getItems().remove(index);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("this id has been alredy deleted");
                }
            }
            else {
                String str = txt.getText();
                int num = Integer.parseInt(str);
                try{
                    System.out.println(num);
                    courseService.deleateById(num);
                }
                catch (Exception ex){
                    System.out.println("this id has been alredy deleted");
                }
            }

        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("Please select course or enter course Id");
            alert.show();
        }

    }
    public void ListView(ListView.EditEvent<String> stringEditEvent) {
        System.out.println(list.getSelectionModel().selectionModeProperty().toString());
    }

    public void Add(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddCourse.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setTitle("Add Course !");
            stage.setScene(scene);
            stage.show();



        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("EROR");
            alert.show();
        }
    }
  public int returnIndex(){
        return list.getSelectionModel().getSelectedIndex();
  }

    public int Update() throws IOException {

        try {
            int index = returnIndex();
            id = courses.get(index).getCourseId();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UpdateCourse.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            stage.setTitle("Update Course !");
            stage.setScene(scene);
            stage.show();
            UpdateCourse updateCourse = new UpdateCourse();
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("please select courses");
            alert.show();
            ex.printStackTrace();
        }

        return id;
    }

    public void ShowCourses() {
        try {
            int index = list.getSelectionModel().getSelectedIndex();
            int courseId = courses.get(index).getCourseId();
            String strr=null;
             strr = courseService.findById(courseId).toString();
            System.out.println(strr);
            tetxArea.appendText(strr);
        }
        catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Alert Message");
            alert.setContentText("please select courses");
            alert.show();
        }
    }
    public void clear(ActionEvent actionEvent) {
        tetxArea.clear();
    }
}
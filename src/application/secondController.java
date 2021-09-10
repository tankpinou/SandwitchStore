package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class secondController implements Initializable{

    Order myOrder = new Order();

    @FXML
    private ListView<OrderLine> myList = new ListView<OrderLine>();

    @FXML
    private Button sameOrder, removeOrder, clearOrder, back;

    @FXML
    private TextField totalText;
    
    DecimalFormat d = new DecimalFormat("0.00");

    void setMyList(Order order) {
        myList.getItems().clear();
        myOrder = order;
        for (int i = 0; i < myOrder.getOrderLines().size(); i++) {
            myList.getItems().add(myOrder.getOrderLines().get(i));
        }
        orderTotal();
    }

    @FXML
    public void clearMe(ActionEvent event) throws IOException {
        myList.getItems().clear();
        myOrder.resetOrderlines();

        FXMLLoader loadMe = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = (Parent) loadMe.load();
        mainController main = loadMe.getController();
        
        main.myOrder = new Order();
        //main.reset();

        //main.setMyOrder(myOrder);

       // orderTotal();
    }

    @FXML
    public void goBack(ActionEvent event) {
        back.getScene().getWindow().hide();
    }

    @FXML
    public void orderTotal() {
        double total = 0;

        for (int i = 0; i < myOrder.getOrderLines().size(); i++) {
            total += myOrder.getOrderLines().get(i).getPrice();
        }
        totalText.setText(String.valueOf(d.format(total)));
    }

    @FXML
    public void addSameOrder(ActionEvent event) throws IOException {
       
    	if (myList.getSelectionModel().getSelectedItems().size() == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("NO SANDWICH SELECTED");
            alert.setHeaderText("Please Select a Sandwich");
            alert.showAndWait();
            return;
        }

        FXMLLoader loadMe = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = (Parent) loadMe.load();
        mainController main = loadMe.getController();

        ObservableList<OrderLine> selected = myList.getSelectionModel().getSelectedItems();

        for (OrderLine i: selected) {
            OrderLine tmp = new OrderLine(i);
            tmp.setOrderLineNumber(myOrder.getOrderLines().get(myOrder.getOrderLines().size()-1).getLineNumber() + 1);
            myOrder.add(tmp);
        }
        main.setMyOrder(myOrder);

        System.out.println(myOrder.getOrderLines().size());
        myList.getItems().clear();
        for (int i = 0; i < myOrder.getOrderLines().size(); i++) {
            myList.getItems().add(myOrder.getOrderLines().get(i));
            orderTotal();
        }


        //orderTotal();
    }

    @FXML
    public void removeOrderLine(ActionEvent event) throws IOException {
        if (myList.getSelectionModel().getSelectedItems().size() == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("NO SANDWICH SELECTED");
            alert.setHeaderText("PLEASE SELECT A SANDWICH OR GO BACK");
            alert.showAndWait();
            return;
        }

        FXMLLoader loadMe = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = (Parent) loadMe.load();
        mainController main = loadMe.getController();

        ObservableList<OrderLine> selected = myList.getSelectionModel().getSelectedItems();

        for (OrderLine i: selected) {
            i.setOrderLineNumber(1);
            myOrder.remove(i);
            main.setMyOrder(myOrder);
            //setMyList(myOrder);

            orderTotal();
        }
        setMyList(myOrder);
        System.out.println(myOrder.getOrderLines().size());




        //orderTotal();
    }
    
boolean isEmpty() {
		
		return myList.getItems().isEmpty();
	}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myList.getSelectionModel().setSelectionMode((SelectionMode.MULTIPLE));
    }



}
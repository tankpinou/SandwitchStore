package application;


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


import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class mainController implements Initializable{
	
	secondController second = new secondController();
	
	//public mainController() {
		
	//}


	Chicken chickenVar;
	Beef beefVar ;
	Fish fishVar ;

	Order myOrder = new Order();
	int linenumber=1;
	OrderLine actualOrder= new OrderLine();

	String choosen="";
	
	DecimalFormat d = new DecimalFormat("0.00");

	@FXML
	private ImageView imageView;

    @FXML
    private ComboBox<String> sandwichComboBox;

    @FXML
    private Button addIngredientbutton, viewOrderButton, addToOrderButton,clearListbutton,removeIngredientButton;

    @FXML
    private ListView<String> basicsIngredientsList = new ListView<String>(),infoArea ;

    @FXML
    private ListView<String> ingredients =new ListView<String>() , selectedIngredients =new ListView<String>();


    @FXML
    private TextField orderTotal;

    @FXML
    private Image chikenImage = new Image("ChickenSandwich.jpg");
    private Image beefImage = new Image("roastbeefsandwich.jpg");
    private Image fishImage = new Image("GrilledFishSandwiche.jpg");

     ObservableList<String> chikenBasicIngredientslist = FXCollections.observableArrayList("Fried Chicken","Spicy Sauce","Pickles");
     ObservableList<String> beefBasicIngredientslist = FXCollections.observableArrayList("Roast Beef","Provolone Cheese","Mustard");
     ObservableList<String> fishBasicIngredientslist = FXCollections.observableArrayList("Grilled Snapper","Cilantro","Lime");
     ObservableList<String> availableIngredientslist = FXCollections.observableArrayList("Mushrooms","Onions", "Ketchup","Peppers","Jalapenos","Oregano","Pickles","Tuna","Chipotle Sauce","Cheese");
     ObservableList<String> selected;


    @FXML
    void onAddToOrder(ActionEvent event) {
    	
    	if (second.isEmpty() && linenumber!= 1 && myOrder.getOrderLines().isEmpty())
	    	linenumber =1;
     	
     	

    	if(choosen.equalsIgnoreCase("chicken")) {
    		chickenVar = new Chicken();
    		selected = selectedIngredients.getItems();
    		for(String s: selected)
    			chickenVar.add(s);

    		actualOrder.setLine(linenumber,chickenVar);
    		myOrder.add(actualOrder);

    		//infoArea.appendText(chickenVar+" Price:$"+chickenVar.price()+"\n");
    		infoArea.getItems().add("Sandwich added. \n");


    }
    	if(choosen.equalsIgnoreCase("beef")) {
    		beefVar = new Beef();

    		 selected = selectedIngredients.getItems();

    		for(String s: selected)
    			beefVar.add(s);

    		actualOrder.setLine(linenumber,beefVar);
    		myOrder.add(actualOrder);
			infoArea.getItems().add("Sandwich added. \n");

    	 }
    	if(choosen.equalsIgnoreCase("fish")) {
    		
    		fishVar = new Fish();

    		selected = selectedIngredients.getItems();


    		for(String s: selected)
    			fishVar.add(s);

    		actualOrder.setLine(linenumber,fishVar);
    		myOrder.add(actualOrder);
			infoArea.getItems().add("Sandwich added. \n");
    	 }
    	linenumber++;
    	actualOrder = new OrderLine();

    }

    @FXML
    void addIngredient(ActionEvent event) {

    	if (ingredients.getSelectionModel().getSelectedItems().size()+selectedIngredients.getItems().size()>6 ) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Maximum ingredients");
        	alert.setHeaderText("Can't add more than 6 extra ingredients!");
        	alert.showAndWait();

    		}

    	else {

    	for ( String s :ingredients.getSelectionModel().getSelectedItems() ) {
    		if (!selectedIngredients.getItems().contains(s)) {
        	selectedIngredients.getItems().add(s);
    		}
    		}
    	int s;
    	s=selectedIngredients.getItems().size();
    	orderTotal.setText(String.valueOf(actualOrder.getPrice()+(1.99*s)));
    	}

    }

    @FXML
    void clearTheList(ActionEvent event) {
    	selectedIngredients.getItems().clear();
    	orderTotal.setText(String.valueOf(d.format(actualOrder.getPrice())));
    }

    @FXML
    void removeIngredient(ActionEvent event) {

    	int s;
    	selectedIngredients.getItems().removeAll(selectedIngredients.getSelectionModel().getSelectedItems());
    	s=selectedIngredients.getItems().size();
    	orderTotal.setText(String.valueOf(actualOrder.getPrice()+(1.99*s)));
    }


    @FXML
    void Selectsandwitch(ActionEvent event) {

    	if(sandwichComboBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("beef")) {
    		imageView.setImage(beefImage);
    		basicsIngredientsList.setItems(beefBasicIngredientslist);
    		choosen="beef";
    		beefVar = new Beef();
    		actualOrder.setSandwich(beefVar);
    		orderTotal.setText(String.valueOf(d.format(actualOrder.getPrice())));

    	}

    	else if(sandwichComboBox.getSelectionModel().getSelectedItem().equalsIgnoreCase("fish")) {
    		imageView.setImage(fishImage);
    		basicsIngredientsList.setItems(fishBasicIngredientslist);
    		choosen="fish";
    		fishVar = new Fish();
    		actualOrder.setSandwich(fishVar);
    		orderTotal.setText(String.valueOf(d.format(actualOrder.getPrice())));


    	}
    	else {

			imageView.setImage(chikenImage);
			basicsIngredientsList.setItems(chikenBasicIngredientslist);
			choosen="chicken";
			chickenVar = new Chicken();
			actualOrder.setSandwich(chickenVar);
			orderTotal.setText(String.valueOf(d.format(actualOrder.getPrice())));


    	}
    	if (second.isEmpty() && linenumber!= 1 && myOrder.getOrderLines().isEmpty())
	    	linenumber =1;
    	
    }

    @FXML
	void selectSecondStage(ActionEvent event) {
    	
    	
    	
    	try {
			FXMLLoader loadMe = new FXMLLoader(getClass().getResource("second.fxml"));
			Parent root = (Parent) loadMe.load();
			second = loadMe.getController();
			second.setMyList(myOrder);

			Stage secondStage = new Stage();
			secondStage.setTitle("View Order");
			secondStage.setScene(new Scene(root, 900, 700));
			secondStage.show();
		    
		    
		} catch (Exception e) {
    		//System.out.println("error");
    		e.printStackTrace();
		}
    	
    	if (second.isEmpty() && linenumber!= 1 && myOrder.getOrderLines().isEmpty())
	    	linenumber =1;
     	
    	infoArea.getItems().clear();
     
    	
    	
	}

	void setMyOrder(Order order) {
    	myOrder = order;
	}

	public Order getMyOrder() {
    	return myOrder;
	}

	void reset() {
    	myOrder = new Order();
    	myOrder.setLineNumber(1);
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("Chicken","Beef","Fish");
		sandwichComboBox.setItems(list);
	 	basicsIngredientsList.getItems().addAll("Fried Chicken","Spicy Sauce","Pickles");
     	ingredients.setItems(availableIngredientslist);
     	ingredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
     	selectedIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
     	choosen="chicken";
     	orderTotal.setText(String.valueOf(actualOrder.getPrice()));
     	 

	}
 
}

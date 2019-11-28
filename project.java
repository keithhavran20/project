import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.concurrent.atomic.AtomicBoolean;


public class project extends Application {

    private BorderPane bp = new BorderPane();
    private  GridPane g1 = new GridPane();
    private GridPane g2 = new GridPane();
    private FlowPane fp = new FlowPane();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();


    private ObservableList<storage> data;

    public void start(Stage s) {
        TableView<storage> tbl;
        tbl = new TableView<>();
        Alert alerts = new Alert(Alert.AlertType.INFORMATION);
        Alert alerts2 = new Alert(Alert.AlertType.ERROR);
        Scene sc1, sc2, sc3, sc4;
        sc1 = new Scene(new Group());
        s.sizeToScene();
        s.setTitle("Project");


        int vpos = 20;
        fp.setHgap(20);
        fp.setAlignment(Pos.CENTER_RIGHT);


        Button b2 = new Button("Add");
        Button b3 = new Button("Update");
        Button b4 = new Button("Remove");
        Button b5 = new Button("Print");



        fp.getChildren().addAll(b2, b3, b4, b5);

        data = FXCollections.observableArrayList();
        s.setWidth(800);
        s.setHeight(500);
        final Label l1 = new Label("Items");
        l1.setFont(new Font("Arial", 20));



        TableColumn item = new TableColumn("Item");
        item.setMinWidth(100);

        item.setCellValueFactory(new PropertyValueFactory<storage, String>("name"));



        TableColumn itemCode = new TableColumn("Item Code");
        itemCode.setMinWidth(20);
        itemCode.setCellValueFactory(new PropertyValueFactory<storage, Integer>("code"));

        TableColumn q = new TableColumn("Quantity");
        q.setMinWidth(10);
        q.setCellValueFactory(new PropertyValueFactory<storage, Integer>("Quantity"));

        TableColumn price = new TableColumn("Price");
        price.setMinWidth(10);
        price.setCellValueFactory(new PropertyValueFactory<storage, Double>("Price"));

        TableColumn discount = new TableColumn("Discount");
        discount.setMinWidth(10);
        discount.setCellValueFactory(new PropertyValueFactory<storage, Double>("Discount"));

        tbl.setEditable(true);
        tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tbl.setItems(data);
        tbl.getColumns().addAll(item, itemCode, q, price, discount);
        vb1.getChildren().addAll(l1, tbl);


        Label ln = new Label();
        ln.setText("Item Name");
        Label l2 = new Label();
        l2.setText("Item Code");
        Label l3 = new Label();
        l3.setText("Quantity");
        Label l4 = new Label();
        l4.setText("Price");
        Label l5 = new Label();
        l5.setText("Discount");

        TextField ti = new TextField();
        TextField tc = new TextField();
        TextField tq = new TextField();
        TextField tp = new TextField();
        TextField td = new TextField();
        Button b1 = new Button("Add");

        g1.add(ln, 0, 0);
        g1.add(ti, 1, 0);
        g1.add(l2, 0, 1);
        g1.add(tc, 1, 1);
        g1.add(l3, 0, 2);
        g1.add(tq, 1, 2);
        g1.add(l4, 0, 3);
        g1.add(tp, 1, 3);
        g1.add(l5, 0, 4);
        g1.add(td, 1, 4);

        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setHgap(10);
        g1.setVgap(10);
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(5, 5, 5,5));
        vb2.getChildren().addAll(g1, b1);
        vb2.setVisible(false);
        bp.setPadding(new Insets(10, 10, 10, 10));
        bp.setLeft(vb2);
        bp.setRight(vb1);
        bp.setTop(fp);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                vb2.setVisible(true);
            }
        };
        b2.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                data.add(new storage(ti.getText(), Integer.parseInt(tc.getText()), Integer.parseInt(tq.getText()), Double.parseDouble(tp.getText()), Double.parseDouble(td.getText()))); //to be populated in the Table view


                ti.clear();
                tc.clear();
                tq.clear();
                tp.clear();
                td.clear();

            }
        };
        b1.setOnAction(event2);

        ((Group) sc1.getRoot()).getChildren().add(bp);
        s.setScene(sc1);
        s.show();


        Label ul2 = new Label("Enter the item name");
        ul2.setFont(new Font("Courier", 14));

        Label ln1 = new Label("Name");
        Label ln2 = new Label("Code");
        Label ln3 = new Label("Quantity");
        Label ln4 = new Label("Price");
        Label ln5 = new Label("Discount");

        TextField ti2 = new TextField();
        TextField tc2 = new TextField();
        TextField tq2 = new TextField();
        TextField tp2 = new TextField();
        TextField td2 = new TextField();

        Button b12 = new Button("Update");
        g2.add(ln1, 0, 0);
        g2.add(ti2, 1, 0);
        g2.add(ln2, 0, 1);
        g2.add(tc2, 1, 1);
        g2.add(ln3, 0, 2);
        g2.add(tq2, 1, 2);
        g2.add(ln4, 0, 3);
        g2.add(tp2, 1, 3);
        g2.add(ln5, 0, 4);
        g2.add(td2, 1, 4);


        Label stamp= new Label();
        g2.setPadding(new Insets(10, 10, 10, 10));
        g2.setHgap(10);
        g2.setVgap(10);
        vb3.getChildren().addAll(ul2, g2, b12, stamp);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(10, 10, 10, 10));

        EventHandler<ActionEvent> event10 = new EventHandler<ActionEvent>()
        {
            @Override

            public void handle(ActionEvent event)
            {
                String twenty = ti2.getText();
                boolean f=false;
                for (int i = 0; i < tbl.getItems().size(); i++)
                {
                    if (((String)tbl.getItems().get(i).getName()).equals(twenty))
                    {
                        storage p = new storage(ti2.getText(), Integer.parseInt(tc2.getText()), Integer.parseInt(tq2.getText()), Double.parseDouble(tp2.getText()), Double.parseDouble(td2.getText()));
                        tbl.getItems().set(i, p);
                        f=true;
                    }
                }
                if (f)
                {
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Update Successful!");
                    alerts.showAndWait();
                }

                else
                {
                    alerts2.setTitle("Error");
                    alerts2.setHeaderText(null);
                    alerts2.setContentText("Item not found..");
                    alerts2.showAndWait();
                }
                ti2.clear();
                tc2.clear();
                s.setScene(sc1);
            }
        };
        b12.setOnAction(event10);

        sc2 = new Scene(vb3, 400, 200);

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                s.setScene(sc2);
            }
        };

        b3.setOnAction(event3);


        VBox vb4= new VBox();
        Label rl= new Label("Enter the item name to remove");
        TextField tr= new TextField();
        Button dl= new Button("Delete");
        vb4.getChildren().addAll(rl, tr, dl);
        vb4.setPadding(new Insets(10, 10, 10, 10));
        vb4.setSpacing(10);
        sc3= new Scene(vb4, 300, 200);

        EventHandler<ActionEvent> event23 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                String sid = tr.getText();
                boolean df =false;
                for (int i = 0; i < tbl.getItems().size(); i++)
                {
                    if (((String)tbl.getItems().get(i).getName()).equals(sid))
                    {
                        tbl.getItems().remove(i);
                        df=true;
                    }
                }
                if (df)
                {
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Deleted");
                    alerts.showAndWait();
                }

                else
                {
                    alerts2.setTitle("Error");
                    alerts2.setHeaderText(null);
                    alerts2.setContentText("Entered info not found..");
                    alerts2.showAndWait();
                }
                ti2.clear();
                s.setScene(sc1);
            }
        };
        dl.setOnAction(event23);

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                s.setScene(sc3);
            }
        };
        b4.setOnAction(event4);

        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                System.out.print(data);
            }
        };
        b5.setOnAction(event5);



    }

    public static void main (String[]args)
    {
        launch(args);
    }
}

package com.imageapi.service;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import org.json.JSONObject;


public class APIService extends Application{

    static String imgURL = "";

    public static  void imageData() throws IOException{

        StringBuffer response = new DataUrls().getResponseData();
        if(response!=null){
            JSONObject obj = new JSONObject(response.toString());
            JSONObject urlObject = obj.getJSONObject("urls");

            imgURL = urlObject.getString("small");

        }
        else{
            System.out.println("Response is Empty");
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{

        imageData();

        Image image = new Image(imgURL);

        ImageView imageView = new ImageView(image);

        Pane imgPane = new Pane();
        imgPane.getChildren().add(imageView);

        Scene scene = new Scene(imgPane,image.getWidth(),image.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setTitle("ImageView Example");
        primaryStage.show();
    }
}

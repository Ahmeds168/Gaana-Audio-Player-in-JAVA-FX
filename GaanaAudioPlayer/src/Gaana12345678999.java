import java.net.URL;
import java.text.DecimalFormat;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.DragEvent;
import javafx.scene.effect.*;
import javafx.collections.ObservableMap;
import javafx.collections.MapChangeListener;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import java.io.*;
import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.text.TextAlignment;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import java.net.URISyntaxException;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;


public class Gaana12345678999 extends Application  {


    Label playTime= new Label();
    
    Slider seekBar= new Slider(); 
    Dragboard db;
    File [] songsList= new File[50];
    int nSongs=0;
    int curSong=0;
    Media song;
    MediaPlayer player;
    ImageView view;
    boolean containsimg=false;
public  void start(Stage primaryStage1) throws URISyntaxException {
    playTime.setText("Song Duration");
    Button btn = new Button("Play");
    Button stop= new Button("Stop");
    Button importB = new Button("Import");
    Button next = new Button("Next");
    Button previous = new Button("Previous");
 /////// Play
    btn.setOnAction(new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
            if(nSongs==0){
                JFileChooser chooser =new JFileChooser();
                //FileNameExtensionFilter filter = new FileNameExtensionFilter(".mp3",".mp3");
                //chooser.setFileFilter(filter);
                int option=chooser.showOpenDialog(null);
                if(option==JFileChooser.APPROVE_OPTION){
                    File f = new File(chooser.getSelectedFile().getAbsolutePath());
                    songsList[nSongs++]=f;
                    playMp3(f);
                }
                else if(option==1)
                    e.consume();
                else
                    JOptionPane.showMessageDialog(chooser, "File Not Supported,", "Ooops!", JOptionPane.ERROR_MESSAGE);
            }
            //play if song is already inserted
            else{
                
                playMp3(songsList[curSong].getAbsoluteFile());
                
                
            }
        }
       
       
    });
    /////// Stop
    stop.setOnAction(new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
        player.stop();
        
        }
       
       
    });
    //////// import
    importB.setOnAction(new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
            JFileChooser chooser =new JFileChooser();
                //FileNameExtensionFilter filter = new FileNameExtensionFilter(".mp3",".mp3");
                //chooser.setFileFilter(filter);
                int option=chooser.showOpenDialog(null);
                if(option==JFileChooser.APPROVE_OPTION){
                    File f = new File(chooser.getSelectedFile().getAbsolutePath());
                    songsList[nSongs++]=f;
                    
                }
                else if(option==1)
                    e.consume();
                else
                    JOptionPane.showMessageDialog(chooser, "File Not Supported,", "Ooops!", JOptionPane.ERROR_MESSAGE);
      
        }
       
       
    });
    ///// next
     next.setOnAction(new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
            if(curSong==nSongs-1)
                curSong=-1;
            player.stop();
        playMp3(songsList[curSong++]);
        
        }
       
       
    });
/////previous
     next.setOnAction(new EventHandler <ActionEvent>(){
        public void handle(ActionEvent e){
            if(curSong==-1)
                curSong=nSongs-1;
        player.stop();
            playMp3(songsList[curSong--]);
        
        }
       
       
    });
    
    
     File f= new File("src/decoration.css");
     
     File f1= new File("src/mp3.jpg");
    File dragImg= new File("src/drag.PNG");
   // String dragImgAddress=getClass().getClassLoader().getResource(dragImg.getName()).toString();
   //String dragImgAddress=dragImg.getAbsolutePath();
  //String mp3ImgAddress=getClass().getClassLoader().getResource(f1.getName()).toString(); 
 //String mp3ImgAddress=f1.getAbsolutePath();
    Image img= new Image(getClass().getClassLoader().getResource(f1.getName()).toExternalForm());
      view =new ImageView(img);
   
     
      AnchorPane pane1 = new AnchorPane();
pane1.getStylesheets().add(getClass().getClassLoader().getResource(f.getName()).toExternalForm());
//pane1.getStylesheets().add(f.toURI().toString());
     pane1.getChildren().add(0, btn);
     pane1.getChildren().add(1, view);
     pane1.getChildren().add(2, stop);
    //btn.setStyle("-fx-border-radius:50;");
    //pane1.setMinSize(900, 900);
    btn.setScaleX(2);
    btn.setScaleY(2);
    btn.setLayoutX(220);
    btn.setLayoutY(10);
   
    stop.setScaleX(2);
    stop.setScaleY(2);
    stop.setLayoutX(330);
    
    stop.setLayoutY(10);
   
    
     view.setLayoutY(50);
     Scene scene= new Scene(pane1,630,650);
    
     pane1.getChildren().add(3, importB);
     pane1.getChildren().add(4, next);
     pane1.getChildren().add(5, previous);
     pane1.getChildren().add(6, seekBar);
     pane1.getChildren().add(7, playTime);
     playTime.setTextFill(Color.WHITE);
     playTime.setLayoutX(500);
     playTime.setLayoutY(600);
////// Imprt button      
     importB.setScaleX(1.5);
    importB.setScaleY(1.5);
    importB.setLayoutX(10);
    importB.setLayoutY(10);
 ////// next   
    next.setScaleX(1);
    next.setScaleY(1);
    next.setLayoutX(400);
    next.setLayoutY(10);
    seekBar.setLayoutY(600);
    seekBar.setLayoutX(200);
    seekBar.setScaleX(3);
    ////  previous
    previous.setScaleX(1);
    previous.setScaleY(1);
    previous.setLayoutX(110);
    previous.setLayoutY(10);
     primaryStage1.setTitle("Gaana Audio Player");
        primaryStage1.setResizable(true);
        primaryStage1.setScene(scene);
        primaryStage1.show();
      
        //////drag file
       scene.setOnDragEntered(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
           System.out.println("drag entered");
           Image img =new Image(getClass().getClassLoader().getResource(dragImg.getName()).toExternalForm());
           view.setImage(img);
           
           
       }
      
           
            
       });
       
       ///////////////////////////////////////////////////////////
       
       scene.setOnDragDropped(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
          System.out.println("drag Dropped");
                 db=e.getDragboard();
      
   File impSong= db.getFiles().get(0);
   
   if(!(impSong.getName().endsWith("mp3")) )
   {  JOptionPane.showMessageDialog(null, "File Not Supported,", "Error!", JOptionPane.ERROR_MESSAGE);
       e.consume();}
       else
       playMp3(impSong);
           System.out.println("sent to mp3");         
           System.out.println("drag dropped");
           
       }
      
           
           
       }); ///////////////////////////////////////
       
       
       ////////////////////////////////////////////
       
scene.setOnDragOver(new EventHandler<DragEvent>(){
public void handle(DragEvent e){
e.acceptTransferModes(TransferMode.ANY);
    System.out.println("Drag Over");
 
    

}

});
       
       ////////////////////////////////////////////////
       scene.setOnDragExited(new EventHandler <DragEvent>(){
       public void handle(DragEvent e){
           
           System.out.println(" Drag Extited");
           Image img =new Image(getClass().getClassLoader().getResource(f1.getName()).toExternalForm());
           view.setImage(img);
        
       }
           
           
       });
       
       ///////////////////////////////////////////
             
 
       
}

 
                
public void playMp3(File mp3File){
     song = new Media(mp3File.getAbsoluteFile().toURI().toString());
     player = new MediaPlayer(song);
player.setVolume(1.0);
     
     
     
            player.currentTimeProperty().addListener((Observable)->{
     if(seekBar.isValueChanging()){
      player.seek(Duration.seconds((seekBar.getValue()*(song.getDuration().toSeconds())/100)));
      player.seek(Duration.seconds(seekBar.getValue()));
     }
     if(seekBar.isPressed()){
      player.seek(Duration.seconds((seekBar.getValue()*(song.getDuration().toSeconds())/100)));
     }
       //updateValues();
        seekBar.setValue((player.getCurrentTime().toSeconds()*100)/song.getDuration().toSeconds());
        System.out.println("ok"+player.getCurrentTime().toSeconds());
          playTime.setText(String.valueOf(new DecimalFormat("#0.00").format(player.getCurrentTime().toMinutes()))+"  /");
      });

     
     
     
     
     
     
     
     
     
              ObservableMap<String,Object> meta_data=song.getMetadata();              
             //      File fff =new File("C:\\\\Users\\\\Ahmed Ali\\\\Desktop\\\\PTI.jpg");
             // Image art = new Image(fff.toURI().toString());
             // meta_data.putIfAbsent("image", (art)value);


     meta_data.addListener(new MapChangeListener<String,Object>(){
         
         
         @Override
          public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> ch) {  
     
             if(ch.wasAdded()){

                   String key=ch.getKey();
                   Object value=ch.getValueAdded(); 

                    
             switch(key){
               case "album":
                   System.out.println("Album: "+value.toString());
                   
                   break;
               case "artist":  
                   System.out.println("Artist: "+value.toString());
                   break;
               case "title":
                   System.out.println("Title: "+value.toString());
                   break;
               case "year":
                   System.out.println("Year: "+value.toString());
                   break;
               case "image":
               
                   containsimg=true;
                 
view.setImage((Image)value);
                   System.out.println("Album Art Found");

                   
                   break;

                   
                   
                   
             }
           
              }
             
          }
     });

     
   /* adding an album           
           
          
           {
                 
                   JFileChooser chooser =new JFileChooser();
                //FileNameExtensionFilter filter = new FileNameExtensionFilter(".mp3",".mp3");
                //chooser.setFileFilter(filter);
                int option=chooser.showOpenDialog(null);
                if(option==JFileChooser.APPROVE_OPTION)
                {File f = new File(chooser.getSelectedFile().getAbsolutePath());
                Image img= new Image(f.toURI().toString());  
                //meta_data.put("image", img);
                meta_data.putIfAbsent("image", img);
                   view.setImage(img);
                }
                   
                    
                 
                 
             }
 */                  
                   
                   
               
    
     
     containsimg=false;
     player.play();
    
   
}
 public static void main(String [] a){
     System.out.println(System.getProperties().getProperty("user.name"));
     launch(a);
     
     
 }               
                
                
                
                
                
                







    
}

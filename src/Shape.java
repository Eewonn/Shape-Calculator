import javax.swing.*;

public class Shape {
    private String name;
    
    //Constructor w/ perimeter
    public Shape(String name){
        System.out.println("Calculating the Perimeter and Calculating the Area respectively...");
        name = "";
    }

    //Accessor
    public String getName(){
        return name;
    }

    //Mutator
    public void setName(String nameSet){
        this.name = nameSet;
    }

    //Calculate Perimeter
    public double calculatePerimeter(){
        System.out.println("Calculating the Perimeter");
        return 0;
    }
    
    //Calculate Area
    public double calculateArea(){
        System.out.println("Calculate the Area");
        return 0;
    }

    public void inputShape(){
        //Override This Method
    }

    public void displayAreaPerimeter(){
        //Override This Method
    }

    //Choose Shape
    public static Shape chooseShape(){
        String[] option = {"Circle", "Rectangle", "Triangle"};
        String selectedShape = (String) JOptionPane.showInputDialog(null, 
        "Choose a Shape", "Shape Selection", 
        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        if(selectedShape == null){
            return null;
        }

        Shape shape = null;

        switch(selectedShape){
            case "Circle":
            // Create a Circle object
            shape = new Circle(); 
            break;

        case "Rectangle":
            // Create a Rectangle object
            shape = new Rectangle(); 
            break;

        case "Triangle":
            // Create a Triangle object
            shape = new Triangle(); 
            break;

        default:
            return null;
        }

        if(shape != null){
            //Set shapeName to selectedShape
            shape.setName(selectedShape);
            shape.inputShape();
        }
        return shape;
    } 
}

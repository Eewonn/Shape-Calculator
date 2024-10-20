import javax.swing.*;

public class Circle extends Shape{
    private double radius;

    //Constructor
    public Circle(){
        super("Circle");
    }

    //Accessor
    public double getRadius(){
        return radius;
    }

    //Mutator
    public void setRadius(double radiusSet){
        this.radius = radiusSet;
    }

    //@override methods
    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    //GUI-Based Methods
    public void inputCircle(){
        //JOptionPane Input
        String input = JOptionPane.showInputDialog(null, "Radius: ", 
        "Circle Input", JOptionPane.QUESTION_MESSAGE);

        //Input Error Checking
        try{
            //Convert JOptionPane Input String -> Double
            radius = Double.parseDouble(input); 

        }catch(NumberFormatException e){
            //If convertion failed -> Invalid Input
            JOptionPane.showMessageDialog(null, 
            "Invalid input, Please enter a valid number...", 
            "Error", JOptionPane.ERROR_MESSAGE);

            //Redo the method inputCircle
            inputCircle();
        }
    }

    public void displayArea(){
        inputCircle();
        //JOptionPane Area Result
        JOptionPane.showMessageDialog(null, 
        String.format("Area (Circle): %.2f", calculateArea()), 
        "Area of Circle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayPerimeter(){
        inputCircle();
        //JOptionPane Perimeter Result
        JOptionPane.showMessageDialog(null, 
        String.format("Perimeter (Circle): %.2f", calculatePerimeter()), 
        "Perimeter of Circle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayAreaPerimeter(){
        inputCircle();

        //JOptionPane Area and Perimeter Result using HTML Formatting
        JOptionPane.showMessageDialog(null, 
        "<html><table>" +
        "<tr><td style='text-align:left; padding-right: 10px;'>Area</td><td style='text-align:right; padding-left: 10px;'>" + 
        String.format(": %.2f", calculateArea()) + "</td></tr>" +
        "<tr><td style='text-align:left; padding-right: 10px;'>Perimeter</td><td style='text-align:right; padding-left: 10px;'>" + 
        String.format(": %.2f", calculatePerimeter()) + "</td></tr>" +
        "</table></html>", 
        "Area and Perimeter of Circle", 
        JOptionPane.INFORMATION_MESSAGE
        );
    }
}

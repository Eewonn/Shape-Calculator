import javax.swing.*;

public class testMain {
    public static void main(String[] args) throws Exception {
        //Laboratory 5 - Encapsulation and Inheritance

        JOptionPane.showMessageDialog(null, 
        "<html><div style='text-align: justify;'>This is a program that calculates and displays<br>" 
        + "the area and perimeter of different geometric shapes<br>" + "(Circle, Rectangle, and Triangle)</div></html>", 
        "Area/Perimeter Calculator", 
        JOptionPane.INFORMATION_MESSAGE);

        while(true){
            //Choose Shape
            Shape chosenShape = Shape.chooseShape();

            if(chosenShape != null){
                //Display Area and Perimeter of Chosen Shape
                chosenShape.displayAreaPerimeter();
            }else{
                System.out.println("No shape was selected.");
            }

            //Ask the user to continue or not
            int response = JOptionPane.showConfirmDialog(null, 
                    "Do you want to calculate another shape?", 
                    "Continue?", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);

            //End program if user select NO
            if (response == JOptionPane.NO_OPTION)
                break;
        }

        JOptionPane.showMessageDialog(null, 
        "Thank You For Using The Program.", "Exit", JOptionPane.INFORMATION_MESSAGE);
    }
}
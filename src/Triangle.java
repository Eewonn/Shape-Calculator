import javax.swing.*;

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    //Constructor
    public Triangle(){
        super("Triangle");
    }

    //Accessor
    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    //Mutator
    public void setSide1(double side1Set){
        this.side1 = side1Set;
    }

    public void setSide2(double side2Set){
        this.side2 = side2Set;
    }

    public void setSide3(double side3Set){
        this.side3 = side3Set;
    }

    //Override Methods
    @Override
    public double calculatePerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea(){
        return (side1*side2)/2;
    }

    //GUI-Based Methods
    public void inputTriangle(){
        //JPanel for Multiple Inputs
        JPanel panel = new JPanel();
        //Vertical Orientation for Panels
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //JTextField for Length and Width
        JTextField side1Field = new JTextField(5);
        JTextField side2Field = new JTextField(5);
        JTextField side3Field = new JTextField(5);

        //.add for Label and TextField adding
        panel.add(new JLabel("Side 1: "));
        panel.add(side1Field);
        panel.add(new JLabel("Side 2: "));
        panel.add(side2Field);
        panel.add(new JLabel("Side 3: "));
        panel.add(side3Field);

        //Ask for confirmation
        int result = JOptionPane.showConfirmDialog(null, panel, 
        "Triangle Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        //if OK do try, else(CANCEL) output "Cancelled Input"
        if(result==JOptionPane.OK_OPTION){
            try{
                //Convert JOptionPane Input String -> Double
                side1 = Double.parseDouble(side1Field.getText());
                side2 = Double.parseDouble(side2Field.getText());
                side3 = Double.parseDouble(side3Field.getText());
            }catch(NumberFormatException e){
                //If Convertion Failed -> Invalid Input
                JOptionPane.showMessageDialog(null, 
                "Invalid input, Please enter a valid number...", 
                "Error", JOptionPane.ERROR_MESSAGE);
                //Redo the method inputRectangle
                inputTriangle();
            }
        }else{
            JOptionPane.showMessageDialog(null, 
            "Input Cancelled...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void displayArea(){
        inputTriangle();
        //JOptionPane Area Result
        JOptionPane.showMessageDialog(null, 
        String.format("Area (Triangle): %.2f", calculateArea()), 
        "Area of Triangle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayPerimeter(){
        inputTriangle();
        //JOptionPane Perimeter Result
        JOptionPane.showMessageDialog(null, 
        String.format("Perimeter (Triangle): %.2f", calculatePerimeter()), 
        "Perimeter of Triangle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayAreaPerimeter(){
        inputTriangle();
        //JOptionPane Area and Perimeter Result using HTML Formatting
        JOptionPane.showMessageDialog(null, 
        "<html><table>" +
        "<tr><td style='text-align:left; padding-right: 10px;'>Area</td><td style='text-align:right; padding-left: 10px;'>" + 
        String.format(": %.2f", calculateArea()) + "</td></tr>" +
        "<tr><td style='text-align:left; padding-right: 10px;'>Perimeter</td><td style='text-align:right; padding-left: 10px;'>" + 
        String.format(": %.2f", calculatePerimeter()) + "</td></tr>" +
        "</table></html>", 
        "Area and Perimeter of Rectangle", 
        JOptionPane.INFORMATION_MESSAGE
        );
    }
}

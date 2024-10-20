import javax.swing.*;

public class Rectangle extends Shape{
    private double length;
    private double width;

    //Constructor
    public Rectangle(){
        super("Rectangle");
    }

    //Accessor
    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    //Mutator
    public void setLength(double lengthSet){
        this.length = lengthSet;
    }

    public void setWidth(double widthSet){
        this.width = widthSet;
    }

    //Override Methods
    @Override
    public double calculatePerimeter(){
        return 2 * (length + width);
    }
    
    @Override
    public double calculateArea(){
        return length * width;
    }

    //GUI-Based Methods
    public void inputRectangle(){
        //JPanel for Multiple Inputs
        JPanel panel = new JPanel();

        //Vertical Orientation for Panels
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //JTextField for Length and Width
        JTextField lengthField = new JTextField(5);
        JTextField widthField = new JTextField(5);

        //.add for Label and TextField adding
        panel.add(new JLabel("Length(Rectangle): "));
        panel.add(lengthField);
        panel.add(new JLabel("Width(Rectangle): "));
        panel.add(widthField);

        //Ask for confirmation
        int result = JOptionPane.showConfirmDialog(null, panel, 
        "Rectangle Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        //if OK do try, else(CANCEL) output "Cancelled Input"
        if(result==JOptionPane.OK_OPTION){
            try{
                //Convert JOptionPane Input String -> Double
                length = Double.parseDouble(lengthField.getText());
                width = Double.parseDouble(widthField.getText());

            }catch(NumberFormatException e){
                //If Convertion Failed -> Invalid Input
                JOptionPane.showMessageDialog(null, 
                "Invalid input, Please enter a valid number...", 
                "Error", JOptionPane.ERROR_MESSAGE);

                //Redo the method inputRectangle
                inputRectangle();
            }
        }else{
            JOptionPane.showMessageDialog(null, 
            "Input Cancelled...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void displayArea(){
        inputRectangle();
        //JOptionPane Area Result
        JOptionPane.showMessageDialog(null, 
        String.format("Area (Rectangle): %.2f", calculateArea()), 
        "Area of Rectangle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayPerimeter(){
        inputRectangle();
        //JOptionPane Perimeter Result
        JOptionPane.showMessageDialog(null, 
        String.format("Perimeter (Rectangle): %.2f", calculatePerimeter()), 
        "Perimeter of Rectangle", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayAreaPerimeter(){
        inputRectangle();
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

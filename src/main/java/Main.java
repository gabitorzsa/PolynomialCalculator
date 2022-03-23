import controller.Controller;
import model.Polynomial;
import view.View;

public class Main {
    public static void main(String[] args){
        View v = new View();                 // view
        Polynomial m = new Polynomial();     // model
        Controller c = new Controller(m, v); // controller
        v.setVisible(true);
        //2x^2+2x^1
    }
}

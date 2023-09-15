import composite.Component;
import composite.Composite;
import composite.Leaf;

public class App {
    public static void main(String[] args) throws Exception {
        
        Composite cesta = new Composite();

        Component laranja = new Leaf("laranja", 1.5);
        Component banana = new Leaf("banana", 2.5);
        Component maca = new Leaf("maca", 3.5);
        Composite saladaDeFrutas = new Composite();
        saladaDeFrutas.addComponent(laranja);
        saladaDeFrutas.addComponent(banana);
        saladaDeFrutas.addComponent(maca);

        cesta.addComponent(saladaDeFrutas);

        System.out.println(cesta);
        System.out.println(cesta.getPreco());
    }
}

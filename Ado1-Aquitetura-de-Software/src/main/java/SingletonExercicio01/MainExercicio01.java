package SingletonExercicio01;
/**
 *
 * @author Jefferson
 */
public class MainExercicio01 {

    public static void main(String[] args) {
        // exercício 01 Sigleton (Obtenha a instância única do Singleton)
        UsarSingleton singleton = UsarSingleton.getInstance();
        
        // Chame um método da instância Singleton
        singleton.showMessage();        
    }
} 



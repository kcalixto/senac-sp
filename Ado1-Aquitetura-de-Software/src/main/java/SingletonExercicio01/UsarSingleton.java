package SingletonExercicio01;

/**
 *@author Jefferson
 * 
 * 1) Escreva uma classe implementando o padrão singleton. Foi
apresentado, nas aulas, duas versões de classes com este
padrão. Utilize uma versão que a instancie somente ao invocar o
método de acesso global. Porém, essa mesma versão não poderá
ser “quebrada” em ambientes multi-threads.
 */

public class UsarSingleton {
    // Instância única da classe Singleton
    private static UsarSingleton instance;

    // Construtor privado para evitar a criação de novas instâncias
    private UsarSingleton() {
    }

    // Método público para obter a instância única
    public static UsarSingleton getInstance() {
        if (instance == null) {
            instance = new UsarSingleton();
        }
        return instance;
    }

    // Métodos adicionais da classe Singleton
    public void showMessage() {
        System.out.println("Esta é a instância Singleton.");
    }
}
/*Neste exemplo, a classe Singleton possui um construtor 
privado para evitar a criação de novas instâncias diretamente
e um método estático getInstance() que retorna a única instância
existente da classe. Quando você chama Singleton.getInstance(), 
obtém a mesma instância sempre que a classe é utilizada. Isso garante
que haja apenas uma única instância da classe Singleton em todo o programa.*/
import java.util.*;

public class Ex1_main {
    
    public static void main(String[] args){

        System.out.println("--------------------Welcome to Sweets--------------------");

        Database database = new Database();

        Employee e1 = new Employee("Maria Rafaela", 235, 3650);
        Employee e2 = new Employee("Sara Almeida", 268, 3650);
        Employee e3 = new Employee("Tiago Caridade", 436, 2850);
        Employee e4 = new Employee("Roberto Castro", 124, 4350);
        Employee e5 = new Employee("Aoki Lourenço", 98, 5350);

        database.addEmployee(e1); //Adicionar employees à database
        database.addEmployee(e2);
        database.addEmployee(e3);
        database.addEmployee(e4);
        database.addEmployee(e5);

        Employee [] employees = database.getAllEmployees(); //vetor com todos os employees adicionados

        System.out.println("All current employees :)");
        for (Employee e : employees){ //listar todos os employees atualmente na database
            if(e!=null)
                System.out.println(e);
        }
        System.out.println("\n");

        database.deleteEmployee(e3.getEmpNum()); //remover employee da database
        employees = database.getAllEmployees(); //atualizar database

        System.out.println("Oh no Tiago was dismissed :(");
        for (Employee e : employees){ //listar novamento todos os employees atuais
            if(e!=null)
                System.out.println(e);
        }
        System.out.println(database);

        System.out.println("\n");
        System.out.println("--------------------Welcome to Petiscos--------------------");

        Registos registos = new Registos();

        Empregado emp1 = new Empregado("José", "Madeira", 47583, 2930);
        Empregado emp2 = new Empregado("João", "Ferro", 83057, 2780);
        Empregado emp3 = new Empregado("Joaquim", "Cobre", 19274, 3500);
        Empregado emp4 = new Empregado("Jerónimo", "Alumínio", 54768, 1850);

        registos.insere(emp1);
        registos.insere(emp2);
        registos.insere(emp3);
        registos.insere(emp4);

        System.out.println( );
        System.out.println("~~~ Petiscos' Employees ~~~");
        System.out.println( );

        List<Empregado> list_empregados = registos.listaDeEmpregados();
        for(Empregado emp : list_empregados){
            if(emp != null){
                System.out.println(emp);
            }
        }

        System.out.println( );
        System.out.println("Boss: We need to reduce the number of employees, I can't do anything about it!");
        System.out.println("Joaquim: But Boss...");
        System.out.println("List of dismissed employees:");
        registos.remove(emp3.codigo());
        System.out.println(emp3);
        
        System.out.println("\nList of employees:");
        list_empregados = registos.listaDeEmpregados(); 
        for(Empregado emp : list_empregados){
            if(emp != null){
                System.out.println(emp);
            }
        }

        System.out.println( );
        System.out.println("Is José an employee?");
        if(registos.isEmpregado(emp1.codigo())){
            System.out.printf("Yes, " + emp1.nome() + " is an employee! \n");
        } else {
            System.out.printf("No, " + emp1.nome() + " is not an employee. :( \n");
        }

        System.out.println( );
        System.out.println("Is Joaquim an employee?");
        registos.isEmpregado(emp3.codigo());
        if(registos.isEmpregado(emp3.codigo())){
            System.out.printf("Yes, " + emp3.nome() + " is an employee! \n");
        } else {
            System.out.printf("No, " + emp3.nome() + " is not an employee. :( \n");
        }


        System.out.println("--------------------Welcome to Pst--------------------");

        Registos registos_pst = new Registos();
        Adapter adapter = new Adapter(registos_pst);

        Empregado emp_pst_1 = new Empregado("Rita", "Santos", 2543, 3550);
        Empregado emp_pst_2 = new Empregado("Alexandre", "Matias", 2347, 1900);
        Empregado emp_pst_3 = new Empregado("Paulo", "Pereira", 3564, 5400);

        adapter.addEmployee(emp_pst_1);
        adapter.addEmployee(emp_pst_2);
        adapter.addEmployee(emp_pst_3);

        System.out.println("All current employees :)");
        registos_pst.listaDeEmpregados();
        adapter.all_employees_print();

        System.out.println("Is Rita an employee?");
        if(adapter.isEmpregado(emp_pst_1.codigo())){
            System.out.printf("Yes, " + emp_pst_1.nome() + " is an employee! \n");
        } else {
            System.out.printf("No, " + emp_pst_1.nome() + " is not an employee. :( \n");
        }

        System.out.println("Oh no Rita was dismissed :(");
        adapter.deleteEmployee(emp_pst_1.codigo());
        registos_pst.listaDeEmpregados();
        adapter.all_employees_print();

    }
}
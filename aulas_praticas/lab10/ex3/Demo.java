//Mediator

package ex3;

import java.util.*;

public class Demo {
    public static void main(String[] args){

        // Map<Seguro, List<Cliente>> seguros1;
        // Map<Seguro, List<Cliente>> seguros2;

        // seguradoras
        Seguradora seguradora1 = new Seguradora("Tranquilidade"); // mediador
        Seguradora seguradora2 = new Seguradora("Fidelidade"); // mediador

        // seguros
        Seguro habitacao = new Seguro("Habitação", "350");
        Seguro automovel = new Seguro("Automóvel", "120");
        Seguro saude = new Seguro("Saúde", "70");
        Seguro acidentespessoais = new Seguro("Acidentes pessoais", "35");
        Seguro animais = new Seguro("Animais domésticos", "12");

        // create seguros - seguradora 1
        seguradora1.createSeguro(habitacao);
        seguradora1.createSeguro(automovel);
        seguradora1.createSeguro(saude);
        seguradora1.createSeguro(acidentespessoais);
        seguradora1.createSeguro(animais);

        // create seguros - seguradora 2
        seguradora2.createSeguro(habitacao);
        seguradora2.createSeguro(automovel);
        seguradora2.createSeguro(saude);
        seguradora2.createSeguro(acidentespessoais);
        seguradora2.createSeguro(animais);

        // clientes
        Cliente cliente1 = new Cliente("Ana Amaral", "anamaral@gmail.pt");
        Cliente cliente2 = new Cliente("Artur Silva", "tutuaz@gmail.pt");
        Cliente cliente3 = new Cliente("Francisco Andrade", "onlyfancisco@gmail.pt");
        Cliente cliente4 = new Cliente("Miguel Matias", "migmat@gmail.pt");
        Cliente cliente5 = new Cliente("Maria Miguel Rodrigues", "marimiro@gmail.pt");
        Cliente cliente6 = new Cliente("Beatriz Falcão", "bfalcao@gmail.pt");
        Cliente cliente7 = new Cliente("Renato Dias", "natitodias@gmail.pt");
        Cliente cliente8 = new Cliente("Maria Alvadia", "malvadia@gmail.pt");
        Cliente cliente9 = new Cliente("Daniel Dória", "doriadani@gmail.pt");
        Cliente cliente10 = new Cliente("Raquel Freixo","raqfreixo");
        Cliente cliente11 = new Cliente("Bernardo Godinho", "berdinho@gmail.pt");
        Cliente cliente12 = new Cliente("Manuel Fontoura", "montoura@gmail.pt");
        Cliente cliente13 = new Cliente("Luísa Capucho", "lucapucho@gmail.pt");
        Cliente cliente14 = new Cliente("Rafaela Abrunhosa", "mariaabr@gmail.pt");
        Cliente cliente15 = new Cliente("José David Macedo", "zemacedo@gmail.pt");

        // seguradora 1

        // seguro habitacao
        seguradora1.addSeguro(habitacao, cliente1);
        seguradora1.addSeguro(habitacao, cliente4);
        seguradora1.addSeguro(habitacao, cliente5);
        seguradora1.addSeguro(habitacao, cliente8);
        seguradora1.addSeguro(habitacao, cliente10);
        seguradora1.addSeguro(habitacao, cliente14);

        // seguro automovel
        seguradora1.addSeguro(automovel, cliente2);
        seguradora1.addSeguro(automovel, cliente6);
        seguradora1.addSeguro(automovel, cliente8);
        seguradora1.addSeguro(automovel, cliente9);
        seguradora1.addSeguro(automovel, cliente12);
        seguradora1.addSeguro(automovel, cliente15);

        // seguro saude
        seguradora1.addSeguro(saude, cliente3);
        seguradora1.addSeguro(saude, cliente7);
        seguradora1.addSeguro(saude, cliente9);
        seguradora1.addSeguro(saude, cliente11);
        seguradora1.addSeguro(saude, cliente12);
        seguradora1.addSeguro(saude, cliente15);

        // seguro acidentespessoais
        seguradora1.addSeguro(acidentespessoais, cliente5);
        seguradora1.addSeguro(acidentespessoais, cliente9);
        seguradora1.addSeguro(acidentespessoais, cliente13);

        // seguro animais
        seguradora1.addSeguro(animais, cliente2);
        seguradora1.addSeguro(animais, cliente14);
        
        // seguradora 2
        
        // seguro habitacao
        seguradora2.addSeguro(habitacao, cliente2);
        seguradora2.addSeguro(habitacao, cliente6);
        seguradora2.addSeguro(habitacao, cliente9);
        seguradora2.addSeguro(habitacao, cliente12);
       

        // seguro automovel
        seguradora2.addSeguro(automovel, cliente3);
        seguradora2.addSeguro(automovel, cliente7);
        seguradora2.addSeguro(automovel, cliente14);

        // seguro saude
        seguradora2.addSeguro(saude, cliente1);
        seguradora2.addSeguro(saude, cliente5);
        seguradora2.addSeguro(saude, cliente13);

        // seguro acidentespessoais
        seguradora2.addSeguro(acidentespessoais, cliente11);
        seguradora2.addSeguro(acidentespessoais, cliente12);

        // seguro animais
        seguradora2.addSeguro(animais, cliente6);
        seguradora2.addSeguro(animais, cliente8);
        seguradora2.addSeguro(animais, cliente10);
        
        // send mails - seguradora 1
        seguradora1.sendMail(habitacao, "   >> Segue em anexo o comprovativo do seguro efetuado.", cliente14);
        seguradora1.sendMail(acidentespessoais, "   >> Segue em anexo o comprovativo do seguro efetuado.", cliente5);
        seguradora1.sendMail(animais, "   >> Segue em anexo o comprovativo do seguro efetuado.", cliente2);

        // send mails - seguradora 2
        seguradora2.sendMail(automovel, "   >> Segue em anexo o comprovativo do seguro efetuado.", cliente7);
        seguradora2.sendMail(saude, "   >> Segue em anexo o comprovativo do seguro efetuado.", cliente13);
    }
}

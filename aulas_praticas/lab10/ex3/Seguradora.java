package ex3;

import java.util.*;

public class Seguradora implements SeguradoraInterface{
    // private ArrayList<Seguro> seguros;
    private Map<Seguro, List<Cliente>> seguros;
    private List<Cliente> clienteslist;
    
    private String seguradora_nome;

    public Seguradora(String seguradora_nome){
        seguros = new HashMap<>();
        clienteslist = new ArrayList<>();
        this.seguradora_nome = seguradora_nome;
    }

    public void createSeguro(Seguro seguro){
        seguros.put(seguro, clienteslist);
        // System.out.println(seguros);
    }

    public void addSeguro(Seguro seguro, Cliente cliente){
        seguros.get(seguro).add(cliente);
    }

    public String sendMail(Seguro seguro, String mail, Cliente cliente){
        // List<Cliente> clientes = seguros.get(seguro);
        for(Cliente c : seguros.get(seguro)){
            // System.out.println(c.getNome());
            if(c == cliente){
                cliente.receiveMail(seguradora_nome, seguro, mail);
                return "Received";
            }
        }
        return "Not Found";
        // for(Seguro seguro: seguros){
        //     if(seguro.getCliente() == cliente){
        //         cliente.receiveMail(mail);
        //     }
        // }


    }
}
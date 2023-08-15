package ex3;

public interface SeguradoraInterface{
    void createSeguro(Seguro seguro);
    void addSeguro(Seguro seguro, Cliente cliente);
    String sendMail(Seguro seguro, String mail, Cliente cliente); // sends mail to client
    // void sendMail(String mail, Seguro seguro);
}
package cripto_break;

import javax.swing.JOptionPane;

public class Cripto_Break {

    public static void main(String[] args) {
        String m = JOptionPane.showInputDialog("Qual a mensagem que deseja criptografar");
        
        System.out.println((Decodificacao(m)));
    }
    
    private static String Codificacao(String mensagem){
        char vet_cod [] = mensagem.toCharArray();
        char temp_d[] = new char [mensagem.length()];
        char temp_e[] = new char [mensagem.length()];
        
        String f_e = "";
        String f_d = "";
        String f = "";
        
        for (int i = 0; i < vet_cod.length;i++){
            if(i == 0 || i%2 == 0){
               f_e += vet_cod[i];
            }
            else{
               f_d += vet_cod[i];
            }
            
        }
        f = f_d + f_e;
        return f;
    }
    
    private static String Decodificacao(String mensagem){
        int t = mensagem.length();
        int tm = t/2;
        char vet_deco[] = new char [t];
        vet_deco = mensagem.toCharArray();
        char a_d [] = new char [t];
        char a_e [] = new char [t];
        String f = "";
        
        
        for(int i = 0; i < tm; i++)
        {
            a_d[i] += vet_deco[i];
        }
        
        for(int i = tm; i < t; i++)
        {
            a_e[i] += vet_deco[i];
        }
        
        for(int i = 0; i < t; i++)
        {
            f += a_d[i];
            f += a_e[i];
        }
        
        return f;
        
    }

}

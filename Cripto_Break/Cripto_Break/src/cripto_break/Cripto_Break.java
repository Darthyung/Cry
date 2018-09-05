package cripto_break;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Cripto_Break {

    public static void main(String[] args) {
        Object[] options = {"Criptografar","Descriptografar"};
        int cont = 0;
        int x = 0;
        JTextArea ta = new JTextArea(30,30);
        
        
        
        do{
        
        x = JOptionPane.showOptionDialog(null, "O que você quer fazer?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options);
        if(x == 0)
        {
            String m = JOptionPane.showInputDialog("Qual a mensagem que deseja criptografar");
            ta.setText(Codificacao(m));
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setCaretPosition(0);
            ta.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta),"Resultado",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(x == 1)
        {
            String m = JOptionPane.showInputDialog("Qual a mensagem que deseja Descriptografar");
            ta.setText(Decodificacao(m));
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setCaretPosition(0);
            ta.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(ta),"Resultado",JOptionPane.INFORMATION_MESSAGE);
        }
        
        cont = JOptionPane.showConfirmDialog(null, "Continuar?", "Continue?", JOptionPane.YES_NO_OPTION);
        
        }while(cont == 0);
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
        char vet_deco[] = new char [t];
        char va_d [] = new char [t];
        char va_e [] = new char [t];
        vet_deco = mensagem.toCharArray();
        String a_d;
        String a_e;
        String f = "";
        int tm;

        
        if (t == 0 || t %2 == 0){
            tm = t/2;
            a_d = mensagem.substring(tm, t);
            a_e = mensagem.substring(0,tm);
        }
        else {
            tm = (t-1)/2;
            a_d = mensagem.substring(tm, t);
            a_e = mensagem.substring(0,tm);
        }

        for (int i = 0; i < a_d.length(); i++){
            va_d[i] = a_d.charAt(i);
        }
        for (int i = 0; i < a_e.length(); i++){
            va_e[i] = a_e.charAt(i);
        }
        
        for (int i = 0; i < a_d.length(); i++){
            f += va_d[i];
            f += va_e[i];
        }        
        return f;   
    }
}

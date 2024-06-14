import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analizador de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel Ins = new JLabel("Introduce el texto a analizar:");
        Ins.setBounds(10, 20, 200, 25);
        panel.add(Ins);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 50, 360, 100);
        panel.add(scrollPane);

        JButton analizar = new JButton("Analizar");
        analizar.setBounds(10, 160, 100, 25);
        panel.add(analizar);

        JLabel num = new JLabel("Número de oraciones: ");
        num.setBounds(10, 190, 200, 25);
        panel.add(num);

        JLabel pal = new JLabel("Número de palabras: ");
        pal.setBounds(10, 220, 200, 25);
        panel.add(pal);

        JLabel let = new JLabel("Número de letras: ");
        let.setBounds(10, 250, 200, 25);
        panel.add(let);

        JLabel nume = new JLabel("Número de números: ");
        nume.setBounds(10, 280, 200, 25);
        panel.add(nume);

        analizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();

                int con = countSentences(text);
                int pala = countWords(text);
                int letra = countLetters(text);
                int numero = countNumbers(text);

                num.setText("Número de oraciones: " + con);
                pal.setText("Número de palabras: " + pala);
                let.setText("Número de letras: " + letra);
                nume.setText("Número de números: " + numero);
            }
        });
    }

    public static int countSentences(String text) {
        int count = 0;
        char[] puntuacio = {'.', '!', '?'};

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            for (char punctuation : puntuacio) {
                if (ch == punctuation) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countWords(String text) {
        int count = 0;
        boolean enpala = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ' || ch == '\n' || ch == '\t') {
                if (enpala) {
                    count++;
                    enpala = false;
                }
            } else {
                enpala = true;
            }
        }
        if (enpala) {
            count++;
        }
        return count;
    }

    public static int countLetters(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count++;
            }
        }
        return count;
    }
}

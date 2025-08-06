package GUI;

import javax.swing.*;

public class LanguageView extends JFrame {
    private JComboBox comboBox1;
    private JPanel contentPane;

    public  LanguageView(){

        setContentPane(contentPane);
        setTitle("LanguageSelector");
        setSize(200, 64);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }
}

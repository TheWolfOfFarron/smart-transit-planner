package Controlers;

import GUI.LanguageView;
import Utils.Language;
import Utils.Observerr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVCLanguage extends Observerr {
    LanguageView languageView;

    public MVCLanguage() {
        languageView = new LanguageView();
        languageView.getComboBox1().addItem("English");
        languageView.getComboBox1().addItem("Romana");
        languageView.getComboBox1().addItem("DEUTSCH");
        languageView.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) languageView.getComboBox1().getSelectedItem();
                if (s.equals("English")) {
                    Language.lang = "en";
                    Language.country = "UK";
                    Language.update();
                }
                if (s.equals("Romana")) {
                    Language.lang = "ro";
                    Language.country = "RO";
                    Language.update();
                }
                if (s.equals("DEUTSCH")) {
                    Language.lang = "ge";
                    Language.country = "GE";
                    Language.update();
                }

            }
        });
    }


}

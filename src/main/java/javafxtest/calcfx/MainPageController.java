package javafxtest.calcfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainPageController {

    @FXML
    private TextField entree;

    static boolean calcul_effectue = false;

    @FXML
    void Afficher0(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "0");
        calcul_effectue = false;
    }

    @FXML
    void Afficher1(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "1");
        calcul_effectue = false;
    }

    @FXML
    void Afficher2(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "2");
        calcul_effectue = false;
    }

    @FXML
    void Afficher3(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "3");
        calcul_effectue = false;
    }

    @FXML
    void Afficher4(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "4");
        calcul_effectue = false;
    }

    @FXML
    void Afficher5(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "5");
        calcul_effectue = false;
    }

    @FXML
    void Afficher6(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "6");
        calcul_effectue = false;
    }

    @FXML
    void Afficher7(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "7");
        calcul_effectue = false;
    }

    @FXML
    void Afficher8(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "8");
        calcul_effectue = false;
    }

    @FXML
    void Afficher9(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + "9");
        calcul_effectue = false;
    }

    @FXML
    void AfficherDiviser(ActionEvent event) {
        entree.setText(entree.getText() + "/");
        calcul_effectue = false;
    }

    @FXML
    void AfficherMoins(ActionEvent event) {
        entree.setText(entree.getText() + "-");
        calcul_effectue = false;
    }

    @FXML
    void AfficherPlus(ActionEvent event) {
        entree.setText(entree.getText() + "+");
        calcul_effectue = false;
    }

    @FXML
    void AfficherTime(ActionEvent event) {
        entree.setText(entree.getText() + "*");
        calcul_effectue = false;
    }

    @FXML
    void AfficherVirgule(ActionEvent event) {
        if (calcul_effectue) entree.setText("");
        entree.setText(entree.getText() + ".");
        calcul_effectue = false;
    }

    @FXML
    void Calcul(ActionEvent event) {
        calcul_effectue = true;

        if ((entree.getText().charAt(0) == '+') || (entree.getText().charAt(0) == '-') || (entree.getText().charAt(0) == '*') || (entree.getText().charAt(0) == '/') || (entree.getText().charAt(0) == '.')) {
            entree.setText("Erreur");
            return;
        }

        if ((entree.getText().charAt(entree.getText().length()- 1) == '+') || (entree.getText().charAt(entree.getText().length()- 1) == '-') || (entree.getText().charAt(entree.getText().length()- 1) == '*') || (entree.getText().charAt(entree.getText().length()- 1) == '/') || (entree.getText().charAt(entree.getText().length()- 1) == '.')) {
            entree.setText("Erreur");
            return;
        }

        try {
            List<Double> liste_nombre = new ArrayList<>();
            List<Character> liste_operateur = new ArrayList<>();
            Double calcul = 0.0;
            StringTokenizer stringTokenizer = new StringTokenizer(entree.getText(), " +-*/");
            while (stringTokenizer.hasMoreTokens()) {
                liste_nombre.add(Double.parseDouble(stringTokenizer.nextToken()));
            }

            for (char i : entree.getText().toCharArray()) {
                if ((i == '+') || (i == '-') || (i == '*') || (i == '/')) liste_operateur.add(i);
            }

            if (liste_operateur.isEmpty()) {
                entree.setText(liste_nombre.getFirst().toString());
                return;
            }

            for (int i = 0; i < liste_operateur.size(); i++) {
                if (liste_operateur.get(i) == '*') {
                    calcul = liste_nombre.get(i) * liste_nombre.get(i + 1);
                    liste_operateur.remove(liste_operateur.get(i));
                    liste_nombre.remove(liste_nombre.get(i + 1));
                    liste_nombre.remove(liste_nombre.get(i));
                    liste_nombre.add(i, calcul);
                }
            }

            for (int i = 0; i < liste_operateur.size(); i++) {
                if (liste_operateur.get(i) == '/') {
                    calcul = liste_nombre.get(i) / liste_nombre.get(i + 1);
                    liste_operateur.remove(liste_operateur.get(i));
                    liste_nombre.remove(liste_nombre.get(i + 1));
                    liste_nombre.remove(liste_nombre.get(i));
                    liste_nombre.add(i, calcul);
                }
            }

            for (int i = 0; i < liste_operateur.size(); i++) {
                if (liste_operateur.get(i) == '+') {
                    calcul = liste_nombre.get(i) + liste_nombre.get(i + 1);
                    liste_operateur.remove(liste_operateur.get(i));
                    liste_nombre.remove(liste_nombre.get(i + 1));
                    liste_nombre.remove(liste_nombre.get(i));
                    liste_nombre.add(i, calcul);
                }
            }

            for (int i = 0; i < liste_operateur.size(); i++) {
                if (liste_operateur.get(i) == '-') {
                    calcul = liste_nombre.get(i) - liste_nombre.get(i + 1);
                    liste_operateur.remove(liste_operateur.get(i));
                    liste_nombre.remove(liste_nombre.get(i + 1));
                    liste_nombre.remove(liste_nombre.get(i));
                    liste_nombre.add(i, calcul);
                }
            }

            if (calcul.equals(Math.floor(calcul))) {
                Integer a = (int) Math.floor(calcul);
                entree.setText(a.toString());
                return;
            }

            entree.setText(calcul.toString());
        } catch (Exception e) {
            entree.setText("Erreur");
        }

    }

}

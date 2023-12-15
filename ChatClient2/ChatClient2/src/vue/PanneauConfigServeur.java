package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adresseServeur, int portServeur) {
        // Initialise les champs de texte avec les valeurs passées en paramètres
        txtAdrServeur = new JTextField(adresseServeur);
        txtNumPort = new JTextField(String.valueOf(portServeur));

        // Crée un gestionnaire de disposition pour organiser les composants
        setLayout(new GridLayout(2, 2, 10, 10));

        // Ajoute des étiquettes et les champs de texte au panneau
        add(new JLabel("Adresse du serveur:"));
        add(txtAdrServeur);
        add(new JLabel("Numéro de port:"));
        add(txtNumPort);
    }
}

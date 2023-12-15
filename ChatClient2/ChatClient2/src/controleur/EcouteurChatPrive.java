package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;
import vue.PanneauChatPrive;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcouteurChatPrive extends EcouteurChatPublic {
    private String alias;

    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == bEnvoyer) {
            envoyerMessagePrive();
        } else if (source == bAccepterOuInviter) {
            envoyerCommandeJouerAuxEchecs();
        } else if (source == bRefuser) {
            envoyerCommandeRefuserEchecs();
        } else if (source == champSaisie) {
            traiterSaisie();
        } else {
            super.actionPerformed(e);
        }
    }

    private void envoyerCommandeJouerAuxEchecs() {
        // Envoyer au serveur la commande pour accepter de jouer aux échecs (CHESS)
        clientChat.envoyerCommande("CHESS");
    }

    private void envoyerCommandeRefuserEchecs() {
        // Envoyer au serveur la commande pour refuser de jouer aux échecs (DECLINE)
        clientChat.envoyerCommande("DECLINE");
    }

    private void traiterSaisie() {
        String texteSaisi = champSaisie.getText().trim();

        if (texteSaisi.equalsIgnoreCase("QUIT")) {
            // Envoyer au serveur la commande pour quitter le salon privé (QUIT)
            clientChat.envoyerCommande("QUIT");
        } else if (texteSaisi.equalsIgnoreCase("ABANDON")) {
            // Envoyer au serveur la commande pour abandonner la partie d'échecs (ABANDON)
            clientChat.envoyerCommande("ABANDON");
        } else {
            // Envoyer au serveur le texte saisi comme message privé (PRV)
            clientChat.envoyerCommande("PRV " + texteSaisi + " " + alias);
        }

        // Effacer le champ de saisie après traitement
        champSaisie.setText("");
    }
}

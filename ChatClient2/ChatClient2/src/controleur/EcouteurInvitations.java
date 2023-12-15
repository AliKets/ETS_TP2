package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Écouteur d'événements d'action pour la gestion des invitations.
 */
public class EcouteurInvitations implements ActionListener {
    private ClientChat clientChat;
    private PanneauInvitations panneauInvitations;

    /**
     * Constructeur de la classe.
     *
     * @param clientChat         Le client de chat.
     * @param panneauInvitations Le panneau d'invitations.
     */
    public EcouteurInvitations(ClientChat clientChat, PanneauInvitations panneauInvitations) {
        this.clientChat = clientChat;
        this.panneauInvitations = panneauInvitations;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("ACCEPTER".equals(actionCommand) || "REFUSER".equals(actionCommand)) {
            // Récupérer la liste des invitations sélectionnées
            List<String> invitationsSelectionnees = panneauInvitations.getElementsSelectionnes();

            // Vérifier l'action (ACCEPTER ou REFUSER) et envoyer les commandes au serveur
            String commande = ("ACCEPTER".equals(actionCommand)) ? "JOIN" : "DECLINE";
            for (String invitation : invitationsSelectionnees) {
                // Envoyer au serveur la commande correspondante pour chaque invitation
                clientChat.envoyerCommandeServeur(commande, invitation);
            }

            // Retirer les invitations sélectionnées de la liste
            for (String invitation : invitationsSelectionnees) {
                panneauInvitations.retirerInvitationRecue(invitation);
            }
        }
    }
}

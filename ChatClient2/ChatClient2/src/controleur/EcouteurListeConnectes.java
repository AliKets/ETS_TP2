package controleur;

import com.chat.client.ClientChat;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeConnectes extends MouseAdapter {

    private ClientChat clientChat;
    public EcouteurListeConnectes(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {  // Vérifiez si c'est un double-clic
            JList<String> listeConnectes = (JList<String>) evt.getSource();
            int index = listeConnectes.locationToIndex(evt.getPoint());  // Obtenez l'index de l'élément cliqué
            String alias = listeConnectes.getModel().getElementAt(index);

            // Envoyer une commande JOIN au serveur avec l'alias
            clientChat.envoyerCommande("JOIN " + alias);

            // Ajouter l'invitation reçue au panneau des invitations
            panneauInvitations.ajouterInvitationRecue(alias);
        }
    }

}

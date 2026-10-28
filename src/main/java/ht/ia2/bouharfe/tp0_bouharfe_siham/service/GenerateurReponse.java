package ht.ia2.bouharfe.tp0_bouharfe_siham.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service pour les modificateurs de question.
 * Un modificateur de question prend en entrée une question et retourne
 * la question modifiée.
 */
@Dependent // Portée CDI pour rendre la classe injectable par CDI dans les autres classes.
// Portée Dependent : l'instance sera supprimée quand la classe qui l'a injectée sera supprimée.
public class GenerateurReponse implements Serializable { // Serializable car CDI peut mettre l'instance en mémoire secondaire.
//    private boolean roleSystemeAffiche = false;

    /**
     * Analyse l'humeur exprimée dans la question.
     * Le rôle système détermine la présentation de la réponse.
     */
    public String genererReponse(String question, String roleSysteme) {
        String phrase = question.trim();
        String texte = phrase.toLowerCase(Locale.FRENCH);

        String humeur;
        String motDuJour;
        String message;

        if (texte.contains("stress") || texte.contains("peur")
                || texte.contains("difficile") || texte.contains("angoiss")) {
            humeur = "petit stress";
            motDuJour = "courage";
            message = "Un pas après l'autre, tu vas y arriver !";
        } else if (texte.contains("réussi") || texte.contains("reussi")
                || texte.contains("contente") || texte.contains("heureuse")
                || texte.contains("fière") || texte.contains("fiere")) {
            humeur = "victoire";
            motDuJour = "bravo";
            message = "Célèbre cette réussite, tu l'as méritée !";
        } else {
            humeur = "curiosité";
            motDuJour = "confiance";
            message = "Continue à poser des questions et à avancer !";
        }

        String analyse = "Ta phrase : " + phrase + "\n"
                + "Humeur détectée : " + humeur + "\n"
                + "Mot du jour : " + motDuJour + "\n"
                + "Message : " + message;

        if ("MIROIR_SIHAM".equals(roleSysteme)) {
            return "Le miroir magique de Siham \n"
                    + analyse + "\nTu brilles à ta façon !";
        }

        return " Carte d'humeur du jour \n" + analyse;
    }


}

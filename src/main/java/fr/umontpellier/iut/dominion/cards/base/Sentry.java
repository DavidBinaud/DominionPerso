package fr.umontpellier.iut.dominion.cards.base;


/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 */
public class Sentry extends Action {
    public Sentry() {
        super("Sentry", 5);
    }
}

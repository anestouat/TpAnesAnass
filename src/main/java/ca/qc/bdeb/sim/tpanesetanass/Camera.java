package ca.qc.bdeb.sim.tpanesetanass;

import javafx.geometry.Point2D;

/**
 * La caméra regarde une partie du niveau (qui est 8x plus large que l'écran).
 * <p>
 * Elle traduit une position dans le MONDE en position sur l'ÉCRAN :
 * xEcran = xMonde - xCamera
 * <p>
 * La caméra ne bouge qu'à l'horizontale, donc on garde seulement x.
 */
public class Camera {

    private double x = 0;

    public double getX() {
        return x;
    }


    public Point2D coordoEcran(Point2D positionMonde) {
        return positionMonde.subtract(x, 0);
    }


    public void suivre(Gontrand gontrand) {
        double xVoulu = gontrand.getGauche() - MainJavaFX.LARGEUR / 5;


        x = Math.max(x, xVoulu);

        x = Math.clamp(x, 0, Partie.LARGEUR_NIVEAU - MainJavaFX.LARGEUR);
    }


    public boolean estHorsEcran(ObjetDuJeu objet) {
        return objet.getDroite() < x
                || objet.getGauche() > x + MainJavaFX.LARGEUR
                || objet.getBas() < 0
                || objet.getHaut() > MainJavaFX.HAUTEUR;
    }


    public boolean estVisible(Point2D positionMonde) {
        return positionMonde.getX() >= x && positionMonde.getX() <= x + MainJavaFX.LARGEUR;
    }
}
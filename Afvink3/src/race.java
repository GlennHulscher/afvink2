//package afvink3;

/**
 * Race class
 * Class Race maakt gebruik van de class Paard
 *
 * @author Martijn van der Bruggen
 * @version alpha - aanroep van cruciale methodes ontbreekt
 * (c) 2009 Hogeschool van Arnhem en Nijmegen
 *
 * Note: deze code is bewust niet op alle punten generiek
 * dit om nog onbekende constructies te vermijden.
 *
 * Updates
 * 2010: verduidelijking van opdrachten in de code MvdB
 * 2011: verbetering leesbaarheid code MvdB
 * 2012: verbetering layout code en aanpassing commentaar MvdB
 * 2013: commentaar aangepast aan nieuwe opdracht MvdB
 *
 *************************************************
 * Afvinkopdracht: werken met methodes en objecten
 *************************************************
 * Opdrachten zitten verwerkt in de code *
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class race extends JFrame implements ActionListener {

    /**
     * declaratie van variabelen
     */
    /* (1) Declareer hier een constante int met de naam lengte en een waarde van 250 */
    final int lengte = 250;

    /* (2) Declareer hier h1, h2, h3, h4 van het type Paard
     *  Deze paarden instantieer je later in het programma
     */
    paard h1, h2, h3, h4, h5;
    /* (3) Declareer een button met de naam button van het type JButton */
    private JButton button1 = new JButton("Run");
    private JPanel panel;

    /**
     * Applicatie - main functie voor runnen applicatie
     */
    public static void main(String[] args) {
        race frame = new race();
        /* (4) Geef het frame een breedte van 400 en hoogte van 140 */
        frame.setSize(400, 280);
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /** Tekenen van de finish streep */
        /* (5) Geef de finish streep een rode kleur */
        g.setColor(Color.red);
        g.fillRect(lengte+10, 0, 3, 250);
        /**(6) Creatie van 4 paarden
         * Dit is een instantiering van de 4 paard objecten
         * Bij de instantiering geef je de paarden een naam en een kleur mee
         * Kijk in de class Paard hoe je de paarden
         * kunt initialiseren.
         */
        /** Loop tot een paard over de finish is*/

        h1 = new paard("1", Color.orange);
        h2 = new paard("2", Color.yellow);
        h3 = new paard("3", Color.green);
        h4 = new paard("4", Color.blue);
        h5 = new paard("5", Color.magenta);

        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte
                && h5.getAfstand() < lengte) {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            h5.run();

            /* (7) Voeg hier een aanroep van de methode pauzeer toe zodanig
             * dat er 1 seconde pauze is. De methode pauzeer is onderdeel
             * van deze class
             */
            pauzeer(100);

            /* (8) Voeg hier code in om 4 paarden te tekenen die rennen
             * Dus een call van de methode tekenPaard
             */
            tekenPaard(g, h1);
            tekenPaard(g, h2);
            tekenPaard(g, h3);
            tekenPaard(g, h4);
            tekenPaard(g, h5);
        }
        /** Kijk welk paard gewonnen heeft
         */
        if (h1.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h1.getNaam() + " heeft gewonnen!");
        }
        if (h2.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h2.getNaam() + " heeft gewonnen!");
        }
        if (h3.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h3.getNaam() + " heeft gewonnen!");
        }
        if (h4.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h4.getNaam() + " heeft gewonnen!");
        }
        if (h5.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h5.getNaam() + " heeft gewonnen!");
        }
    }

    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 250));
        panel.setBackground(Color.white);
        window.add(panel);
        /* (9) Zet hier de tekst Run! op de button */
        window.add(button1);
        button1.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, paard h) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResourceAsStream("31060.png"));
            g.drawImage(img, h.getAfstand(), 40 * h.getPaardNummer(), this);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }



    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
        startRace (paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }

}

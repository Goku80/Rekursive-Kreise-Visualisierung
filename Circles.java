import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

// Diese Klasse visualisiert rekursiv gezeichnete Kreise in einem JFrame.
class Circles extends JFrame
{
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};

    // Konstruktor der Klasse Circles.
    public Circles()
    {

        // Erstellt ein JPanel, das die Kreise zeichnet.
        var panel = new JPanel()
        {
            // Rekursive Methode zum Zeichnen von Kreisen.
            private void drawCircle(Graphics g, int x, int y, int radius, int iterations, int colorIndex)
            {
                if (iterations == 0)
                {
                    g.setColor(colors[colorIndex]);
                    g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius); // Zeichnet den Kreis.

                    return; // Basisfall: keine weiteren Iterationen.
                }


                drawCircle(g, x, y + radius + radius / 2, radius / 2, iterations - 1, (colorIndex + 1) % colors.length);
                drawCircle(g, x, y - radius - radius / 2, radius / 2, iterations - 1, (colorIndex + 1) % colors.length);
                drawCircle(g, x + radius + radius / 2, y, radius / 2, iterations - 1, (colorIndex + 1) % colors.length);
                drawCircle(g, x - radius - radius / 2, y, radius / 2, iterations - 1, (colorIndex + 1) % colors.length);

                g.setColor(colors[colorIndex]);
                g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius); // Zeichnet den Kreis.

            }

            @Override
            protected void paintComponent(Graphics g)
            {
                drawCircle(g, getWidth() / 2, getHeight() / 2, 80, 6, 0); // Zeichnet die Kreise.
            }
        };

        // Setzt die bevorzugte Größe des Panels.
        panel.setPreferredSize(new Dimension(512, 512));
        // Fügt das Panel zum JFrame hinzu.
        add(panel);
        // Passt die Größe des JFrame an die bevorzugte Größe des Panels an.
        pack();
        // Macht das Fenster sichtbar.
        setVisible(true);
    }

    // Hauptmethode, um die Kreise-Visualisierung zu starten.
    public static void main(String[] args)
    {
        new Circles();
    }
}

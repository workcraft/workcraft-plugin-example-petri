package org.workcraft.plugins.examples.petri;

import org.workcraft.annotations.DisplayName;
import org.workcraft.annotations.Hotkey;
import org.workcraft.annotations.SVGIcon;
import org.workcraft.dom.visual.DrawRequest;
import org.workcraft.dom.visual.VisualComponent;
import org.workcraft.gui.properties.PropertyDeclaration;
import org.workcraft.gui.tools.Decoration;
import org.workcraft.plugins.builtin.settings.VisualCommonSettings;
import org.workcraft.utils.Coloriser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@DisplayName("Place")
@Hotkey(KeyEvent.VK_P)
@SVGIcon("images/examples-petri-node-place.svg")
public class VisualPlace extends VisualComponent {

    public VisualPlace(Place place) {
        super(place);
        addPropertyDeclarations();
    }

    private void addPropertyDeclarations() {
        addPropertyDeclaration(new PropertyDeclaration<>(Integer.class, Place.PROPERTY_TOKENS,
                value -> getReferencedComponent().setTokenCount(value),
                () -> getReferencedComponent().getTokenCount())
                .setCombinable());
    }

    @Override
    public Place getReferencedComponent() {
        return (Place) super.getReferencedComponent();
    }

    @Override
    public Shape getShape() {
        double size = VisualCommonSettings.getNodeSize() - VisualCommonSettings.getStrokeWidth();
        double pos = -0.5 * size;
        return new Ellipse2D.Double(pos, pos, size, size);
    }

    @Override
    public void draw(DrawRequest r) {
        super.draw(r);
        Graphics2D g = r.getGraphics();
        Decoration d = r.getDecoration();
        g.setColor(Coloriser.colorise(getForegroundColor(), d.getColorisation()));
        int tokenCount = getReferencedComponent().getTokenCount();
        double tokenSize = 0.5 * VisualCommonSettings.getNodeSize();
        if (tokenCount == 1) {
            double tokenPos = -0.5 * tokenSize;
            g.fill(new Ellipse2D.Double(tokenPos, tokenPos, tokenSize, tokenSize));
        } else if (tokenCount > 1) {
            String tokenString = Integer.toString(tokenCount);
            Font font = g.getFont().deriveFont((float) tokenSize);
            Rectangle2D rect = font.getStringBounds(tokenString, g.getFontRenderContext());
            g.setFont(font);
            g.drawString(tokenString, (float) -rect.getCenterX(), (float) -rect.getCenterY());
        }
    }

    @Override
    public boolean hitTestInLocalSpace(Point2D pointInLocalSpace) {
        double size = VisualCommonSettings.getNodeSize() - VisualCommonSettings.getStrokeWidth();
        return pointInLocalSpace.distanceSq(0, 0) < size * size / 4;
    }
}

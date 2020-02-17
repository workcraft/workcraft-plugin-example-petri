package org.workcraft.plugins.examples.petri;

import org.workcraft.annotations.IdentifierPrefix;
import org.workcraft.annotations.VisualClass;
import org.workcraft.dom.math.MathNode;
import org.workcraft.exceptions.ArgumentException;
import org.workcraft.observation.PropertyChangedEvent;

@IdentifierPrefix("p")
@VisualClass(VisualPlace.class)
public class Place extends MathNode {
    public static final String PROPERTY_TOKENS = "Tokens";

    protected int tokenCount = 0;

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int value) {
        if (tokenCount != value) {
            if (value < 0) {
                throw new ArgumentException("The number of tokens cannot be negative.");
            }
            this.tokenCount = value;
            sendNotification(new PropertyChangedEvent(this, PROPERTY_TOKENS));
        }
    }
}

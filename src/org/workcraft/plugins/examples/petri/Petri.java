package org.workcraft.plugins.examples.petri;

import org.workcraft.dom.Container;
import org.workcraft.dom.math.AbstractMathModel;
import org.workcraft.dom.math.MathNode;
import org.workcraft.exceptions.InvalidConnectionException;
import org.workcraft.serialisation.References;

public class Petri extends AbstractMathModel {

    public Petri() {
        this(null, null);
    }

    public Petri(Container root, References refs) {
        super(root, refs);
    }

    @Override
    public void validateConnection(MathNode first, MathNode second) throws InvalidConnectionException {
        super.validateConnection(first, second);

        if ((first instanceof Place) && (second instanceof Place)) {
            throw new InvalidConnectionException("Connections between places are not allowed");
        }

        if ((first instanceof Transition) && (second instanceof Transition)) {
            throw new InvalidConnectionException("Connections between transitions are not allowed");
        }
    }
}

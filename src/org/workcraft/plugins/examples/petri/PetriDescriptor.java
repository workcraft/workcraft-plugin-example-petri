package org.workcraft.plugins.examples.petri;

import org.workcraft.dom.ModelDescriptor;

public class PetriDescriptor implements ModelDescriptor {

    @Override
    public String getDisplayName() {
        return "Petri Net (example)";
    }

    @Override
    public Petri createMathModel() {
        return new Petri();
    }

    @Override
    public VisualPetriDescriptor getVisualModelDescriptor() {
        return new VisualPetriDescriptor();
    }
}

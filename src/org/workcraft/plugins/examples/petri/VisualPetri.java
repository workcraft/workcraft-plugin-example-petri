package org.workcraft.plugins.examples.petri;

import org.workcraft.annotations.DisplayName;
import org.workcraft.dom.visual.AbstractVisualModel;
import org.workcraft.dom.visual.VisualGroup;
import org.workcraft.dom.generators.DefaultNodeGenerator;
import org.workcraft.gui.tools.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Petri Net")
public class VisualPetri extends AbstractVisualModel {

    public VisualPetri(Petri model) {
        this(model, null);
    }

    public VisualPetri(Petri model, VisualGroup root) {
        super(model, root);
        setGraphEditorTools();
    }

    private void setGraphEditorTools() {
        List<GraphEditorTool> tools = new ArrayList<>();
        tools.add(new SelectionTool());
        tools.add(new CommentGeneratorTool());
        tools.add(new ConnectionTool());
        tools.add(new NodeGeneratorTool(new DefaultNodeGenerator(Place.class)));
        tools.add(new NodeGeneratorTool(new DefaultNodeGenerator(Transition.class)));
        setGraphEditorTools(tools);
    }

    @Override
    public Petri getMathModel() {
        return (Petri) super.getMathModel();
    }
}

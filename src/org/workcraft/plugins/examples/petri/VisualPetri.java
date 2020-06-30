package org.workcraft.plugins.examples.petri;

import org.workcraft.annotations.DisplayName;
import org.workcraft.dom.generators.DefaultNodeGenerator;
import org.workcraft.dom.visual.AbstractVisualModel;
import org.workcraft.dom.visual.VisualGroup;
import org.workcraft.gui.tools.CommentGeneratorTool;
import org.workcraft.gui.tools.ConnectionTool;
import org.workcraft.gui.tools.NodeGeneratorTool;
import org.workcraft.gui.tools.SelectionTool;

@DisplayName("Petri Net")
public class VisualPetri extends AbstractVisualModel {

    public VisualPetri(Petri model) {
        this(model, null);
    }

    public VisualPetri(Petri model, VisualGroup root) {
        super(model, root);
    }

    @Override
    public void registerGraphEditorTools() {
        addGraphEditorTool(new SelectionTool());
        addGraphEditorTool(new CommentGeneratorTool());
        addGraphEditorTool(new ConnectionTool());
        addGraphEditorTool(new NodeGeneratorTool(new DefaultNodeGenerator(Place.class)));
        addGraphEditorTool(new NodeGeneratorTool(new DefaultNodeGenerator(Transition.class)));
    }

    @Override
    public Petri getMathModel() {
        return (Petri) super.getMathModel();
    }
}

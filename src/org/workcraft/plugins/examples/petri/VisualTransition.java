package org.workcraft.plugins.examples.petri;

import org.workcraft.annotations.DisplayName;
import org.workcraft.annotations.Hotkey;
import org.workcraft.annotations.SVGIcon;
import org.workcraft.dom.visual.VisualComponent;

import java.awt.event.KeyEvent;

@DisplayName("Transition")
@Hotkey(KeyEvent.VK_T)
@SVGIcon("images/examples-petri-node-transition.svg")
public class VisualTransition extends VisualComponent {

    public VisualTransition(Transition transition) {
        super(transition);
    }
}

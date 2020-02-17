package org.workcraft.plugins.examples.petri;

import org.workcraft.Framework;
import org.workcraft.plugins.Plugin;
import org.workcraft.plugins.PluginManager;

@SuppressWarnings("unused")
public class PetriPlugin implements Plugin {

    @Override
    public String getDescription() {
        return "Petri Net plugin (example)";
    }

    @Override
    public void init() {
        final Framework framework = Framework.getInstance();
        final PluginManager pm = framework.getPluginManager();
        pm.registerModelDescriptor(PetriDescriptor.class);
    }
}
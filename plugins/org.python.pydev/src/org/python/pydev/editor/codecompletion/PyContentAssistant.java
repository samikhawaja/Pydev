/**
 * Copyright (c) 2005-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Eclipse Public License (EPL).
 * Please see the license.txt included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
/*
 * Created on Aug 25, 2004
 *
 * @author Fabio Zadrozny
 */
package org.python.pydev.editor.codecompletion;

import org.python.copiedfromeclipsesrc.JDTNotAvailableException;
import org.python.pydev.shared_ui.content_assist.DefaultContentAssist;

/**
 * @author Fabio Zadrozny
 */
public class PyContentAssistant extends DefaultContentAssist {

    public PyContentAssistant() {
        super();
        enableColoredLabels(true);
        ContentAssistHackingAroundBugs.fixAssistBugs(this);
    }

    /**
     * Shows the completions available and sets the lastAutoActivated flag
     * and updates the lastActivationCount.
     */
    @Override
    public String showPossibleCompletions() {
        try {
            return super.showPossibleCompletions();
        } catch (RuntimeException e) {
            Throwable e1 = e;
            while (e1.getCause() != null) {
                e1 = e1.getCause();
            }
            if (e1 instanceof JDTNotAvailableException) {
                return e1.getMessage();
            }
            throw e;
        }
    }

}

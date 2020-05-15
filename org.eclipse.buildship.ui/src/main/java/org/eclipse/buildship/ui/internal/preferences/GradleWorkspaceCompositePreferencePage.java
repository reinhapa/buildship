/*******************************************************************************
 * Copyright (c) 2019 Gradle Inc.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/

package org.eclipse.buildship.ui.internal.preferences;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;

import org.eclipse.buildship.ui.internal.util.layout.LayoutUtils;
import org.eclipse.buildship.ui.internal.util.widget.GradleProjectGroup;
import org.eclipse.buildship.ui.internal.wizard.workspacecomposite.WorkspaceCompositeWizardMessages;

/**
 * Preference page for workspace composite configuration.
 *
 * @author Sebastian Kuzniarz
 */
@SuppressWarnings("unused")
public final class GradleWorkspaceCompositePreferencePage extends PropertyPage {

    public static final String PAGE_ID = "org.eclipse.buildship.ui.compositeproperties";

    private Text workspaceCompositeNameText;
    private Label compositeName;
    private GradleProjectGroup gradleProjectCheckboxtreeComposite;
    private Composite gradleWorkspaceCompositeSettingsComposite;

    @Override
    protected Control createContents(Composite parent) {
        this.gradleWorkspaceCompositeSettingsComposite = new Composite(parent, SWT.FILL);
        this.gradleWorkspaceCompositeSettingsComposite.setLayout(LayoutUtils.newGridLayout(2));

        // composite name container
        Composite workspaceCompositeNameComposite = new Composite(this.gradleWorkspaceCompositeSettingsComposite, SWT.FILL);
        GridLayoutFactory.fillDefaults().extendedMargins(0, 0, 0, 5).numColumns(2).applyTo(workspaceCompositeNameComposite);
        GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).span(3, SWT.DEFAULT).applyTo(workspaceCompositeNameComposite);

        // composite name label
        this.compositeName = new Label(workspaceCompositeNameComposite, SWT.NONE);
        this.compositeName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
        this.compositeName.setText(WorkspaceCompositeWizardMessages.Label_CompositeName);

        // composite name text field
        this.workspaceCompositeNameText = new Text(workspaceCompositeNameComposite, SWT.BORDER);
        this.workspaceCompositeNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        this.gradleProjectCheckboxtreeComposite = new GradleProjectGroup(this.gradleWorkspaceCompositeSettingsComposite, true);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3, SWT.DEFAULT).applyTo(this.gradleProjectCheckboxtreeComposite);

        return this.gradleWorkspaceCompositeSettingsComposite;
    }

    @Override
    public boolean performOk() {
       return true;
    }
}
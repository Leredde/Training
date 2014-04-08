package com.sii.rental.ui.views;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RentalPerspectiveSA implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addStandaloneView("com.sii.rental.ui.rentalproperty", false, IPageLayout.TOP, 0.4f, IPageLayout.ID_EDITOR_AREA);
		layout.addStandaloneView("com.sii.rental.ui.agency", false, IPageLayout.TOP, 0.6f, "com.sii.rental.ui.rentalproperty");
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}

package com.sii.rental.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;

public class RentalPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUIConstants {



	public RentalPreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("General preferences for Rental plugin");
	}

	public RentalPreferencePage(int style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

	public RentalPreferencePage(String title, int style) {
		super(title, style);
		// TODO Auto-generated constructor stub
	}

	public RentalPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		//DirectoryFieldEditor colorDirectoryFieldEditor = new DirectoryFieldEditor("DIR_COLOR", "Colors", getFieldEditorParent());
		//addField(colorDirectoryFieldEditor);
	}

}

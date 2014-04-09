package com.sii.rental.ui.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;

public class ColorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUIConstants {

	public ColorPreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("Color preferences for Rental plugin");
	}

	public ColorPreferencePage(int style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

	public ColorPreferencePage(String title, int style) {
		super(title, style);
		// TODO Auto-generated constructor stub
	}

	public ColorPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(COLOR_CUSTOMER, "Customer :", getFieldEditorParent()));
		addField(new ColorFieldEditor(COLOR_RENTAL, "Rental :", getFieldEditorParent()));
		addField(new ColorFieldEditor(COLOR_RENTOBJECT, "Rent Device :", getFieldEditorParent()));
	}

}

package com.sii.rental.ui.preferences;

import java.util.Map;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sii.rental.ui.Palette;
import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;

import org.eclipse.jface.preference.ComboFieldEditor;

public class ColorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUIConstants {

	/**
	 * @wbp.parser.constructor
	 */
	public ColorPreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription(Messages.ColorPreferencePage_0);
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
		
		Map<String, Palette> palettes = RentalUIActivator.getDefault().getPaletteManager();
		
		String[][] comboValues = new String[palettes.size()][2];
		int i = 0;
		for(Palette p : palettes.values())
		{
			comboValues[i][0] = p.getName();
			comboValues[i][1] = p.getId();	
			i++;
		}
		addField(new ComboFieldEditor(COMBO_PALETTE_PREFERENCE, Messages.ColorPreferencePage_other_labelText, comboValues, getFieldEditorParent()));
	}

}

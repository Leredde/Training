package com.sii.rental.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;

public class RentalPreferenceInitializer extends AbstractPreferenceInitializer implements RentalUIConstants {

	public RentalPreferenceInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = RentalUIActivator.getDefault().getPreferenceStore();
		store.setDefault(COLOR_CUSTOMER, StringConverter.asString(new RGB(0,120,250)));
		store.setDefault(COLOR_RENTAL, StringConverter.asString(new RGB(250,50,10)));
		store.setDefault(COLOR_RENTOBJECT, StringConverter.asString(new RGB(110,160,0)));

	}

}

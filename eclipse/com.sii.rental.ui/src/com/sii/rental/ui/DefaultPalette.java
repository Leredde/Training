package com.sii.rental.ui;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalObject;

public class DefaultPalette implements IColorProvider, RentalUIConstants {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		if (element instanceof Customer)
		{
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(COLOR_CUSTOMER));
		}
		else if (element instanceof Rental)
		{
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(COLOR_RENTAL));
		} 
		else if (element instanceof RentalObject) 
		{
			return getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(COLOR_RENTOBJECT));
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	private Color getAColor(String rgbKey)
	{
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		Color color = colorRegistry.get(rgbKey);
		if (color == null) 
		{
			colorRegistry.put(rgbKey,StringConverter.asRGB(rgbKey));
			color = colorRegistry.get(rgbKey);
		}
		
		return color;
	}
	
}

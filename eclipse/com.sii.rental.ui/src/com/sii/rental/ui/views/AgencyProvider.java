package com.sii.rental.ui.views;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sii.rental.ui.Palette;
import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;


public class AgencyProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalUIConstants {


	private class Node {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((agency == null) ? 0 : agency.hashCode());
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (agency == null) {
				if (other.agency != null)
					return false;
			} else if (!agency.equals(other.agency))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}

		String label;
		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		RentalAgency agency;
		
		public Node(String label, RentalAgency rentalAgency)
		{
			this.label = label;
			this.agency = rentalAgency;
		}
		
		public Object[] getChildren() {
			if (label == RentalUIConstants.NODE_CUSTOMER) {
				return agency.getCustomers().toArray();
			} else if (label == RentalUIConstants.NODE_RENTAL) {
				return agency.getRentals().toArray();
			} else if (label == RentalUIConstants.NODE_OBJECT) {
				return agency.getObjectsToRent().toArray();
			} else {
				return null;
			}
		}
		
		public Image getImage()
		{
			if (label == RentalUIConstants.NODE_CUSTOMER) {
				return RentalUIActivator.getDefault().getImageRegistry().get(RentalUIConstants.IMG_CUSTOMER);
			} else if (label == RentalUIConstants.NODE_RENTAL) {
				return RentalUIActivator.getDefault().getImageRegistry().get(RentalUIConstants.IMG_RENTAL);
			} else if (label == RentalUIConstants.NODE_OBJECT) {
				return RentalUIActivator.getDefault().getImageRegistry().get(RentalUIConstants.IMG_OBJECT);
			} else {
				return null;
			}
		}

		private AgencyProvider getOuterType() {
			return AgencyProvider.this;
		}
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof Node) {
			return ((Node)element).getImage();
		}
		return super.getImage(element);
	}
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		Object[] result = null;
		
		if (inputElement instanceof Collection<?>)
		{
			return ((Collection<?>) inputElement).toArray();
		}
		
		return result;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof RentalAgency)
		{
			Node[] nodes = {
					new Node(RentalUIConstants.NODE_CUSTOMER, (RentalAgency)parentElement),
					new Node(RentalUIConstants.NODE_RENTAL, (RentalAgency)parentElement),
					new Node(RentalUIConstants.NODE_OBJECT, (RentalAgency)parentElement)
			};
			
			return nodes;
		} else if(parentElement instanceof Node) {			
			return ((Node)parentElement).getChildren();
		
		} else {
			return null;
		}
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return ((element instanceof RentalAgency) || (element instanceof Node));
	}
	
	public String getText(Object element)
	{
		String result = "";
		if (element instanceof RentalAgency)
		{
			result = ((RentalAgency)element).getName();
		} else if (element instanceof Customer) {
			result = ((Customer)element).getFirstName() + " " + ((Customer)element).getLastName();
		} else if (element instanceof Node) {
			result = ((Node)element).getLabel();
		} else if (element instanceof RentalObject) {
			result = ((RentalObject)element).getName();
		} else if (element instanceof Rental) {
			result = ((Rental)element).toString();
		}
			
		
		return result;
	}

	@Override
	public Color getForeground(Object element) {
		
		String id = RentalUIActivator.getDefault().getPreferenceStore().getString(COMBO_PALETTE_PREFERENCE);
		Map<String, Palette> palettes = RentalUIActivator.getDefault().getPaletteManager();
		Palette palette = palettes.get(id);
		
		if (palette != null)
		{
			return palette.getColorProvider().getForeground(element);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		String id = RentalUIActivator.getDefault().getPreferenceStore().getString(COMBO_PALETTE_PREFERENCE);
		Map<String, Palette> palettes = RentalUIActivator.getDefault().getPaletteManager();
		Palette palette = palettes.get(id);
		
		if (palette != null)
		{
			return palette.getColorProvider().getBackground(element);			
		}
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

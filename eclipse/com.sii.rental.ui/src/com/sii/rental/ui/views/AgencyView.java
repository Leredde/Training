package com.sii.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sii.rental.core.RentalCoreActivator;
import com.sii.rental.ui.RentalUIActivator;
import com.sii.rental.ui.RentalUIConstants;

public class AgencyView extends ViewPart {

	AgencyProvider provider;
	TreeViewer treeViewer;

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		treeViewer = new TreeViewer(parent);
		provider = new AgencyProvider();
		agencies.add(RentalCoreActivator.getAgency());
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);
		treeViewer.setInput(agencies);

		// treeViewer is already a selection provider
		getSite().setSelectionProvider(treeViewer);	

		// To handle different providers, become a provider by implementing
		// ISelectionProvider and maintaining a focus info and returning it on getSelection


		setTreeViewerAsDragSource(treeViewer);
	}



	private void setTreeViewerAsDragSource(final TreeViewer viewer) {

		DragSource source = new DragSource(viewer.getControl(), DND.DROP_MOVE | DND.DROP_COPY);
		source.setTransfer(new Transfer[]{TextTransfer.getInstance(), RTFTransfer.getInstance(), URLTransfer.getInstance()});
		//source.setDragSourceEffect();

		source.addDragListener(new DragSourceAdapter()
		{			
			public void dragSetData(DragSourceEvent event)
			{
				ISelection selection = viewer.getSelection();
				if(selection instanceof IStructuredSelection)
				{
					Object selected = ((StructuredSelection) selection).getFirstElement();

					if (selected instanceof Customer) 
					{
						Customer customer = (Customer)selected;

						if(URLTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = RentalUIConstants.URL_SEARCH_WIKIPEDIA + customer.getDisplayName();
						}
						else if(RTFTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = "{\\rtf1\\b\\i " + customer.getDisplayName() + "}";
						}
						else if(TextTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = customer.getDisplayName();
						}
					} 
					else if (selected instanceof RentalObject) 
					{
						RentalObject object = (RentalObject)selected;

						if(URLTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = RentalUIConstants.URL_SEARCH_AMAZON + object.getName();
						}
						else if(RTFTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = "{\\rtf1\\b\\i " + object.getName() + "}";
						}
						else if(TextTransfer.getInstance().isSupportedType(event.dataType))
						{
							event.data = object.getName();
						}						
					}					
				}
			}
		});

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}

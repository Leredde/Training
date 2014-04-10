package com.sii.rental.ui.cmd.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;


public class CopyHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if (selection instanceof IStructuredSelection)
		{
			Object selected = ((StructuredSelection) selection).getFirstElement();
			
			if (selected instanceof Customer)
			{
				Customer customer = (Customer)selected;
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				
		        String textData = customer.getDisplayName();
		        //String rtfData = "{\\rtf1\\b\\i Hello World}";
		        TextTransfer textTransfer = TextTransfer.getInstance();
		        //RTFTransfer rtfTransfer = RTFTransfer.getInstance();
		        Transfer[] transfers = new Transfer[]{textTransfer};
		        Object[] data = new Object[]{textData};
		        clipboard.setContents(data, transfers);		
				
		        clipboard.dispose();				
			}
		}
		

		
		return null;
	}

}

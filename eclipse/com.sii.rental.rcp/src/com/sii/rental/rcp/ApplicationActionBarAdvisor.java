package com.sii.rental.rcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.jface.action.ToolBarManager;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction quitAction;
	private IAction preferencesAction;
	private IAction openPerspectiveDialogAction;
	private IAction openPerspectiveDialogAction_1;
	private IAction openPerspectiveDialogAction_2;
	private IAction openPerspectiveDialogAction_3;
	private IAction showViewMenuAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	{
    		quitAction = ActionFactory.QUIT.create(window);
    		register(quitAction);
    	}
    	{
    		preferencesAction = ActionFactory.PREFERENCES.create(window);
    		register(preferencesAction);
    	}
    	{
    		openPerspectiveDialogAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
    		register(openPerspectiveDialogAction);
    	}
    	{
    		openPerspectiveDialogAction_1 = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
    		register(openPerspectiveDialogAction_1);
    	}
    	{
    		openPerspectiveDialogAction_2 = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
    		register(openPerspectiveDialogAction_2);
    	}
    	{
    		openPerspectiveDialogAction_3 = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
    		register(openPerspectiveDialogAction_3);
    	}
    	{
    		showViewMenuAction = ActionFactory.SHOW_VIEW_MENU.create(window);
    		register(showViewMenuAction);
    	}
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	
    	MenuManager menuManager = new MenuManager("File");
    	menuBar.add(menuManager);
    	menuManager.add(preferencesAction);
    	menuManager.add(quitAction);
    	
    	MenuManager menuManager_1 = new MenuManager("Window");
    	menuBar.add(menuManager_1);
    	menuManager_1.add(showViewMenuAction);
    }
    
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
    	// TODO Auto-generated method stub
    	super.fillCoolBar(coolBar);
    	
    	ToolBarManager toolBarManager = new ToolBarManager();
    	coolBar.add(toolBarManager);
    	toolBarManager.add(openPerspectiveDialogAction);
    }
}

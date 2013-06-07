package eu.acsone.client.application.home;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.ViewImpl;

import eu.acsone.client.gxt.tabs.SimpleTabPanel;

public class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	private SimpleTabPanel folder;

	@Inject
	public HomePageView() {
		folder = new SimpleTabPanel();
	}

	@Override
	public Widget asWidget() {
		return folder;
	}

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		return folder.addTab(tabData, historyToken);
	}

	@Override
	public void removeTab(Tab tab) {
		folder.removeTab(tab);
	}

	@Override
	public void removeTabs() {
		folder.removeTabs();

	}

	@Override
	public void setActiveTab(Tab tab) {
		folder.setActiveTab(tab);
	}

	@Override
	public void changeTab(Tab tab, TabData tabData, String historyToken) {
		folder.changeTab(tab, tabData, historyToken);

	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == HomePagePresenter.TYPE_SetTabContent) {
			folder.setPanelContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	@Override
	public void setNextActiveTab(Tab tab) {
		folder.setNextActiveTab(tab);
		
	}	
}

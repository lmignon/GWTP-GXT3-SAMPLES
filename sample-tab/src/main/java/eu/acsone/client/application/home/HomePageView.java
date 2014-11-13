/**
 *    Authors: Laurent Mignon
 *    Copyright (c) 2012 Acsone SA/NV (http://www.acsone.eu)
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Affero General Public License as
 *    published by the Free Software Foundation, either version 3 of the
 *    License, or (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Affero General Public License for more details.
 *
 *    You should have received a copy of the GNU Affero General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

	@Override
	public void renderTabs() {
		folder.renderTabs();
		
	}	
}

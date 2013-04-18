/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
}

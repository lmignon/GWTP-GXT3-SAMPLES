package eu.acsone.client.gxt.tabs;

import com.google.gwt.user.client.ui.IsWidget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.gwtplatform.mvp.client.TabPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;

/**
 * This is a basic implementation of a {@link TabPanel} for GXT3 tabpanel. . A
 * {@link SimpleTabPanel} will hold a number of {@link SimpleTab}.
 */
public class SimpleTabPanel extends com.sencha.gxt.widget.core.client.TabPanel
		implements TabPanel {
	Tab currentActiveTab;

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		SimpleTab newTab = createNewTab(tabData);
		insert(newTab, (int) tabData.getPriority(),
				new TabItemConfig(tabData.getLabel()));
		newTab.setTargetHistoryToken(historyToken);
		return newTab;
	}

	@Override
	public void removeTab(Tab tab) {
		super.remove(tab.asWidget());
	}

	@Override
	public void removeTabs() {
		super.clear();
	}

	@Override
	public void setActiveTab(Tab tab) {
		if (currentActiveTab != null) {
			currentActiveTab.deactivate();
		}
		if (tab != null) {
			tab.activate();
		}
		currentActiveTab = tab;
	}

	@Override
	public void changeTab(Tab tab, TabData tabData, String historyToken) {
		tab.setTargetHistoryToken(historyToken);
		tab.setText(tabData.getLabel());
	}

	/**
	 * Sets the content displayed in the main panel.
	 * 
	 * @param panelContent
	 *            The {@link IsWidget} to set in the main panel, or {@code null}
	 *            to clear the panel.
	 */
	public void setPanelContent(IsWidget panelContent) {
		if (currentActiveTab != null) {
			((SimpleTab) currentActiveTab.asWidget()).clear();
			if (panelContent != null) {
				((SimpleTab) currentActiveTab.asWidget()).add(panelContent);
			}
		}
	}

	/**
	 * Returns a new tab of the type specific for this tab panel.
	 * 
	 * @param tabData
	 *            Some data on the tab to create.
	 * @return The new tab.
	 */
	protected SimpleTab createNewTab(TabData tabData) {
		// TODO Try using assisted injection here (to inject UiBinder in
		// SimpleTab)
		return new SimpleTab(tabData, this);
	}
}

package eu.acsone.client.gxt.tabs;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

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

	// a map sorted by priority used to keep the expected tab order
	SortedMap<TabData, SimpleTab> tabsConfig = new TreeMap<TabData, SimpleTab>(
			new Comparator<TabData>() {
				@Override
				public int compare(TabData o1, TabData o2) {
					return Float.compare(o1.getPriority(), o2.getPriority());
				}
			});

	@Override
	public Tab addTab(TabData tabData, String historyToken) {
		SimpleTab newTab = createNewTab(tabData);
		tabsConfig.put(tabData, newTab);
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
		tab.activate();
	}

	@Override
	public void changeTab(Tab tab, TabData tabData, String historyToken) {
		tab.setTargetHistoryToken(historyToken);
		tab.setText(tabData.getLabel());
		((SimpleTab)tab).activateHistoryToken();
	}

	/**
	 * Sets the content displayed in the main panel.
	 * 
	 * @param panelContent
	 *            The {@link IsWidget} to set in the main panel, or {@code null}
	 *            to clear the panel.
	 */
	public void setPanelContent(IsWidget panelContent) {
		// GXTTabContainerPresenter call the setActiveTab before the
		// setPanelContent
		// Therefore we can use the currentActiveTab as content
		if (currentActiveTab != null) {
			SimpleTab sTab = (SimpleTab) currentActiveTab.asWidget();
			IsWidget currentContent = sTab.getWidget();
			if (panelContent != null && currentContent != panelContent) {
				sTab.clear();
				sTab.add(panelContent);
				sTab.forceLayout();
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
		return new SimpleTab(tabData, this);
	}

	public void setNextActiveTab(Tab tab) {
		currentActiveTab = tab;
	}

	/**
	 * insert tabs in the priority defined order
	 */
	public void renderTabs() {
		int index = 0;
		for (Entry<TabData, SimpleTab> entry : tabsConfig.entrySet()) {
			SimpleTab simpleTab = entry.getValue();
			insert(simpleTab, index, new TabItemConfig(entry.getKey()
					.getLabel()));
			simpleTab.activateHistoryToken();
			index += 1;

		}
	}
}

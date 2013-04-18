package eu.acsone.client.gxt.tabs;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;
import com.gwtplatform.mvp.client.TabData;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;

/**
 * This is a basic implementation of a {@link Tab} for GXT3
 * A {@link SimpleTab} is added to a {@link SimpleTabPanel}.
 */
public class SimpleTab extends ContentPanel implements Tab {
    
    private final float priority;
    private final TabPanel parent;

    public SimpleTab(TabData tabData, TabPanel parent) {
        super();
        this.parent = parent;
        this.setHeaderVisible(false);
        priority = tabData.getPriority();
    }

    @Override
    public void activate() {
      parent.setActiveWidget(this);
    }

    @Override
    public Widget asWidget() {
        return this;
    }

    @Override
    public void deactivate() {
    }

    @Override
    public float getPriority() {
        return priority;
    }

    @Override
    public String getText() {
        return parent.getConfig(this).getText();
    }

    @Override
    public void setTargetHistoryToken(String historyToken) {
    	Hyperlink hl = new Hyperlink(getText(), historyToken);
    	hl.toString();
    	setText(hl.toString());
    }

    @Override
    public void setText(String text) {
      TabItemConfig config = parent.getConfig(this);
      config.setHTML(text);
      parent.update(this, config);
    }
}
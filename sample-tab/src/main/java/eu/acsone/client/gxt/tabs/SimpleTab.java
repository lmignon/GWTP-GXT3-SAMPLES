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
    private String historyToken;

    public SimpleTab(TabData tabData, TabPanel parent) {
        super();
        this.parent = parent;
        this.setHeaderVisible(false);
        priority = tabData.getPriority();
    }
    
    public void activateHistoryToken(){
    	Hyperlink hl = new Hyperlink(getText(), historyToken);
    	hl.toString();
    	setText(hl.toString());
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
    	this.historyToken = historyToken;
    }

    @Override
    public void setText(String text) {
      TabItemConfig config = parent.getConfig(this);
      config.setHTML(text);
      parent.update(this, config);
    }
}

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
package eu.acsone.client.application;

import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class ViewPanels {
	private Viewport viewport = new Viewport();
	private ContentPanel centerPanel = new ContentPanel();

	public ViewPanels() {
		getCenterPanel().setBodyBorder(false);
		getCenterPanel().setHeaderVisible(false);
		SimpleContainer outerContainer = new SimpleContainer();
		outerContainer.setBorders(false);

		// center
		BorderLayoutContainer borderLayoutContainer = new BorderLayoutContainer();
		outerContainer.add(borderLayoutContainer, new MarginData(0, 0, 0, 0));
		{
			borderLayoutContainer.setBorders(false);
			borderLayoutContainer.setCenterWidget(getCenterPanel());
		}

		getViewport().add(outerContainer);
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	public ContentPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(ContentPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
}

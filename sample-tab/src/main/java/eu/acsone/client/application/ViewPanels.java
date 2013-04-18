package eu.acsone.client.application;

import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.*;
import com.sencha.gxt.widget.core.client.container.*;

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

package eu.acsone.client.application;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements
		ApplicationPresenter.MyView {

	private ViewPanels viewPanels;

	@Inject
	public ApplicationView() {
		viewPanels = new ViewPanels();
	}

	@Override
	public Widget asWidget() {
		return viewPanels.getViewport();
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ApplicationPresenter.SLOT_content) {
			if (content != null) {

				viewPanels.getCenterPanel().clear();
				viewPanels.getCenterPanel().add(content);
				viewPanels.getCenterPanel().forceLayout();
			}
		} else {
			super.setInSlot(slot, content);
		}
	}
}
